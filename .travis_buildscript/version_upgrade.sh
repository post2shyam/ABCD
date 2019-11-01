#!/usr/bin/env bash
pwd
ls
sed -i  "/VERSION_BUILD=/ s/=.*/=$TRAVIS_BUILD_NUMBER/" ./app/version.properties
