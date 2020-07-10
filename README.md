# meta-wandboard-qt
Yocto layer to add Qt support in a wandboard image

## Dependencies
This layer depends on:

```
URI: git://git.yoctoproject.org/poky.git
branch: dunfell

URI: git://git.openembedded.org/meta-openembedded
branch: dunfell

URI: git://git.yoctoproject.org/meta-security.git
branch: dunfell

URI: https://github.com/jumpnow/meta-jumpnow.git
branch: dunfell

URI: https://github.com/jumpnow/meta-wandboard
branch: dunfell
```

## Setup
See https://jumpnowtek.com/wandboard/Wandboard-Systems-with-Yocto.html for a detailed description on how to setup the Yocto build environment.

## Image
This layers add a new image called *qt-image*. It contains all the stuff (hopefully) needed to run Qt applications on an iMX.6 platform.
It does not provide a compositor, i.e. you can run the app only with `-platform eglfs`
It only supports kernel 5.4 and 5.7, see your local.conf.

## Run an Application
It seems like /dev/dri/card0 and /dev/dri/card1 are switched with the 5.7 kernel compared to 4.14.x, so I needed a kms config file, e.g.
```bash
#!/bin/bash

export QT_QPA_EGLFS_ALWAYS_SET_MODE=1

cat <<- EOF > /tmp/kms.config
	{
		"device" : "/dev/dri/card1",
		"hwcursor" : false,
		"pbuffers" : true,
		"outputs": [
    		 {
      			"name": "VGA1",
      			"mode": "off"
    		 },
    		 {	
      			"name": "HDMI1",
      			"mode": "1024x768"
    		 } 
  		]	
	}
EOF
export QT_QPA_EGLFS_KMS_CONFIG=/tmp/kms.config

/home/root/application -platform eglfs $@
```
