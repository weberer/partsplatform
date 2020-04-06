package xyz.weberer.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Product : Table() {
    val id: Column<Int> = Product.integer("id")
    val productId: Column<Int> = Product.integer("product_id")
    val productName: Column<String> = Product.varchar("product_name", 100)
    val categoryName: Column<String> = Product.varchar("category_name", 100)
}
