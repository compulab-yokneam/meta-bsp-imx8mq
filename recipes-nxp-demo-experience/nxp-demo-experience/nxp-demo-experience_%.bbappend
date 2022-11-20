# Copyright 2022 CompuLab
# Make it work with the CompuLab imx8mq boards
do_install:prepend() {
	sed -i "s/\(\"compatible.*imx8mq.*\)\",/\1, ${MACHINE}\", /g" ${WORKDIR}/demos/demos.json
}
