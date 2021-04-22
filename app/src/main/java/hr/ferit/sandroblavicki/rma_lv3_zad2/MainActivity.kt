package hr.ferit.sandroblavicki.rma_lv3_zad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.sandroblavicki.rma_lv3_zad2.adapters.FragmentAdapter
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUi()
    }

    private fun setUpUi() {
        binding.vpMainActivity.adapter = FragmentAdapter(supportFragmentManager)
        binding.tabMainActivity.setupWithViewPager(binding.vpMainActivity)
    }
}