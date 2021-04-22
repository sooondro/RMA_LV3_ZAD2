package hr.ferit.sandroblavicki.rma_lv3_zad2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hr.ferit.sandroblavicki.rma_lv3_zad2.fragments.NewPersonFragment
import hr.ferit.sandroblavicki.rma_lv3_zad2.fragments.PersonListFragment

class FragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragments = arrayOf(
        PersonListFragment.newInstance(),
        NewPersonFragment.newInstance()
    )

    val titles = arrayOf("Inspiring person list", "Add New Person")

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}