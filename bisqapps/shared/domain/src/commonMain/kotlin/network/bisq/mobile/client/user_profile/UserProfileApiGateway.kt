package network.bisq.mobile.domain.client.main.user_profile

import co.touchlab.kermit.Logger
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import network.bisq.mobile.client.service.ApiRequestService
import network.bisq.mobile.client.user_profile.UserProfileResponse
import network.bisq.mobile.domain.user.identity.PreparedData
import network.bisq.mobile.utils.ByteArrayAsBase64Serializer

class UserProfileApiGateway(
    private val apiRequestService: ApiRequestService
) {
    private val log = Logger.withTag("UserProfileApiGateway")

    suspend fun requestPreparedData(): Pair<String, PreparedData> {
        val response = apiRequestService.get("user-identity/prepared-data")
        val json = Json {
            serializersModule = SerializersModule {
                contextual(ByteArrayAsBase64Serializer)
            }
        }
        return Pair(response, json.decodeFromString<PreparedData>(response))
    }

    suspend fun createAndPublishNewUserProfile(
        nickName: String,
        preparedDataAsJson: String
    ): UserProfileResponse {
        val createUserIdentityRequest = CreateUserIdentityRequest(
            nickName,
            "",
            "",
            preparedDataAsJson
        )
        val response =
            apiRequestService.post("user-identity/user-identities", createUserIdentityRequest)
        return Json.decodeFromString(response)
    }
}