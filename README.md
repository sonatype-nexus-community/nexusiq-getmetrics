# nexusiq-getmetrics
![Coverage](.github/badges/jacoco.svg)

## Getting Started

### Prerequisites
  * Java 8+

### Download the app 
  * There are two ways to run this application, by directly running the application jar file (Option A) or with the application docker image (Option B)
  * In both cases, start by downloading the zip file. To do so, go to the Releases pane on the right side of this page and click on the latest release
  * Click on the *nexusiq-getmetrics-[releasenumber].zip* file on the assets page to download it
  * Unzip the contents into a directory of your choice
  * Change into the *nexusiq-getmetrics-[releasenumber]* directory (this will be your working directory)

```
unzip nexusiq-getmetrics-[releasenumber].zip
cd nexusiq-getmetrics-[releasenumber]
```

### Quickstart

#### Default Nexus IQ setting:

* user = admin
* password = admin123
* server = http://localhost:8070
* period frequency = MONTH
* start month = 2021-01
* finish month = current month
* all organisations and appplications

Edit the *config/application.properties* to change any of these accordingly

Run script
```
sh runapp.sh
```

#### To run it with the docker image
* Edit the *config/application.properties* and change the url for the IQ server
* Simply switch the commented out *iq.url* property
```
sh runapp-docker.sh
```

### Selecting Organisations and Applications
To select a specific list of organisations or applications to report on
* Edit the *config/application.properties* file
* For Organisations, add a list of comma-separated Organisation names to *iq.api.sm.payload.organisation.name=* 
* For Applications, add a list of comma-separated Applications names to *iq.api.sm.payload.application.name=* 
* If both are set, Organisations will take precedence



![image](https://user-images.githubusercontent.com/35227270/141003665-fb2fc00e-6784-4e56-af6f-6c75e2d9d397.png)

## The Fine Print
* We recommend running it for 4 weeks of data at a time and for sets of orgs instead of the full scope if you have a large dataset.
* It is worth noting that this is NOT SUPPORTED by Sonatype, and is a contribution of ours to the open source community (read: you!)

* Don't worry, using this community item does not "void your warranty". In a worst case scenario, you may be asked by the Sonatype Support team to remove the community item in order to determine the root cause of any issues.

* Remember:

* Use this contribution at the risk tolerance that you have
* Do NOT file Sonatype support tickets related to iq-success-metrics
* DO file issues here on GitHub, so that the community can pitch in
* Phew, that was easier than I thought. Last but not least of all:

* Have fun creating and using this application and the Nexus platform, we are glad to have you here!


