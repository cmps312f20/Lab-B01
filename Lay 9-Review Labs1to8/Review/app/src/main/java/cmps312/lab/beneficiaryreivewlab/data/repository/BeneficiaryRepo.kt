package cmps312.lab.beneficiaryreivewlab.data.repository

import cmps312.lab.beneficiaryreivewlab.model.Beneficiary

object BeneficiaryRepo {

    private val beneficiaries = listOf<Beneficiary>(
        Beneficiary("Ahmed Terchoun", "1234", 1234, "787390"),
        Beneficiary("Elbaraa Karam", "12345", 1236, "9098763")
    )

    suspend fun getBeneficiaries() = beneficiaries

}
