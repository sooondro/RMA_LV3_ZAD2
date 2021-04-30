package hr.ferit.sandroblavicki.rma_lv3_zad2.persistence

import androidx.room.Room
import hr.ferit.sandroblavicki.rma_lv3_zad2.ComputerGodsApp

object PeopleDatabaseBuilder {

    private var instance: PeopleDatabase? = null

    fun getInstance(): PeopleDatabase {
        synchronized(PeopleDatabase::class) {
            if (instance == null) {
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): PeopleDatabase? {
    return Room.databaseBuilder(ComputerGodsApp.ApplicationContext, PeopleDatabase::class.java, PeopleDatabase.NAME).allowMainThreadQueries().build()
    }
}