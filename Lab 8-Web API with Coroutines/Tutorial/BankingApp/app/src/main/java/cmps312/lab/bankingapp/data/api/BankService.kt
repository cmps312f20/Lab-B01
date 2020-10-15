package cmps312.lab.bankingapp.data.api




import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Transfer
import retrofit2.http.*

interface BankService {
//  BASE_URL =  https://cmps312banking.herokuapp.com/api/

    @GET("accounts/{cid}")
    suspend fun getAccounts(@Path("cid") cid : Int) : List<Account>

    @GET("transfers/{cid}")
    suspend fun getTransfer(@Path("cid") cid : Int) : List<Transfer>

    @POST("transfers/{cid}")
    fun addTransfer(@Path("cid") cid : Int , @Body transfer: Transfer)

    @DELETE("transfers/{cid}/{transferId}")
    fun deleteTransfer(@Path("cid")cid : Int ,
                       @Path("transferId")transferId : String)



}
/*
//GET Accounts	     accounts/:cid	GET
//GET Transfers	     transfers/:cid	GET
//ADD Transfers	     transfers/:cid	POST
//DELETE Transfers	 transfers/:cid/:transferId	DELETE
GET Beneficiaries	 beneficiaries/:cid	    GET
ADD Beneficiary	     beneficiaries/:cid	    POST [Required cid in the URL]
UPDATE Beneficiary	 beneficiaries/:cid	PUT [Requires cid in the URL]
DELETE Beneficiary	 beneficiaries/:cid/:accounNo	DELETE [Requires cid and accountNo in the URL]

Local Banks	https://cmps312banking.herokuapp.com/api/banks	GET
*/
