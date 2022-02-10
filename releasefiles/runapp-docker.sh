#!/bin/sh

workdir=$(pwd)
#ts=$(date +"%d%m%Y:%H%M%S")
#metricsdir=${workdir}/iqmetrics-${ts}
metricsdir=${workdir}/iqmetrics

docker run --rm -it -v ${workdir}:/config -v ${metricsdir}:/iqmetrics ghcr.io/sonatype-nexus-community/nexusiq-getmetrics:@APPVER@


