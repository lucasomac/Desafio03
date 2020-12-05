package br.com.lucolimac.desafio03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lucolimac.desafio03.databinding.FragmentProfileZoomBinding
import com.bumptech.glide.Glide

class ProfileZoomFragment() : Fragment() {
    private lateinit var url: String
    private lateinit var binding: FragmentProfileZoomBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentProfileZoomBinding.inflate(inflater, container, false)
        return binding.root
//        binding.ivProfileZoom.apply {
//            Glide.with(binding.root)
//                .asBitmap()
//                .load(url)
//                .into(binding.ivProfileZoom)
//        }
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile_zoom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(binding.ivProfileZoom)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance(url: String) = ProfileZoomFragment().apply {
            this.url = url
        }
    }
}
