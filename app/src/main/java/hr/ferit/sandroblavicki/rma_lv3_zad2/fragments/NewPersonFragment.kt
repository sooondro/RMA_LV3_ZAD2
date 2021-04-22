package hr.ferit.sandroblavicki.rma_lv3_zad2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.sandroblavicki.rma_lv3_zad2.R

class NewPersonFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_new_person, container, false)
    }
}