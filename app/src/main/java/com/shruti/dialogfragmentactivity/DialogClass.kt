package com.shruti.dialogfragmentactivity

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.shruti.dialogfragmentactivity.databinding.CustomItemViewBinding

interface dialogClickInterface{
    fun dialogName(name : String)
}

class DialogClass : DialogFragment() {
    lateinit var binding : CustomItemViewBinding
    lateinit var dialogClick : Dialog
    lateinit var dialogClickInterface: dialogClickInterface
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogClick = Dialog(requireContext())
        binding = CustomItemViewBinding.inflate(layoutInflater)
        dialogClick.setContentView(binding.root)
        binding.btnadd.setOnClickListener {
            if (binding.etname.text.isNullOrEmpty()) {
                binding.etname.error = "Enter name here"
            } else {
                dialogClickInterface.dialogName(binding.btnadd.text.toString())
                dialogClick.dismiss()
            }
        }
        return dialogClick
    }
    companion object{
        var TAG = this::class.java.canonicalName
    }
}