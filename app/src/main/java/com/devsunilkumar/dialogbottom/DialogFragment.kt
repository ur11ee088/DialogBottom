package com.devsunilkumar.dialogbottom

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment


open class DialogFragment: DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setGravity(Gravity.CENTER)
        dialog?.window?.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
     // while opening popup
        val  decorView = dialog?.window?.decorView

        val scaleDownClose: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            decorView,
            PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
            PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
            PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f)
        )
        scaleDownClose.duration = 2000
        scaleDownClose.start()

        scaleDownClose.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator) {
               // dismiss()
            }

            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })


        //closeing popups


      /*  val scaleDown = ObjectAnimator.ofPropertyValuesHolder(
            decorView,
            PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f),
            PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
            PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f)
        )
        scaleDown.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator) {
               // dismiss()
            }

            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        scaleDown.duration = 2000
        scaleDown.start()*/




        return inflater.inflate(R.layout.fragment_item_list_dialog_list_dialog, container, false)
    }






}





