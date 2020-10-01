package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.reposiotry.BankRepository


//Single responsibility
class TransferViewModel(appContext: Application) : AndroidViewModel(appContext) {
    //properties
    private var _transfers = MutableLiveData<MutableList<Transfer>>();
    lateinit var selectedTransfer : Transfer

    //init
    init {
        _transfers.postValue(BankRepository.getTransfers(appContext) as MutableList<Transfer>?)
    }
    //Methods
    fun transfers(): LiveData<MutableList<Transfer>> = _transfers


}