package com.example.myfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfinal.databinding.ActivitySigninBinding
import com.google.firebase.auth.FirebaseAuth

class SIGNIN : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signinButton.setOnClickListener {
            val username = binding.signinEmail.text.toString()
            val password = binding.signinPassword.text.toString()
            val cpPassword = binding.signinConfirm.text.toString()

            if(username.isNotEmpty() && password.isNotEmpty() && cpPassword.isNotEmpty()){
                if(password == cpPassword){
                    firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this,LOGIN::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this,"Password not Match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}