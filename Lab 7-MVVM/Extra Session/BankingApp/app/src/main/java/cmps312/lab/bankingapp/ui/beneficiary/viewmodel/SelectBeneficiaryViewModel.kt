package cmps312.lab.bankingapp.ui.beneficiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.reposiotry.BankRepository

class SelectBeneficiaryViewModel(appContext: Application) : AndroidViewModel(appContext) {

    private var _beneficiaries = MutableLiveData<List<Beneficiary>>()

    init {
        _beneficiaries.postValue(BankRepository.getBeneficiaries(appContext))
    }
    fun beneficiaries() : LiveData<List<Beneficiary>> = _beneficiaries
}