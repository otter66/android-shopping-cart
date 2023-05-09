package woowacourse.shopping.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CartDbHelper(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
                CREATE TABLE ${CartContract.TABLE_NAME} (
                    ${CartContract.TABLE_COLUMN_PRODUCT_ID} INTEGER,
                    ${CartContract.TABLE_COLUMN_PRODUCT_IMAGE_URL} TEXT,
                    ${CartContract.TABLE_COLUMN_PRODUCT_NAME} TEXT, 
                    ${CartContract.TABLE_COLUMN_PRODUCT_PRICE} INTEGER
                )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${CartContract.TABLE_NAME}")
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "cart.db"
    }
}
