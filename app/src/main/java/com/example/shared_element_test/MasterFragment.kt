package com.example.shared_element_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

@SuppressLint("NewApi")
class MasterFragment: Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TransitionInflater.from(requireContext()).run {
            exitTransition = Fade()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.master_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<View>(R.id.btn_to_fragment)
        button.setOnClickListener { _ ->
            val image = view.findViewById<View>(R.id.image)
            fragmentManager!!.beginTransaction()
                .replace(R.id.container, DetailFragment())
                .addSharedElement(image, image.transitionName)
                .addToBackStack(null)
                .commit()
        }
    }
}