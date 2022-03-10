package org.sonatype.cs.getmetrics.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class UtilService {

	private UtilService() {
	}

	public static String removeLastChar(String s) {
		return (s == null || s.length() == 0) ? null : (s.substring(0, s.length() - 1));
	}

	public static void writeCsvFile(String filename, List<String[]> data) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
			writeCsvDataToBufferedWriter(data, writer);
		}
	}

	public static void writeCsvDataToBufferedWriter(List<String[]> data, BufferedWriter writer) throws IOException {
		for (String[] array : data) {
			writer.write(String.join(",", Arrays.asList(array)));
			writer.newLine();
		}
	}

}
