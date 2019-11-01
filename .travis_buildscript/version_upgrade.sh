#!/usr/bin/env bash
sed -i '' "/VERSION_BUILD=/ s/=.*/=$TRAVIS_BUILD_NUMBER/" ./app/version.properties
