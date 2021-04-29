package hr.ferit.sandroblavicki.rma_lv3_zad2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.rma_lv3_zad2.R
import hr.ferit.sandroblavicki.rma_lv3_zad2.listeners.PersonInteractionListener
import hr.ferit.sandroblavicki.rma_lv3_zad2.model.Person

class PersonAdapter(
    people: List<Person>,
    private val listener: PersonInteractionListener
): RecyclerView.Adapter<PersonViewHolder>() {

    private val people: MutableList<Person> = mutableListOf()

    init {
        refreshData(people)
    }

    fun refreshData(people: List<Person>) {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(personView)
    }

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person, listener)
    }
}