# Data Loader

This data loader connects to a PostgreSQL database hosted as an AWS RDBS instance.
table creation scripts are located inside of `/src/main/kotlin/xyz/weberer/db/scripts`.
Connection information for the DB is located in `/src/main/kotlin/xyz/weberer/db/DbConnection.kt`.

### Running
Run main() in `/src/main/kotlin/xyz/weberer/db/dataImport/DataImport.kt`