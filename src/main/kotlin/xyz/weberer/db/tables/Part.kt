package xyz.weberer.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

object Part : Table() {
    val id: Column<Int> = Part.integer("id")
    val punctuatedPartNumber: Column<String> = Part.varchar("punctuated_part_number", 100)
    val description: Column<String> = Part.varchar("description", 100)
    val productId: Column<Int> = Part.integer("product_id")
    val originalRetailPrice: Column<BigDecimal> = Part.decimal("original_retail_price", 10, 2)
    val brandName: Column<String> = Part.varchar("brand_name", 100)
    val assetUrl: Column<String> = Part.text("asset_url")
}