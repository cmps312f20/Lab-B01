package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.reposiotry.BankRepository


//Single responsibility
class TransferViewModel(appContext: Application) : AndroidViewModel(appContext) {
    //properties
    private var _transfers = MutableLiveData<MutableList<Transfer>>();
    lateinit var selectedTransfer: Transfer

    //todo 1 account and newTransfer
    lateinit var accounts: List<Account>

    lateinit var newTransfer: Transfer

    //init
    init {
        _transfers.postValue(BankRepository.getTransfers(appContext) as MutableList<Transfer>?)
        //todo 2 initialize the accounts
        accounts = BankRepository.getAccounts(appContext)
    }

    //Methods
    fun transfers(): LiveData<MutableList<Transfer>> = _transfers

    //todo implement the add transfer

    fun addTransfer(){
        _transfers.value?.add(newTransfer)
    }
}