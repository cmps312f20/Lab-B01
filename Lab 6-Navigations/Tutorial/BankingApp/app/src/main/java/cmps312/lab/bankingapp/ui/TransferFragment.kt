package cmps312.lab.bankingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Transfer
import kotlinx.android.synthetic.main.fragment_transfer.*

class TransferFragment : Fragment(R.layout.fragment_transfer) {
     lateinit var navController : NavController;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transfer = Transfer()
        nextBtn.setOnClickListener {
            //two info
            navController = findNavController();
            transfer.fromAccountNo = fromAccountNoEt.text.toString()
            transfer.amount = amountEdt.text.toString().toDouble()

            val action = TransferFragmentDirections
                .actionTransferFragmentToSelectBeneficiaryFragment(transfer)
            navController.navigate(action)
        }

        previousBtn.setOnClickListener {

        }

    }
}