package com.ifs21031.dinopedia

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21031.dinopedia.databinding.ActivityDetailFamilyBinding

class DetailFamilyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFamilyBinding
    private var fruit: Family? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFamilyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fruit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_FRUIT,
                Family::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_FRUIT)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (fruit != null) {
            supportActionBar?.title = "Buah ${fruit!!.name}"
            loadData(fruit!!)
        } else {
            finish()
        }
    }

    private fun loadData(fruit: Family) {
        binding.ivDetailIcon.setImageResource(fruit.icon)
        binding.tvDetailName.text = fruit.name
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

}