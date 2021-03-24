package com.devsunilkumar.dialogbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val openDialog = findViewById<Button>(R.id.open_dialog)
        val openDialog2 = findViewById<Button>(R.id.open_dialog2)
        openDialog.setOnClickListener {
            supportFragmentManager?.beginTransaction()?.add(ItemListDialogFragment(), "test")
                    ?.commit()




        }

        openDialog2.setOnClickListener {
            DialogFragment().show(
                this.supportFragmentManager.beginTransaction(),
                ""
            )
        }
    }
}