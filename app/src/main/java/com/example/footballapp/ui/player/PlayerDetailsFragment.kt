package com.example.footballapp.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentPlayerDetailsBinding
import com.example.footballapp.ui.base.BaseFragment


class PlayerDetailsFragment : BaseFragment<FragmentPlayerDetailsBinding>() {
    private val args: PlayerDetailsFragmentArgs by navArgs()
    override val viewModel: PlayerViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlayerDetailsBinding
        get() = FragmentPlayerDetailsBinding::inflate

    override fun setup() {

        binding.showMorePlayer.setOnClickListener {
            val action = PlayerDetailsFragmentDirections.actionPlayerDetailsFragmentToWebSearchFragment(7879)
            Navigation.findNavController(it).navigate(action)
        }

//        binding.textView.text = args.playerId.toString()
//        sharedElementEnterTransition = TransitionInflater.from(context)
//            .inflateTransition(android.R.transition.move)
    }
}
