package hr.ferit.sandroblavicki.rma_lv3_zad2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.sandroblavicki.rma_lv3_zad2.R
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.FragmentPersonListBinding

class PersonListFragment : Fragment() {

    private lateinit var personListBinding: FragmentPersonListBinding

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
        return inflater.inflate(R.layout.fragment_person_list, container, false)
    }
}