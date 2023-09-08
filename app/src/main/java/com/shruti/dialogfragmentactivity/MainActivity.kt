package com.shruti.dialogfragmentactivity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.shruti.dialogfragmentactivity.databinding.ActivityMainBinding
import com.shruti.dialogfragmentactivity.databinding.CustomItemViewBinding

class MainActivity : AppCompatActivity(), dialogClickInterface{
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.mainActivity = this
    }

    fun buttonClick(numberClick: NumberClick){
        when(numberClick){
           NumberClick.first -> {
               startActivity(Intent(this,FirstActvity::class.java))
           }
            NumberClick.second ->
            {
                Toast.makeText(this,"Second",Toast.LENGTH_SHORT).show()
            }
            NumberClick.third ->{
                Toast.makeText(this,"Third",Toast.LENGTH_SHORT).show()
            }
            NumberClick.dialogClick-> {
                var dialogClass = DialogClass()
                dialogClass.dialogClickInterface = this
                dialogClass.show(supportFragmentManager, DialogClass.TAG)
            }
            else -> {}
        }
    }
    override fun dialogName(name: String) {
       binding?.root?.let {
           Snackbar.make(it, "Clicked$name",Snackbar.LENGTH_SHORT).show()
       }
    }

}