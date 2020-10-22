package cmps312.lab.beneficiaryreivewlab.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import cmps312.lab.beneficiaryreivewlab.data.repository.BeneficiaryRepo
import cmps312.lab.beneficiaryreivewlab.model.Beneficiary

class BeneficiaryViewModel : ViewModel(){
    private val _beneficiaries = getBeneficiariesFromRepo() as MutableLiveData

    val beneficiaries = _beneficiaries as LiveData<List<Beneficiary>>

    private fun getBeneficiariesFromRepo() = liveData {
        emit(BeneficiaryRepo.getBeneficiaries())
    }

    fun addBeneficiary(beneficiary: Beneficiary){
        _beneficiaries.value?.let {
            _beneficiaries.value = it + beneficiary
        }
    }

    fun deleteBeneficiary(beneficiary: Beneficiary){
        _beneficiaries.value?.let {
            _beneficiaries.value = it - beneficiary
        }
    }
}