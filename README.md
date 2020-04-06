# Parts Platform

A live version of this demo application can be viewed at http://www.weberer.xyz.
One thing to mention about the live version is that the first time it is loaded after
being dormant for a while takes a significantly longer to return the product JSON. I assume
this has to do w/ AWS loading the lambda function.

The repository is divided into 3 branches:
   1. **angularApp** (this branch) - This is the web application. The live version is hosted in AWS Amplify.
   This branch was generated using Angular CLI, and can be run using `ng serve`, built using `ng build`.
   2. **aws-lambda** - This is branch contains a Kotlin based AWS lambda function that queries the database, performs som basic
   formatting, builds a JSON array and attaches it to the HTTP response.
   3. **data-import** - This branch contains some SQL scripts to create the tables, and a small Kotlin app to load the CSV files into
   the database.

The database is PostgreSQL running in an AWS RDS instance. The connection information for it is located in the data-import branch. 

Each branch of the repository has a README containing information about the branch and how to run it.
