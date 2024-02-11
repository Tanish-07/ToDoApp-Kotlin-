package com.tanish.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.tanish.todoapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.ToSignInButton.setOnClickListener {
            startActivity(Intent(this,SIgnInActivity::class.java))
            finish()
        }

        binding.RegisterBtn.setOnClickListener {


            val email = binding.emailInput.text.toString()
            val username = binding.userNameInput.text.toString()
            val password = binding.passwordInput.text.toString()
            val repassword =binding.rePasswordInput.text.toString()

            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || repassword.isEmpty()){
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }
            else if (password != repassword){
                Toast.makeText(this, "Re-Password isn't same", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,SIgnInActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Registration Failed :${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}