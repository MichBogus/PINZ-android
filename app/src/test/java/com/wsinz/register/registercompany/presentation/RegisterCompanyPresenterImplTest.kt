package com.wsinz.register.registercompany.presentation

import com.nhaarman.mockito_kotlin.mock
import com.wsinz.network.base.NetworkSchedulerImpl
import com.wsinz.register.registercompany.domain.RegisterCompanyService
import io.reactivex.schedulers.Schedulers.trampoline
import org.junit.Before

class RegisterCompanyPresenterImplTest {

    private val mockOfRegisterCompanyService: RegisterCompanyService = mock()
    private val mockOfNetworkScheduler = NetworkSchedulerImpl(trampoline(), trampoline())
    lateinit var systemUnderTest: RegisterCompanyPresenterImpl

    @Before
    fun setUp() {
        systemUnderTest = RegisterCompanyPresenterImpl(mockOfRegisterCompanyService, mockOfNetworkScheduler)
    }
}