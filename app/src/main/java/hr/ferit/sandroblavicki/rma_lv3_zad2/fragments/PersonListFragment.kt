package hr.ferit.sandroblavicki.rma_lv3_zad2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.rma_lv3_zad2.R
import hr.ferit.sandroblavicki.rma_lv3_zad2.adapters.PersonAdapter
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.FragmentPersonListBinding
import hr.ferit.sandroblavicki.rma_lv3_zad2.listeners.PersonInteractionListener
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PeopleRepository

class PersonListFragment : Fragment() {

    private lateinit var personListBinding: FragmentPersonListBinding
    private val peopleRepository = PeopleRepository

    companion object {
        fun newInstance(): PersonListFragment {
            return PersonListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personListBinding = FragmentPersonListBinding.inflate(layoutInflater)
        setUpUi()
        return personListBinding.root
    }

    private fun setUpUi() {
        personListBinding.rvPersonList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        personListBinding.rvPersonList.itemAnimator = DefaultItemAnimator()
        personListBinding.rvPersonList.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        displayData()
    }

    private fun displayData() {
        val personInteractionListener = object: PersonInteractionListener{
            override fun onRemove(id: Int) {
                PeopleRepository.remove(id)
                (personListBinding.rvPersonList.adapter as PersonAdapter).refreshData(peopleRepository.getPeople())
            }

            override fun onShowQuote(id: Int) {
                val person = PeopleRepository.get(id)
                Toast.makeText(context, person?.quotes?.random().toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onEditDetails(id: Int) {

            }

        }
        personListBinding.rvPersonList.adapter = PersonAdapter(peopleRepository.getPeople(), personInteractionListener)
    }
}