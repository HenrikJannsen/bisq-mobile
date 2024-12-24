@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package network.bisq.mobile.domain

import com.russhwolf.settings.Settings
import kotlinx.serialization.Serializable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.descriptors.*
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

expect fun getPlatformSettings(): Settings

interface PlatformInfo {
    val name: String
}

expect fun getDeviceLanguageCode(): String

expect fun getPlatformInfo(): PlatformInfo

@Serializable(with = PlatformImageSerializer::class)
expect class PlatformImage {
    companion object {
        fun deserialize(data: ByteArray): PlatformImage
    }
    fun serialize(): ByteArray
}

object PlatformImageSerializer : KSerializer<PlatformImage> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("PlatformImage", PrimitiveKind.STRING)

    @OptIn(ExperimentalEncodingApi::class)
    override fun serialize(encoder: Encoder, value: PlatformImage) {
        val byteArray = value.serialize()
        encoder.encodeString(Base64.encode(byteArray))
    }

    @OptIn(ExperimentalEncodingApi::class)
    override fun deserialize(decoder: Decoder): PlatformImage {
        val byteArray = Base64.decode(decoder.decodeString())
        return PlatformImage.deserialize(byteArray)
    }
}