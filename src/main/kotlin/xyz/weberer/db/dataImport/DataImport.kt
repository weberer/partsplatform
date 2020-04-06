package xyz.weberer.db.dataImport

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import xyz.weberer.db.DbConnection
import xyz.weberer.db.tables.Part
import xyz.weberer.db.tables.Product

fun main() {
    DbConnection().getConnection()

    importProducts()
    importParts()
}

fun importProducts() {
    val productsFilePath = "C:\\users\\weber\\desktop\\products.csv"
    val reader = CSVReader(productsFilePath)

    println("Loading data from products.csv")
    while(reader.hasNext()) {
        val product = reader.getNext()

        transaction {
            Product.insert {
                it[productId] = product!!.get("\uFEFFproductId").toString().toInt()
                it[productName] = product["productName"].toString()
                it[categoryName] = product["categoryName"].toString()
            }
        }
    }
    println("Finished loading data from products.csv")
}

fun importParts() {
    val partsFilePath = "C:\\users\\weber\\desktop\\parts.csv"
    val reader = CSVReader(partsFilePath)

    println("Loading data from parts.csv")
    while(reader.hasNext()) {
        val part = reader.getNext()

        transaction {
            Part.insert {
                it[punctuatedPartNumber] = part!!.get("\uFEFFpunctuatedPartNumber").toString()
                it[description] = part["partDescr"].toString()
                it[productId] = part["productId"].toString().toInt()
                it[originalRetailPrice] = part["originalRetailPrice"].toString().toBigDecimal()
                it[brandName] = part["brandName"].toString()
                it[assetUrl] = part[""].toString()
            }
        }
    }
    println("Finished loading data from parts.csv")
}