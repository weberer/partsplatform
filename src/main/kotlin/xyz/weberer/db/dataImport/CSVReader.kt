package xyz.weberer.db.dataImport

import com.opencsv.CSVReaderHeaderAware
import java.io.FileReader

class CSVReader (filePath: String) {
    private val reader: CSVReaderHeaderAware = CSVReaderHeaderAware(FileReader(filePath))
    private var line: Map<String, String>? = reader.readMap()


    private fun readNext() {
        line = reader.readMap()
    }

    fun hasNext(): Boolean = line != null

    fun getNext(): Map<String, String>? {
        val l = line
        readNext()
        return l
    }
}