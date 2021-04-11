echo "Launching CryptoGlobal Core Testing Version..."
echo "INSTALL MODE, DO NOT LAUNCH THIS AGAIN OR YOU WILL CHANGE THE KEYS/ADRESS !!"
echo "GENESIS Block Hash =>"
sha256sum genesis.txt
echo "Generating you're keys..."
openssl genrsa -out private-key.pem 3072
openssl rsa -in private-key.pem -pubout -out public-key.pem
echo "Keys Generated"
echo "Adress Generation"
sha256sum public-key.pem
echo ""
echo "INSTALL DONE , LAUNCH CRYPTOGLOBAL CORE TO CONNECT"