#!/bin/bash
echo "Dest: $1"
if [ -e $1_x.sh ] 
then 
x_default=`source $1_x.sh` 
else 
x_default="x default" 
fi
read -p "X: " -e -i "$x_default" x
y=${x:-$x_default}
echo "echo \"$y\"" > $1_x.sh
echo $y
