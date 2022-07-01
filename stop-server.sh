#!/bin/sh
echo "Stopping servers";
#fuser -k -n tcp 8500 &
fuser -k -n tcp 8550 &
fuser -k -n tcp 8600 &
fuser -k -n tcp 8650 &
fuser -k -n tcp 8700 &
#fuser -k -n tcp 8761 &
#fuser -k -n tcp 8750 &

