package com.exam.examrbh.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exam.examrbh.databinding.ActivityLoginBinding
import com.exam.examrbh.presentation.home.HomeActivity
import com.exam.examrbh.util.Constant

class LoginActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding

    private var passCode = arrayListOf<String>()

    private var hLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun activeCode(pass: String){
        passCode.add(pass)
        if(passCode.size in 1..6){
            when(passCode.size){
                1 -> binding.boxPinFormEnterMobile.code1.isSelected = true
                2 -> binding.boxPinFormEnterMobile.code2.isSelected = true
                3 -> binding.boxPinFormEnterMobile.code3.isSelected = true
                4 -> binding.boxPinFormEnterMobile.code4.isSelected = true
                5 -> binding.boxPinFormEnterMobile.code5.isSelected = true
                6 -> {
                    binding.boxPinFormEnterMobile.code6.isSelected = true
                    val sb = StringBuilder()
                    passCode.forEach { sb.append(it) }
                    val str = sb.toString()
                    if(str == Constant.CHECK_USER){
                        passCode.clear()
                        hLogin = true
                        HomeActivity.start(this)
                    }
                    else{
                        passCode.clear()
                        binding.boxPinFormEnterMobile.code1.isSelected = false
                        binding.boxPinFormEnterMobile.code2.isSelected = false
                        binding.boxPinFormEnterMobile.code3.isSelected = false
                        binding.boxPinFormEnterMobile.code4.isSelected = false
                        binding.boxPinFormEnterMobile.code5.isSelected = false
                        binding.boxPinFormEnterMobile.code6.isSelected = false
                    }
                }
            }
        }

    }

    private fun inActiveCode() {
        if (passCode.isNotEmpty()) {
            passCode.removeAt(passCode.size - 1)
            if (passCode.size in 0..5)
                when (passCode.size) {
                    0 -> binding.boxPinFormEnterMobile.code1.isSelected = false
                    1 -> binding.boxPinFormEnterMobile.code2.isSelected = false
                    2 -> binding.boxPinFormEnterMobile.code3.isSelected = false
                    3 -> binding.boxPinFormEnterMobile.code4.isSelected = false
                    4 -> binding.boxPinFormEnterMobile.code5.isSelected = false
                    5 -> binding.boxPinFormEnterMobile.code6.isSelected = false
                }
        }

    }

    private fun setClickNumPad(){
        binding.numPadEdit.pad1.setOnClickListener {
            activeCode("1")
        }
        binding.numPadEdit.pad2.setOnClickListener {
            activeCode("2")
        }
        binding.numPadEdit.pad3.setOnClickListener {
            activeCode("3")
        }
        binding.numPadEdit.pad4.setOnClickListener {
            activeCode("4")
        }
        binding.numPadEdit.pad5.setOnClickListener {
            activeCode("5")
        }
        binding.numPadEdit.pad6.setOnClickListener {
            activeCode("6")
        }
        binding.numPadEdit.pad7.setOnClickListener {
            activeCode("7")
        }
        binding.numPadEdit.pad8.setOnClickListener {
            activeCode("8")
        }
        binding.numPadEdit.pad9.setOnClickListener {
            activeCode("9")
        }
        binding.numPadEdit.pad0.setOnClickListener {
            activeCode("0")
        }
        binding.numPadEdit.padDel.setOnClickListener {
            inActiveCode()
        }
    }

    override fun onResume() {
        super.onResume()
        if(hLogin){
            binding.boxPinFormEnterMobile.code1.isSelected = false
            binding.boxPinFormEnterMobile.code2.isSelected = false
            binding.boxPinFormEnterMobile.code3.isSelected = false
            binding.boxPinFormEnterMobile.code4.isSelected = false
            binding.boxPinFormEnterMobile.code5.isSelected = false
            binding.boxPinFormEnterMobile.code6.isSelected = false
            hLogin = false
        }
        setClickNumPad()
    }


}