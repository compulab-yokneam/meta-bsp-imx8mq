# Disclaimer

| !IMPORTANT! | This is a development branch, that is not relelased by CompuLab officially yet|
|---|---|

# Configuring the build

## Setup Yocto environment

* WorkDir:
```
mkdir compulab-nxp-bsp && cd compulab-nxp-bsp
```
* Set a CompuLab machine:

| Machine | Command Line |
|---|---|
|cl-som-imx8|```export MACHINE=cl-som-imx8```|

## Initialize repo manifests

* NXP
```
repo init -u https://source.codeaurora.org/external/imx/imx-manifest -b imx-linux-kirkstone -m imx-5.15.32-2.0.0.xml
```

* CompuLab
```
mkdir -p .repo/local_manifests
wget --directory-prefix .repo/local_manifests https://raw.githubusercontent.com/compulab-yokneam/meta-bsp-imx8mq/kirkstone/scripts/meta-bsp-imx8mq.xml
```

* Sync Them all
```
repo sync
```

## Setup build environment

* Initialize the build environment:
```
source compulab-setup-env -b build-${MACHINE}
```

* Building the image:
```
bitbake -k imx-image-full
```

* Building the bootloader file only:

| build command | binary file location |
|---|---|
|```bitbake -k imx-boot```|```${BUILDDIR}/tmp/deploy/images/${MACHINE}/imx-boot-tagged```|

## Deployment
### Create a bootable sd card

* Goto the `tmp/deploy/images/${MACHINE}` directory:
```
cd tmp/deploy/images/${MACHINE}
```

* Deploy the image:
```
sudo bmaptool copy imx-image-full-${MACHINE}.wic.bz2 --bmap imx-image-full-${MACHINE}.wic.bmap /dev/sdX
```
