#!/bin/bash
echo "Start:"
echo "Dest: $1"
export TEST=test1
echo $TEST
x_default=`source $1_x.sh`
read -p "X [$x_default]: " x
y=${x:-$x_default}
echo "echo \"$y\"" > $1_x.sh
echo $y
