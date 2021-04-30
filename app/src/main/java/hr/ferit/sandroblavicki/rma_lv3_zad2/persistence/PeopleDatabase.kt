package hr.ferit.sandroblavicki.rma_lv3_zad2.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.ferit.sandroblavicki.rma_lv3_zad2.model.Person


@Database(entities = [Person::class], version = 1)
abstract class PeopleDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        const val NAME = "peopleDb"
    }


}