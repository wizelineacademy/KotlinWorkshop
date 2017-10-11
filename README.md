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
