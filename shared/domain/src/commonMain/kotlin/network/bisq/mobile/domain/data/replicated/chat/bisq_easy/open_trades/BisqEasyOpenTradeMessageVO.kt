package network.bisq.mobile.domain.data.replicated.chat.bisq_easy.open_trades

import kotlinx.serialization.Serializable
import network.bisq.mobile.domain.data.replicated.chat.ChatChannelDomainEnum
import network.bisq.mobile.domain.data.replicated.chat.ChatMessageTypeEnum
import network.bisq.mobile.domain.data.replicated.chat.CitationVO
import network.bisq.mobile.domain.data.replicated.network.identity.NetworkIdVO
import network.bisq.mobile.domain.data.replicated.offer.bisq_easy.BisqEasyOfferVO
import network.bisq.mobile.domain.data.replicated.user.profile.UserProfileVO

@Serializable
data class BisqEasyOpenTradeMessageVO(
    val id: String,
    val chatChannelDomain: ChatChannelDomainEnum,
    val channelId: String,
    val text: String?,
    val citation: CitationVO?,
    val date: Long,
    val wasEdited: Boolean,
    val chatMessageType: ChatMessageTypeEnum,
    val receiverUserProfileId: String,
    val senderUserProfile: UserProfileVO,
    val receiverNetworkId: NetworkIdVO,
    val tradeId: String,
    val mediator: UserProfileVO?,
    val bisqEasyOffer: BisqEasyOfferVO?,
)