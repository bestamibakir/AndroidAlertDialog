package com.bestamibakir.androidalertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bestamibakir.androidalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this@MainActivity,"Welcome",Toast.LENGTH_LONG).show()

        /*
        --------------------- context  ----------------------
        //bu iki setOnClickListener yöntemi aynı işi görür. Ama aşağıdaki daha kullanışlı ve anlaşılır.
        binding.button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //yukarıda verilen this ile burada yazılan arasında fark vardır.
                //burada verilen this'te hangi Activity olduğunu belirtmen gerek.

            }

        })

        binding.button.setOnClickListener {

        }

         */
    }

    fun kaydet(view : View){
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Kayıt Et")
        alert.setMessage("Are you sure?")

        alert.setPositiveButton("Evet") {dialog, which ->
            Toast.makeText(this@MainActivity,"Registered",Toast.LENGTH_SHORT).show()
        }

        alert.setNegativeButton("Hayır",object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity,"Canceled",Toast.LENGTH_SHORT).show()
            }

        })

        alert.show()
    }
}