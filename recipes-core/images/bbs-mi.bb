SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.digitalcomtech.com"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image
inherit extrausers

EXTRA_USERS_PARAMS = "useradd syrus; \
                      usermod -P renoC963* root; \
                      usermod -P syrus4* syrus; \
                      "

CORE_OS = " \        
    openssh \    
    openssh-keygen \
    openssh-sftp-server \    
    tzdata \
    sudo \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \    
 "

WIFI_BT_SUPPORT = " \
    bt-fw \
    crda \
    hostapd \
    iw \
    libnl \
    openssl \
    wireless-regdb \
    wireless-tools \
    wl18xx-fw \
    wl18xx-target-scripts \
    wlconf \
    wpa-supplicant \
"

OPTIONAL_EXTRA_TOOLS = " \
    bridge-utils \    
    emmc-installer \
    ethtool \    
    htop \        
    less \
    nano \        
 "

EXTRA_TOOLS_INSTALL = " \    
    devmem2 \               
    findutils \    
    i2c-tools \
    iftop \
    iperf3 \
    iptables \        
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \    
    wget \
    wvdial \
    zip \    
 "

CAN_TOOLS = " \
    canutils \
    libsocketcan \
    iproute2 \
 "

GSTREAMER_INSTALL = " \ 
    gstreamer \ 
    gst-plugins-base \ 
    gst-plugins-good \ 
    gst-plugins-bad \ 
    gst-plugins-ugly \ 
    gst-meta-base \   
" 

FFMPEG_INSTALL = " \ 
    ffmpeg \  
    v4l-utils \ 
" 

DEV_SDK_INSTALL = " \
    nodejs \	
    redis \		 
"

NODE_MODULES = " \
    serialport \
    gps \	
    ioredis \    	 
"

OPTIONAL_DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-modules \
 "

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho \
    spiloop \
 "

IMAGE_INSTALL += " \
    ${CAN_TOOLS} \
    ${CORE_OS} \   
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${WIFI_BT_SUPPORT} \
    ${FFMPEG_INSTALL} \
    ${DEV_SDK_INSTALL} \    
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \    
 "

export IMAGE_BASENAME = "full-image"
