package com.geeks.lovecalculate.ui.fragments.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.lovecalculate.databinding.ItemOnBoardBinding
import com.geeks.lovecalculate.loadImage

class OnBoardAdapter() :
    RecyclerView.Adapter<OnBoardAdapter.ViewHolder>() {

    private val list = arrayListOf(
        OnBoardModel(
            "https://png.pngtree.com/png-vector/20220428/ourmid/pngtree-smooth-glossy-heart-vector-file-ai-and-png-png-image_4557871.png",
            "Have a good time",
            "You should take the time to help those \n who need you"
        ),
        OnBoardModel(
            "https://static.vecteezy.com/system/resources/previews/023/790/845/original/creative-heart-icon-clipart-transparent-background-free-free-png.png",
            "Cherishing love",
            "It is now no longer possible for \n you to cherish love"
        ),
        OnBoardModel(
            "https://i.pinimg.com/originals/c1/ce/28/c1ce284116bba998a6e7388cdc65e680.png",
            "Have a breakup?",
            "We have made the correction for you \n don't worry \n Maybe someone is waiting for you!"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard : OnBoardModel){
            binding.imgVp2.loadImage(onBoard.image)
            binding.tvDescription.text=onBoard.description
            binding.tvTheme.text = onBoard.theme
        }
    }
}