package network.bisq.mobile.android.node.presentation

import network.bisq.mobile.domain.data.model.Settings
import network.bisq.mobile.domain.data.repository.SettingsRepository
import network.bisq.mobile.domain.data.repository.UserRepository
import network.bisq.mobile.domain.service.bootstrap.ApplicationBootstrapFacade
import network.bisq.mobile.domain.service.settings.SettingsServiceFacade
import network.bisq.mobile.domain.service.user_profile.UserProfileServiceFacade
import network.bisq.mobile.presentation.MainPresenter
import network.bisq.mobile.presentation.ui.uicases.startup.SplashPresenter

class NodeSplashPresenter(
    mainPresenter: MainPresenter,
    applicationBootstrapFacade: ApplicationBootstrapFacade,
    userProfileService: UserProfileServiceFacade,
    userRepository: UserRepository,
    settingsRepository: SettingsRepository,
    settingsServiceFacade: SettingsServiceFacade
) : SplashPresenter(
    mainPresenter,
    applicationBootstrapFacade,
    userProfileService,
    userRepository,
    settingsRepository,
    settingsServiceFacade
) {

    override fun doCustomNavigationLogic(settings: Settings, hasProfile: Boolean): Boolean {
        navigateToCreateProfile()
        // do nothing
        return false
    }
}
