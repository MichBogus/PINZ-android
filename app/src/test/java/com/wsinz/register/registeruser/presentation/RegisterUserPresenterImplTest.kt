package com.wsinz.register.registeruser.presentation

import com.nhaarman.mockito_kotlin.*
import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.NetworkSchedulerImpl
import com.wsinz.network.register.model.RegisterUserBody
import com.wsinz.register.registeruser.domain.RegisterUserService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.trampoline
import org.junit.Before
import org.junit.Test

class RegisterUserPresenterImplTest {

    private val mockOfRegisterUserService: RegisterUserService = mock()
    private val mockOfNetworkScheduler: NetworkSchedulerImpl = NetworkSchedulerImpl(trampoline(), trampoline())
    private val mockOfView: RegisterUserView = mock()
    lateinit var systemUnderTest: RegisterUserPresenterImpl

    @Before
    fun setUp() {
        systemUnderTest = RegisterUserPresenterImpl(mockOfRegisterUserService, mockOfNetworkScheduler)

        systemUnderTest.attach(mockOfView)
    }

    @Test
    fun shouldHidePasswordErrorWhenPasswordIsEmpty() {
        systemUnderTest.validatePassword("", "132")

        verify(mockOfView).hidePasswordError()
        verifyNoMoreInteractions(mockOfView)
    }

    @Test
    fun shouldHidePasswordErrorWhenConfirmationPasswordIsEmpty() {
        systemUnderTest.validatePassword("123", "")

        verify(mockOfView).hidePasswordError()
        verifyNoMoreInteractions(mockOfView)
    }

    @Test
    fun shouldRegisterUserProperly() {
        val registerBody = RegisterUserBody("test", "test1234", "testCode", "testName", "testLastName")
        whenever(mockOfRegisterUserService.registerUser(registerBody)).thenReturn(Single.just(BaseResponse("ok", "200", "200", "ok", true)))

        systemUnderTest.register(registerBody)

        verify(mockOfView).hideRegisterButtonProgress()
        verify(mockOfView).showRegisterSuccessDialog(any())
    }

    @Test
    fun shouldFailRegisterUser() {
        val registerBody = RegisterUserBody("test", "test1234", "testCode", "testName", "testLastName")
        whenever(mockOfRegisterUserService.registerUser(registerBody)).thenReturn(Single.error(AppWSErrorThrowable().apply {
            this.code = 400
            this.messagge = "fail"
            this.error = BaseResponse("fail", "400", "400", "fail cuz of stuff", false)
        }))

        systemUnderTest.register(registerBody)

        verify(mockOfView).hideRegisterButtonProgress()
        verify(mockOfView).showRegisterErrorDialog(eq("fail cuz of stuff"), any())
    }

    @Test
    fun shouldFailRegisterUserWithInternetConnectionProblem() {
        val registerBody = RegisterUserBody("test", "test1234", "testCode", "testName", "testLastName")
        whenever(mockOfRegisterUserService.registerUser(registerBody)).thenReturn(Single.error(Throwable()))

        systemUnderTest.register(registerBody)
        verify(mockOfView).hideRegisterButtonProgress()
        verify(mockOfView).showRegisterErrorDialog(eq(""), any())
    }
}