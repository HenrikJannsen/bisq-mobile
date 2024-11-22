package network.bisq.mobile.presentation.ui.uicases.startup

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import network.bisq.mobile.domain.data.repository.main.bootstrap.ApplicationBootstrapFacade
import network.bisq.mobile.presentation.BasePresenter
import network.bisq.mobile.presentation.MainPresenter
import network.bisq.mobile.presentation.ui.navigation.Routes

open class SplashPresenter(
    mainPresenter: MainPresenter,
    applicationBootstrapFacade: ApplicationBootstrapFacade
) : BasePresenter(mainPresenter) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val state: StateFlow<String> = applicationBootstrapFacade.state
    val progress: StateFlow<Float> = applicationBootstrapFacade.progress

    override fun onViewAttached() {
        coroutineScope.launch {
            progress.collect { value ->
                when {
                    value == 1.0f -> navigateToNextScreen()
                }
            }
        }
    }

    private fun navigateToNextScreen() {
        // TODO: Conditional nav
        // If firstTimeApp launch, goto Onboarding[clientMode] (androidNode / xClient)
        // If not, goto TabContainerScreen
        /*  rootNavigator.navigate(Routes.Onboarding.name) {
              popUpTo(Routes.Splash.name) { inclusive = true }
          }*/

        //TODO
        /* rootNavigator.navigate(Routes.TabContainer.name) {
             popUpTo(Routes.TrustedNodeSetup.name) { inclusive = true }
         }*/
        rootNavigator.navigate(Routes.CreateProfile.name) {
            popUpTo(Routes.Splash.name) { inclusive = true }
        }
    }

}
