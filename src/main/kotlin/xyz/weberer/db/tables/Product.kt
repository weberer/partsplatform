package xyz.weberer.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Product: Table() {
    val id: Column<Int> = integer("id")
    val productId: Column<Int> = integer("product_id")
    val productName: Column<String> = varchar("product_name", 100)
    val categoryName: Column<String> = varchar("category_name", 100)
    override val primaryKey = PrimaryKey(id, name = "product_pk_id")
}
