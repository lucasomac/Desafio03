package br.com.lucolimac.desafio03

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lucolimac.desafio03.databinding.FragmentProfileZoomBinding
import com.bumptech.glide.Glide

class ProfileZoomFragment() : Fragment() {
    private lateinit var comic: String
    private lateinit var binding: FragmentProfileZoomBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data = arguments
        comic = data?.getString("comic").toString()
        Log.i("STRING_URLF", comic)
        binding = FragmentProfileZoomBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_zoom, container, false)
        binding.ivProfileZoom.apply {
            Glide.with(this).asBitmap().load(comic)
                .into(binding.ivProfileZoom)
        }
        return view
    }

    companion object {
        fun newInstance() = ProfileZoomFragment()
    }

}
