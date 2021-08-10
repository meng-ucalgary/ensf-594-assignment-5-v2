#!/bin/bash

# clear the screen
clear

# compile the files
javac -sourcepath src -d bin src/*java

# run
java -cp "bin" App
