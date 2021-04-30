package hr.ferit.sandroblavicki.rma_lv3_zad2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.FragmentNewPersonBinding
import hr.ferit.sandroblavicki.rma_lv3_zad2.model.Person
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PeopleDatabaseBuilder
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PeopleRepository
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PersonDao

class NewPersonFragment : Fragment() {

    private lateinit var newPersonBinding: FragmentNewPersonBinding
    private val peopleRepository: PersonDao by lazy {
        PeopleDatabaseBuilder.getInstance().personDao()
    }

    companion object {
        fun newInstance(): NewPersonFragment {
            return NewPersonFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newPersonBinding = FragmentNewPersonBinding.inflate(layoutInflater)
        newPersonBinding.btnNewPersonSave.setOnClickListener { savePerson() }
        return newPersonBinding.root
    }

    private fun savePerson() {
        val name = newPersonBinding.etNewPersonNameInput.text.toString()
        val description = newPersonBinding.etNewPersonDescriptionInput.text.toString()
        val dateOfBirth = newPersonBinding.etNewPersonDateOfBirthInput.text.toString()
        //val quotes = newPersonBinding.etNewPersonQuotesInput.text?.split('.')
        val imageUrl = newPersonBinding.etNewPersonImageUrlInput.text.toString()

        val person = Person(0, name, dateOfBirth, description, imageUrl)
        peopleRepository.insert(person)

        //val newPerson = quotes?.let { Person(name, dateOfBirth, it, description, imageUrl) }
        //newPerson?.let { PeopleRepository.add(it) }
        Toast.makeText(context, "New Person Added", Toast.LENGTH_SHORT).show()

        clearInput()
    }

    private fun clearInput() {
        newPersonBinding.etNewPersonNameInput.text?.clear()
        newPersonBinding.etNewPersonDescriptionInput.text?.clear()
        newPersonBinding.etNewPersonDateOfBirthInput.text?.clear()
        newPersonBinding.etNewPersonQuotesInput.text?.clear()
        newPersonBinding.etNewPersonImageUrlInput.text?.clear()
    }

    /*fun loadPerson(id: Int) {
        val person = PeopleRepository.get(id)
        newPersonBinding.etNewPersonNameInput.setText(person?.name)
        newPersonBinding.etNewPersonDescriptionInput.setText(person?.description)
        newPersonBinding.etNewPersonDateOfBirthInput.setText(person?.dateOfBirth)
        //newPersonBinding.etNewPersonQuotesInput.setText(person?.quotes?.concat())
        newPersonBinding.etNewPersonImageUrlInput.setText(person?.imageUrl)
    }*/
}