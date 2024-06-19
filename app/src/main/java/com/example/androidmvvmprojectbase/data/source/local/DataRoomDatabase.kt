package com.example.androidmvvmprojectbase.data.source.local

//@Database(entities = [], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
//abstract class DogRoomDatabase : RoomDatabase() {
//
////    abstract fun dataDao(): DataDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: DogRoomDatabase? = null
//
//        fun getDatabase(context: Context): DogRoomDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    DogRoomDatabase::class.java,
//                    "dog_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}