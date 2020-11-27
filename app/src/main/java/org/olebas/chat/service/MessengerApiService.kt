package org.olebas.chat.service

import io.reactivex.Observable
import okhttp3.ResponseBody
import org.olebas.chat.data.remote.request.LoginRequestObject
import org.olebas.chat.data.remote.request.MessageRequestObject
import org.olebas.chat.data.remote.request.StatusUpdateRequestObject
import org.olebas.chat.data.remote.request.UserRequestObject
import org.olebas.chat.data.vo.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MessengerApiService {

    @POST("login")
    @Headers("Content-Type: application/json")
    fun login(@Body user: LoginRequestObject): Observable<Response<ResponseBody>>

    @POST("users/registrations")
    fun createUser(@Body user: UserRequestObject): Observable<UserVO>

    @GET("users")
    fun listUsers(@Header("Authorisation") authorisation: String): Observable<UserListVO>

    @PUT("users")
    fun updateUserStatus(@Body request: StatusUpdateRequestObject,
                         @Header("Authorisation") authorisation: String): Observable<UserVO>

    @GET("users/{userId}")
    fun showUser(@Path("userId") userId: Long,
                 @Header("Authorisation") authorisation: String): Observable<UserVO>

    @GET("users/details")
    fun echoDetails(@Header("Authorisation") authorisation: String): Observable<UserVO>

    @POST("messages")
    fun createMessage(@Body messageRequestObject: MessageRequestObject,
                      @Header("Authorisation") authorisation: String): Observable<MessageVO>

    @GET("conversations")
    fun listConversations(@Header("Authorisation") authorisation: String): Observable<ConversationListVO>

    @GET("conversations/{conversationId}")
    fun showConversation(@Path("conversationId") conversationId: Long,
                         @Header("Authorisation") authorisation: String): Observable<ConversationVO>

    companion object Factory {
        private var service: MessengerApiService? = null

        fun getInstance(): MessengerApiService {
            if (service == null) {
                val retrofit  = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://olebas-chat-api.herokuapp.com")
                    .build()

                service = retrofit.create(MessengerApiService::class.java)
            }

            return service as MessengerApiService
        }
    }
}