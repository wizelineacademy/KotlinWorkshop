# Kotlin Workshop

A bitcoins convert to teach how to use Kotlin

## How to

The `master` has the final project running. It is a command line dollar to bitcoin converter. The intention is to follow the steps from 1 up to 9 (each step is `git tag`) and complete the challenges described in the TODO's. Each step is described below

### Step 1

The step 1 shows how to configure a Kotlin project using Gradle, the challenges in step are:

- Apply the Kotlin plugin
- Add Kotlin build script dependency
- Add the Kotlin standard library

### Step 2

On step 2 we print our first hello world

- Create the main function
- Print on stdout the *Hello World* message

### Step 3

In step 3 the first class should be created, and the tests are introduced, from now all steps should have the unit tests passing

- Create a class property
- Uses *@SerializedName* to read the json value
- Make the tests pass

### Step 4

Create the first function in a way that makes the tests pass

- Create a function named "execute" that returns a list of Tickers
- Inside the execute function uses the *dataSource.getTickets* using *"bitcoin"* as coin
- The previous method returns a retrofit object, you need to call their execute() method and then call the body() method
- At this point you have a nullable list, uses the safe call *"?."* to filter the list to have only bitcoin tickers: *?.filter { it.id == "bitcoin" }*
- Uses the elvis operator to send an emptyList if you receive a null: *?: emptyList()*

### Step 5

We see the data class powers in action.

- Create a data class named *DollarBitcoinModel*
- Add two string values to DollarBitcoinModel data class named: *dollar* and *bitcoin*
- Make the tests pass

### Step 6

lets extend it

- Create a extension function to Double class named *toBitcoin()*
- Use the pattern "0.00000000 BTC" to format the double value and return a string
- Make the tests pass

### Step 7

The step 7 you will use the previous classes to fill a function that converts the dollar to bitcoin

- Go to *DollarBitcoinConverter* class and inside the method *execute* do the follow steps:
- Using the safe operator *"?."* call to *toDoubleOrNull* to get the double value from the dollar argument and save on a value named *amount*
- Using the smart cast check if the amount is a non null double: *"if (amount is Double)"*
- If the amount is null throw an IllegalArgumentException with the message *"Cannot convert $dollar"*
- If the amount is a valid non null double, call *"getBitcoinTicker.execute()"* to get a list of tickers to make the conversion
- Filter the ticker list to remove all null tickers and all tickers with null price: *".mapNotNull { it.price?.toDoubleOrNull() }"*
- Filter again to remove values less than zero: *.filter { it > 0.0 }*
- Map the list to have the converted value: *.map { amount / it }*
- Map the list with converted values to our data class model: *.map { DollarBitcoinModel(amount.toDollar(), it.toBitcoin()) }*
- Get the first element of the list or null if after the filters we have no more elements: *.firstOrNull()*
- Uses the elvis operator *"?:"* to throw an NoSuchElementException with the message *"No available ticker"* if the pipe result is null
- Make the tests pass

# Step 8

Putting all together

- Go to *Main.kt* file and inside the *main* function do the follow:
- Print the question: *"How much dollars do you want to convert?"*
- Read the user input with *"readLine()"* and save it on a value
- Print the message *"Please wait meanwhile I convert it"*
- Create a *DollarBitcoinConverter* instance
- Call the *"execute"* function sending the user input and save the return into a value named *model*
- Print the follow message: *"${model.dollar} dollars is equal to ${model.bitcoin}"*
- Put the *"execute"* call inside a try/catch and if there is an exception print: *"Error ${e.message}"*

# Step 9 - Ad Libitum

Fork the project and try to implement some of the following features:

- Bitcoin to dollar converter (the reverse hand)
- Convert to another cryptocurrency (Dashcoin, Ether, Dogecoin, Litecoin, etc…)
- Convert to other currencies (Pesos, Euro, Yen, Real, etc…)
- Add GUI (Graphical User Interface), it can be done with an Android application, or a website, or even the native Java GUI library.
