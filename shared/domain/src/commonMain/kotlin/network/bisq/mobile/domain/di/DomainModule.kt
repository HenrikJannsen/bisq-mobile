package network.bisq.mobile.domain.di

import com.russhwolf.settings.Settings
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import network.bisq.mobile.domain.data.persistance.KeyValueStorage
import network.bisq.mobile.domain.data.repository.BisqStatsRepository
import network.bisq.mobile.domain.data.repository.SettingsRepository
import network.bisq.mobile.domain.data.repository.UserRepository
import network.bisq.mobile.domain.getPlatformSettings
import network.bisq.mobile.domain.service.notifications.OpenTradesNotificationService
import org.koin.dsl.module

val domainModule = module {
    // Data
    single<Settings> { getPlatformSettings() }

    // Provide PersistenceSource
    single<KeyValueStorage<*>> {
        KeyValueStorage(
            settings = get(),
            serializer = { Json.encodeToString(it) },
            deserializer = { Json.decodeFromString(it) }
        )
    }

    // Repositories
    single<BisqStatsRepository> { BisqStatsRepository() }
    single<SettingsRepository> { SettingsRepository(get()) }
    single<UserRepository> { UserRepository(get()) }

    // Services
    single<OpenTradesNotificationService> { OpenTradesNotificationService(get(), get()) }
}
