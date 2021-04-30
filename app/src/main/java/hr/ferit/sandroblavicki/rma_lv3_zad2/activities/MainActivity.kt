package hr.ferit.sandroblavicki.rma_lv3_zad2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import hr.ferit.sandroblavicki.rma_lv3_zad2.R
import hr.ferit.sandroblavicki.rma_lv3_zad2.adapters.FragmentAdapter
import hr.ferit.sandroblavicki.rma_lv3_zad2.adapters.PersonAdapter
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.ActivityMainBinding
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PeopleDatabaseBuilder
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PeopleRepository
import hr.ferit.sandroblavicki.rma_lv3_zad2.persistence.PersonDao

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val peopleRepository: PersonDao by lazy {
        PeopleDatabaseBuilder.getInstance().personDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUi()
    }

    private fun setUpUi() {
        binding.vpMainActivity.adapter = FragmentAdapter(supportFragmentManager)
        binding.tabMainActivity.setupWithViewPager(binding.vpMainActivity)

        binding.vpMainActivity.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (binding.vpMainActivity.currentItem == 0){
                    val adapter = (findViewById<RecyclerView>(R.id.rv_personList).adapter as PersonAdapter)
                    adapter.refreshData(peopleRepository.getPeople())
                    findViewById<RecyclerView>(R.id.rv_personList).scrollToPosition(adapter.itemCount-1)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }
}