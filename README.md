## Test Task Solution

A command-line Java program that fetches data from the following public APIs:
[https://api.coindesk.com/v1/bpi/historical/close.json?start=2013-09-01&end=2013-09-05&currency=eur](https://api.coindesk.com/v1/bpi/historical/close.json?start=2013-09-01&end=2013-09-05&currency=eur)

[https://api.coindesk.com/v1/bpi/currentprice/eur.json](https://api.coindesk.com/v1/bpi/currentprice/eur.json)

Once executed, the program should request the user to input a currency code (USD, EUR, GBP, etc.)

Once the user provides the currency code, the application should display the following information:
-	The current Bitcoin rate, in the requested currency
-	The lowest Bitcoin rate in the last 30 days, in the requested currency
-	The highest Bitcoin rate in the last 30 days, in the requested currency

## Getting Started

Clone the repository [https://github.com/chrisimoni/bitcoin-price-index.git](https://github.com/chrisimoni/bitcoin-price-index.git) 

### Running from IDE

* Open the project in your favourite IDE
* Run the BitcoinPriceIndexDriver.java

### Running with Maven (Terminal)
* Navigate to project directory in the terminal
* Run the command 'mvn clean -U package' to package as a JAR file
* Run the command 'java -jar target/bitcoin-price-index.jar' to execute the JAR file:

### Running Docker image
* Pull the image from Docker hub with the command 'docker pull chrisreal/bitcoin-price-index'
* Run the command 'docker run -it bitcoin-price-index' to execute


 


