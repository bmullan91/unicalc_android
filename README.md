[![Build Status](https://travis-ci.org/bmullan91/unicalc.svg?branch=master)](https://travis-ci.org/bmullan91/unicalc)

#UniCalc

A super-simple weighted calculator for working out percentages. __Ideal__ for figuring out your overall grade at school or university.

[Get the app from Google's play store.](https://play.google.com/store/apps/details?id=unicalc_android.main)


#Getting Started
----------------

##Prerequisites

 - [Node.js](http://nodejs.org/) must be installed.
 - As this is an [Intellij](http://www.jetbrains.com/idea/) project it must also be installed.

##Steps

###Clone the repository

 - clone the repository `git clone https://github.com/bmullan91/unicalc_android`
 - `cd unicalc_android/`
 
###Initialise the webapp submodule

 - `git submodule init`
 - `git submodule update`
 - `cd assests/webapp/`
 - `npm install`
 - There are two .gz file's in one of the dependencies that must be removed before the app will run. `rm node_modules/gulp/node_modules/semver/semver.browser.js` and `rm node_modules/gulp/node_modules/semver/semver.min.js.gz`.
 

###You're ready! Hit the run button.

