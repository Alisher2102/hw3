package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.DeviceItemBinding

class DeviceAdapter: RecyclerView.Adapter<DeviceAdapter.DeviceHolder>(){
    val deviceList = ArrayList<Device>()
    class DeviceHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DeviceItemBinding.bind(item)
        fun bind(device: Device) = with(binding){
            imageView.setImageResource(device.imageID)
            textView.text = device.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.device_item, parent, false)
        return DeviceHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {
        holder.bind(deviceList[position])
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    fun addDevice(device: Device){
        deviceList.add(device)
        notifyDataSetChanged()
    }

}