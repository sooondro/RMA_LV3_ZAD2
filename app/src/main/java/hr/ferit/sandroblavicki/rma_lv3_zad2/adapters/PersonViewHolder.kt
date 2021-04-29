package hr.ferit.sandroblavicki.rma_lv3_zad2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hr.ferit.sandroblavicki.rma_lv3_zad2.databinding.ItemPersonBinding
import hr.ferit.sandroblavicki.rma_lv3_zad2.listeners.PersonInteractionListener
import hr.ferit.sandroblavicki.rma_lv3_zad2.model.Person

class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(person: Person, listener: PersonInteractionListener) {
        val binding = ItemPersonBinding.bind(itemView)
        binding.tvPersonName.text = person.name
        binding.tvPersonDescription.text = person.description
        binding.tvPersonDateOfBirth.text = person.dateOfBirth
        Glide.with(binding.ivPersonImage).load(person.imageUrl).into(binding.ivPersonImage)
        itemView.setOnClickListener { listener.onShowQuote(person.id) }
        itemView.setOnLongClickListener {
            listener.onRemove(person.id)
            true
        }
    }
}