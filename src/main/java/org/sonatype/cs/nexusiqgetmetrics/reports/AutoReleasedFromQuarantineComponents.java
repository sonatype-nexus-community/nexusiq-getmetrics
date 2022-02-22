package org.sonatype.cs.nexusiqgetmetrics.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.cs.nexusiqgetmetrics.service.CsvFileService;
import org.sonatype.cs.nexusiqgetmetrics.service.FileIoService;
import org.sonatype.cs.nexusiqgetmetrics.util.FilenameInfo;
import org.sonatype.cs.nexusiqgetmetrics.util.ParseReasons;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.ArrayList;
import java.util.List;

public class AutoReleasedFromQuarantineComponents implements CsvFileService {
    private static final Logger log = LoggerFactory.getLogger(AutoReleasedFromQuarantineComponents.class);

    @Override
    public void makeCsvFile(FileIoService f, JsonReader reader) {
    }

    // @Override
    // public void makeCsvFile(FileIoService f, JsonObject dataObject) {
    //     log.info("Making AutoReleasedFromQuarantineComponents report");

    //     List<String[]> data = new ArrayList<>();
    //     data.add(FilenameInfo.autoReleasedFromQuarantineComponentsFileHeader);

    //     JsonArray results = dataObject.getJsonArray("results");

    //     for (JsonObject result : results.getValuesAs(JsonObject.class)) {
    //         String displayName = result.getString("displayName");
    //         String repository = result.getString("repository");
    //         String quarantineDate = result.getString("quarantineDate");
    //         String dateCleared = result.getString("dateCleared");

    //         String[] line = {displayName, repository, quarantineDate, dateCleared};
    //         data.add(line);
    //     }

    //     f.writeCsvFile(FilenameInfo.autoReleasedFromQuarantineComponentsCsvFile,  data);
    // }

    @Override
    public void makeCsvFile(FileIoService f, JsonObject dataObject) {
        log.info("Making AutoReleasedFromQuarantineComponents report");

        List<String[]> data = new ArrayList<>();
        data.add(FilenameInfo.autoReleasedFromQuarantineComponentsFileHeader);

        JsonArray results = dataObject.getJsonArray("results");

        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
            String displayName = result.getString("displayName");
            displayName = displayName.replaceAll(" ", "");
            String repository = result.getString("repository");
            String quarantineDate = result.getString("quarantineDate");
            String dateCleared = result.getString("dateCleared", "none");
            boolean quarantined = result.getBoolean("quarantined");

            JsonObject componentIdentifier = result.getJsonObject("componentIdentifier");
            String format = componentIdentifier.getString("format");

            JsonArray quarantinePolicyViolations = result.getJsonArray("quarantinePolicyViolations");
            for (JsonObject quarantinePolicyViolation: quarantinePolicyViolations.getValuesAs(JsonObject.class)){
                String policyName = quarantinePolicyViolation.getString("policyName");
                int threatLevel = quarantinePolicyViolation.getInt("threatLevel");

                JsonArray constraintViolations = quarantinePolicyViolation.getJsonArray("constraintViolations");
                for (JsonObject constraintViolation : constraintViolations.getValuesAs(JsonObject.class)){
                    JsonArray reasons = constraintViolation.getJsonArray("reasons");
                    String reason = ParseReasons.getReason(policyName, reasons);

                    String[] line = {repository, quarantineDate, dateCleared, displayName, format, String.valueOf(quarantined), policyName, String.valueOf(threatLevel), reason};
                    data.add(line);
                }
            }
        }

        f.writeCsvFile(FilenameInfo.autoReleasedFromQuarantineComponentsCsvFile,  data);

    }
}
