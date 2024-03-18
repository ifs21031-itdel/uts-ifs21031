package com.ifs21031.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21031.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataFamily = ArrayList<Family>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvFamilies.setHasFixedSize(false)
        dataFamily.addAll(getListFamily())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListFamily(): ArrayList<Family> {
        val dataName =
            resources.getStringArray(R.array.dino_family)

        val dataIcon = resources.obtainTypedArray(R.array.dino_family_icon)

        val listFamily = ArrayList<Family>()
        for (i in dataName.indices) {
            val fruit = Family(
                dataName[i], dataIcon.getResourceId(i, -1),
            )
            listFamily.add(fruit)
        }
        return listFamily
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE
        ) {
            binding.rvFamilies.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvFamilies.layoutManager =
                LinearLayoutManager(this)
        }
        val listFamilyAdapter = ListFamilyAdapter(dataFamily)
        binding.rvFamilies.adapter = listFamilyAdapter
        listFamilyAdapter.setOnItemClickCallback(object :
            ListFamilyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Family) {
                showSelectedFruit(data)
            }
        })
    }

    private fun showSelectedFruit(fruit: Family) {
        val intentWithData = Intent(
            this@MainActivity,
            DetailFamilyActivity::class.java
        )
        intentWithData.putExtra(DetailFamilyActivity.EXTRA_FRUIT, fruit)
        startActivity(intentWithData)
    }
}