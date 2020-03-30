# CL-SOM-iMX8 Linux Kernel Building

Supported machines:

* `cl-som-imx8`

Define a `MACHINE` environment variable with respect to a required machine:
<pre>
export MACHINE=cl-som-imx8
</pre>

## Prerequisites
It is up to developer to setup arm64 build environment:
* Download a tool chain from [Linaro](https://releases.linaro.org/components/toolchain/binaries/7.3-2018.05/aarch64-linux-gnu/)
* Set environment variables:
<pre>
export ARCH=arm64
export CROSS_COMPILE=/usr/bin/aarch64-linux-gnu-
</pre>

# CompuLab Linux Kernel setup
* Create a folder to organize the files:
<pre>
mkdir imx8mq
cd imx8mq
</pre>

* Download CompuLab BSP
<pre>
git clone -b devel-next https://github.com/compulab-yokneam/meta-bsp-imx8mq.git
export PATCHES=$(pwd)/meta-bsp-imx8mq/recipes-kernel/linux/compulab/imx8mq
</pre>

* Download NXP linux-imx
<pre>
git clone https://source.codeaurora.org/external/imx/linux-imx.git
git -C linux-imx checkout -b linux-compulab rel_imx_4.14.98_2.0.0_ga
</pre>

* Apply the CompuLab patches
<pre>
git -C linux-imx am ${PATCHES}/*.patch
</pre>

# Compile the Kernel
<pre>
make -C linux-imx ${MACHINE}_defconfig
make -C linux-imx
</pre>

# Compile device tree files only
<pre>
make -C linux-imx dtbs
</pre>

# Update the platform defconfig

* Modify the current config
<pre>
make -C linux-imx menuconfig
</pre>

* Save the current config
<pre>
make -C linux-imx savedefconfig
cp linux-imx/defconfig linux-imx/arch/arm64/configs/${MACHINE}_defconfig
</pre>

* Commit the changes
<pre>
git -C linux-imx commit --signoff --message "cl-som-imx8: Updated defconfig" arch/arm64/configs/${MACHINE}_defconfig
</pre>
