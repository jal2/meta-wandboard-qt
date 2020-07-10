LINUX_VERSION = "5.7"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

SRC_URI += " file://defconfig "

