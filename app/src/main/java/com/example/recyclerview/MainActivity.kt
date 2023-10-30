package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = DeviceAdapter()
    private val imageList = listOf(R.drawable.device1,
        R.drawable.device2,
        R.drawable.device3,
        R.drawable.device4,
        )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycler.adapter = adapter
            buttonAdd.setOnClickListener{
                val device = Device(imageList[index], "Device $index")
                adapter.addDevice(device)
                index++
                if(index > 3){
                    index = 0
                }
            }
        }
    }

}
//        setContent {
//            RecyclerViewTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    setContentView(R.layout.device_item)
//                }
//            }
//        }