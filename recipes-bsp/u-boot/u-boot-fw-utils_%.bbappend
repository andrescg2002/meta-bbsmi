################################################################################
# Generic patches.
################################################################################
FILESEXTRAPATHS_prepend := "${THISDIR}/patches:"

SRC_URI_append = " file://0001-Change-console-parameters.patch"
