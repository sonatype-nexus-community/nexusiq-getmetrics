# nexusiq-getmetrics

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

user = admin
password = admin123
server = http://localhost:8070
period frequency = MONTH
start month = 2021-01
finish month = current month

Edit the config/application.properties to change amy of these accordingly

Run script
```
sh runapp.sh
```

#### To run it with the docker image
Edit the config/application.properties and change the url for the IQ server
Simply switch the commented out *iq.url* property
Then
```
sh runapp-docker.sh
```


