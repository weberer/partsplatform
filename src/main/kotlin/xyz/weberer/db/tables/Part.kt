package xyz.weberer.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

object Part: Table() {
    val id: Column<Int> = integer("id")
    val punctuatedPartNumber: Column<String> = varchar("punctuated_part_number", 100)
    val description: Column<String> = varchar("description", 100)
    val productId: Column<Int> = integer("product_id")
    val originalRetailPrice: Column<BigDecimal> = decimal("original_retail_price", 10, 2)
    val brandName: Column<String> = varchar("brand_name", 100)
    val assetUrl: Column<String> = text("asset_url")
    override val primaryKey = PrimaryKey(id, name = "part_pk_id")
}