package cmps312.lab.bankingapp.ui.beneficiary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.databinding.ListItemBeneficiaryBinding
import cmps312.lab.bankingapp.model.Beneficiary
import kotlinx.android.synthetic.main.list_item_beneficiary.view.*

class BeneficiaryAdapter(private val itemSelectedListener: (Beneficiary) -> Unit)
    : RecyclerView.Adapter<BeneficiaryAdapter.BeneficiaryViewHolder>() {
    var beneficiaries: List<Beneficiary>? = null
        set(beneficiaries) {
            field = beneficiaries;
            notifyDataSetChanged()
        }

    inner class BeneficiaryViewHolder(private val binding:ListItemBeneficiaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(beneficiary: Beneficiary) {
            binding.beneficiary = beneficiary
            binding.root.setOnClickListener { itemSelectedListener(beneficiary) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryViewHolder {
        //todo change it to data binding

        val binding:ListItemBeneficiaryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.list_item_beneficiary, parent, false
        )
        return BeneficiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeneficiaryViewHolder, position: Int) =
        holder.bind(beneficiaries!![position])

    override fun getItemCount() = beneficiaries?.size ?: 0
}