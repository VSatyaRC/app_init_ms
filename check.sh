if ! lsof -i:8080
then
    echo 8080 is free
else
    echo 8080 is occupied
fi
