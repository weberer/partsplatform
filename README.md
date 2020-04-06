#aws-lambda application

This branch holds the AWS lambda function that receives an HTTP POST request. On receipt of this request, the PostgreSQL
database (hosted as an AWS RDBS instance) is queried, and the results formatted into a JSON array, which is returned to
the sender.

###Building Instructions
Run `./gradlew shadowJar` from the main project directory. This will produce a single .jar which can be uploaded to an
AWS labda function 

###Testing Instructions
Run tests in `/test/kotlin/xyz/weberer/ProductSummaryTest.kt`
<br>
<br>
###Running Instructions
Because this application is designed to run inside of an AWS lambda function, it is not possible to truly run unless
ran inside of a remote or local lambda function.

The `main()` function in `/test/kotlin/xyz/weberer/ProductSummaryTest.kt` to view the returned value of `getSummaryData()`
in the console. When running, the result of this function is returned as a string.

