package com.banana.b19.promo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_page.*

fun newFragment(title: String): PageFragment {
    val fragment = PageFragment()
    val arguments = Bundle()
    arguments.putString("TITLE", title)
    fragment.arguments = arguments
    return fragment
}

class PageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(getRandomColor())
        val title = arguments?.getString("TITLE")
        titleTextView.setText(title)
    }

    private fun getRandomColor() =
        Color.rgb((0..255).random(), (0..255).random(), (0..255).random())


}
