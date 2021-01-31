package com.yogeshpaliyal.keypass

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yogeshpaliyal.keypass.data.AccountModel
import com.yogeshpaliyal.keypass.db.DbDao


/*
* @author Yogesh Paliyal
* techpaliyal@gmail.com
* https://techpaliyal.com
* created on 30-01-2021 20:37
*/
@Database(
    entities = [AccountModel::class],
    version = 3, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // define DAO start
    abstract fun getDao(): DbDao
    // define DAO end

    companion object {
        private lateinit var _instance: AppDatabase

        fun getInstance(): AppDatabase {
            if (!this::_instance.isInitialized)




                synchronized(this) {


                    _instance = Room.databaseBuilder(
                        MyApplication.instance,
                        AppDatabase::class.java,
                        MyApplication.instance.getString(R.string.app_name)
                    ).addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)


                        }

                        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                            super.onDestructiveMigration(db)
                            onCreate(db)

                        }

                    })
                        .fallbackToDestructiveMigration()
                        .build()
                }


            return _instance
        }
    }
}