package network.bisq.mobile.presentation.ui.uicases.settings

import network.bisq.mobile.domain.data.repository.SettingsRepository
import network.bisq.mobile.presentation.BasePresenter
import network.bisq.mobile.presentation.MainPresenter
import network.bisq.mobile.presentation.ui.components.molecules.settings.MenuItem

/**
 * SettingsPresenter with default implementation
 */
open class SettingsPresenter(
    private val settingsRepository: SettingsRepository,
    mainPresenter: MainPresenter): BasePresenter(mainPresenter), ISettingsPresenter {

    final override fun menuTree(): MenuItem {
        val defaultList: MutableList<MenuItem> = mutableListOf(
            MenuItem.Parent(
                label = "Account",
                children = listOf(
                    MenuItem.Leaf(label = "User Profile", content = { UserProfileSettingsScreen() }),
                    MenuItem.Leaf(label = "Payment Accounts", content = { PaymentAccountSettingsScreen() })
                )
            )
        )
        return MenuItem.Parent(
            label = "Bisq",
            children = addCustomSettings(defaultList)
            )
    }

    protected open fun addCustomSettings(menuItems: MutableList<MenuItem>): List<MenuItem> {
        menuItems.add(MenuItem.Leaf("Trusted Node", content = { TrustedNodeSettingsScreen() }))
        return menuItems.toList()
    }
}