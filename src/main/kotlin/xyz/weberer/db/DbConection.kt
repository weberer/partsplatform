package xyz.weberer.db

import org.jetbrains.exposed.sql.Database

class DbConnection {
    private val host = "jdbc:postgresql://lemans-fse.cpzikpn3bsaa.us-east-2.rds.amazonaws.com:5432/postgres"
    private val driver = "org.postgresql.Driver"
    private val user = "lemans"
    private val password = "lemans"

    fun getConnection(): Database {
        return Database.connect(host, driver, user, password)
    }
}