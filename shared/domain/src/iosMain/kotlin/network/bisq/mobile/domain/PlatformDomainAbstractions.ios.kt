@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package network.bisq.mobile.domain

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings
import kotlinx.cinterop.*
import kotlinx.serialization.Serializable
import platform.Foundation.NSData
import platform.UIKit.UIImage
import platform.Foundation.create
import platform.UIKit.UIImagePNGRepresentation

import platform.UIKit.UIDevice
import platform.posix.memcpy

@OptIn(ExperimentalSettingsImplementation::class)
actual fun getPlatformSettings(): Settings {
    // TODO we might get away just using normal Settings() KMP agnostic implementation,
    // leaving this here to be able to choose the specific one for iOS - defaulting to KeyChain
    return KeychainSettings("Settings")
}

class IOSPlatformInfo: PlatformInfo {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatformInfo(): PlatformInfo = IOSPlatformInfo()

@Serializable(with = PlatformImageSerializer::class)
actual class PlatformImage(val image: UIImage) {
    actual fun serialize(): ByteArray {
        val nsData: NSData = UIImagePNGRepresentation(image)!!
        return nsData.toByteArray()
    }

    companion actual object {
        actual fun deserialize(data: ByteArray): PlatformImage {
            val nsData = data.toNSData()
            val image = UIImage(data = nsData)!!
            return PlatformImage(image)
        }
    }
}

// Helper extensions for NSData conversion:
@OptIn(ExperimentalForeignApi::class)
fun NSData.toByteArray(): ByteArray {
    val byteArray = ByteArray(this.length.toInt())
    byteArray.usePinned { pinned ->
        memcpy(pinned.addressOf(0), this.bytes, this.length)
    }
    return byteArray
}

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
fun ByteArray.toNSData(): NSData {
    return NSData.create(bytes = this.refTo(0).getPointer(MemScope()), length = this.size.toULong())
}