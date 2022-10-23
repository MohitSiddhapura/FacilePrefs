package com.ms.facileprefsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ms.facileprefs.FacilePrefs
import com.ms.facileprefsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        with(binding){
            setData.setOnClickListener {
                Prefs.name = "Mohit Siddhapura"
                showToast("Data Saved")
            }

            getData.setOnClickListener {
                Prefs.name?.let { it1 -> showToast(it1) }
            }

            removeData.setOnClickListener {
                FacilePrefs.remove(Prefs.name.toString())
                showToast("Data Removed")
            }

            clearData.setOnClickListener {
                FacilePrefs.clear()
                showToast("Clear All Data")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}