package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_transfer.*

class TransferFragment : Fragment(R.layout.fragment_transfer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //todo get a reference of the TransferViewModel

        val transferViewModel : TransferViewModel by activityViewModels()

        super.onViewCreated(view, savedInstanceState)


        //todo initialize the empty transfer

        fromAccountSp.adapter = ArrayAdapter<Account>(
            view.context,
            android.R.layout.simple_dropdown_item_1line,
            //todo add the accounts from the model
            transferViewModel.accounts
        )

        nextBtn.setOnClickListener {
            //todo [update the new transfer]
            transferViewModel.newTransfer = Transfer()
            transferViewModel.newTransfer.apply {
                fromAccountNo = fromAccountSp.selectedItem.toString()
                amount = amountEt.text.toString().toDouble()
            }
            findNavController().navigate(R.id.toSelectBeneficiary)
        }
    }
}