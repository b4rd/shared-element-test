package com.example.shared_element_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DetailFragment: Fragment() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TransitionInflater.from(requireContext()).run {
            sharedElementEnterTransition = TransitionSet().apply {
                addTransition(ChangeBounds())
                addTransition(ChangeImageTransform())
            }
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }
}