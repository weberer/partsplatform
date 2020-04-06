package xyz.weberer

import org.jetbrains.exposed.sql.*
import xyz.weberer.db.DbConnection
import xyz.weberer.db.tables.Part
import xyz.weberer.db.tables.Product
import java.math.BigDecimal
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.jetbrains.exposed.sql.transactions.transaction

private fun getRowJson(
    productName: String,
    brandName: String,
    maxPrice: BigDecimal?,
    minPrice: BigDecimal?,
    imageUrl: String?
): JsonObject {
    val priceString = if (maxPrice == minPrice) """$$minPrice""" else """$$minPrice - $$maxPrice"""

    val row = JsonObject()
    row.addProperty("productName", productName)
    row.addProperty("brandName", brandName)
    row.addProperty("price", priceString)
    row.addProperty("imageUrl", imageUrl)
    return row
}

fun getSummaryData(): String {
    val dataJsonArray: JsonArray = JsonArray()
    DbConnection().getConnection()

    transaction {
        // Create column aliases for easier access
        val maxPrice = Part.originalRetailPrice.max().alias("maxPrice")
        val minPrice = Part.originalRetailPrice.min().alias("minPrice")
        val url = Part.assetUrl.max().alias("url")
        val productName = Product.productName.alias("productName")
        val brandName = Part.brandName.alias("brandName")

        Part.join(Product, JoinType.FULL, Part.productId, Product.productId)
            .slice(productName, brandName, maxPrice, minPrice, url)
            .selectAll()
            .groupBy(productName, brandName)
            .forEach {
                // Create JSON representation of each row
                val rowJson = getRowJson(it[productName], it[brandName], it[maxPrice], it[minPrice], it[url])
                dataJsonArray.add(rowJson)
            }
    }
    return dataJsonArray.toString();
}