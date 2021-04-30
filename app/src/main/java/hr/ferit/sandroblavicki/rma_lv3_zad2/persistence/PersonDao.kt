package hr.ferit.sandroblavicki.rma_lv3_zad2.persistence

import androidx.room.*
import hr.ferit.sandroblavicki.rma_lv3_zad2.model.Person

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: Person);

    @Delete
    fun delete(person: Person);

    @Query("SELECT * FROM people WHERE id=:id")
    fun getPerson(id: Long): Person

    @Query("SELECT * FROM people")
    fun getPeople(): List<Person>;

}