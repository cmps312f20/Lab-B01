package cmps312.lab.bankingapp.ui.beneficiary

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.ui.beneficiary.adapter.BeneficiaryAdapter
import cmps312.lab.bankingapp.ui.beneficiary.viewmodel.SelectBeneficiaryViewModel
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_select_beneficiary.*

class SelectBeneficiaryFragment : Fragment(R.layout.fragment_select_beneficiary) {

    val transferViewModel : TransferViewModel by activityViewModels()
    val selectBeneficiaryViewModel : SelectBeneficiaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo [explain]
        val beneficiaryAdapter = BeneficiaryAdapter(::oneBeneficiarySelected)

        beneficiaryRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = beneficiaryAdapter
        }
        //anytime the data of beneficiary changes you will be notified
        selectBeneficiaryViewModel.beneficiaries().observe(viewLifecycleOwner){
            beneficiaryAdapter.beneficiaries = it
        }
         //todo [observe]
    }

    private fun oneBeneficiarySelected(beneficiary: Beneficiary) {
        // todo [update the new transfer]
        transferViewModel.newTransfer.apply {
            beneficiaryAccountNo = beneficiary.accountNo
            beneficiaryName = beneficiary.name
        }
        findNavController().navigate(R.id.toTransferConfirmation)
    }
}