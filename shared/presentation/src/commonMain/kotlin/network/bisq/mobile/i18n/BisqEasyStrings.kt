package network.bisq.mobile.i18n

// From bisq_easy.properties
data class BisqEasyStrings(
    val bisqEasy_offerBookChannel_description: String,
    val bisqEasy_mediator: String,
    val bisqEasy_dashboard: String,
    val bisqEasy_offerbook: String,
    val bisqEasy_openTrades: String,
    val bisqEasy_onboarding_top_headline: String,
    val bisqEasy_onboarding_top_content1: String,
    val bisqEasy_onboarding_top_content2: String,
    val bisqEasy_onboarding_top_content3: String,
    val bisqEasy_onboarding_openTradeGuide: String,
    val bisqEasy_onboarding_watchVideo: String,
    val bisqEasy_onboarding_watchVideo_tooltip: String,
    val bisqEasy_onboarding_left_headline: String,
    val bisqEasy_onboarding_left_info: String,
    val bisqEasy_onboarding_left_button: String,
    val bisqEasy_onboarding_right_headline: String,
    val bisqEasy_onboarding_right_info: String,
    val bisqEasy_onboarding_right_button: String,
    val bisqEasy_takeOffer_progress_amount: String,
    val bisqEasy_takeOffer_progress_method: String,
    val bisqEasy_takeOffer_progress_review: String,
    val bisqEasy_takeOffer_amount_headline_buyer: String,
    val bisqEasy_takeOffer_amount_headline_seller: String,
    val bisqEasy_takeOffer_amount_description: (Double, Double) -> String,
    val bisqEasy_takeOffer_amount_description_limitedByTakersReputation: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_tooHighMax: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfoAmount: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_tooHighMax_overlay_info: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_minAmountCovered: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_minAmountCovered_overlay_info: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_minAmountNotCovered: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_tooHighMin_overlay_info: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_learnMore: String,
    val bisqEasy_takeOffer_amount_buyer_limitInfo_overlay_linkToWikiText: String,
    val bisqEasy_takeOffer_paymentMethods_headline_fiat: String,
    val bisqEasy_takeOffer_paymentMethods_headline_fiatAndBitcoin: String,
    val bisqEasy_takeOffer_paymentMethods_headline_bitcoin: String,
    val bisqEasy_takeOffer_paymentMethods_subtitle_fiat_buyer: (String) -> String,
    val bisqEasy_takeOffer_paymentMethods_subtitle_fiat_seller: (String) -> String,
    val bisqEasy_takeOffer_paymentMethods_subtitle_bitcoin_buyer: String,
    val bisqEasy_takeOffer_paymentMethods_subtitle_bitcoin_seller: String,
    val bisqEasy_takeOffer_review_headline: String,
    val bisqEasy_takeOffer_review_detailsHeadline: String,
    val bisqEasy_takeOffer_review_method_fiat: String,
    val bisqEasy_takeOffer_review_method_bitcoin: String,
    val bisqEasy_takeOffer_review_price_price: String,
    val bisqEasy_takeOffer_review_noTradeFees: String,
    val bisqEasy_takeOffer_review_sellerPaysMinerFeeLong: String,
    val bisqEasy_takeOffer_review_sellerPaysMinerFee: String,
    val bisqEasy_takeOffer_review_noTradeFeesLong: String,
    val bisqEasy_takeOffer_review_takeOffer: String,
    val bisqEasy_takeOffer_review_sendTakeOfferMessageFeedback_headline: String,
    val bisqEasy_takeOffer_review_sendTakeOfferMessageFeedback_subTitle: String,
    val bisqEasy_takeOffer_review_sendTakeOfferMessageFeedback_info: String,
    val bisqEasy_takeOffer_review_takeOfferSuccess_headline: String,
    val bisqEasy_takeOffer_review_takeOfferSuccess_subTitle: String,
    val bisqEasy_takeOffer_review_takeOfferSuccessButton: String,
    val bisqEasy_takeOffer_tradeLogMessage: String,
    val bisqEasy_takeOffer_noMediatorAvailable_warning: String,
    val bisqEasy_takeOffer_makerBanned_warning: String,
    val bisqEasy_takeOffer_bitcoinPaymentData_warning_MAIN_CHAIN: String,
    val bisqEasy_takeOffer_bitcoinPaymentData_warning_LN: String,
    val bisqEasy_takeOffer_bitcoinPaymentData_warning_proceed: String,
    val bisqEasy_tradeGuide_tabs_headline: String,
    val bisqEasy_tradeGuide_welcome: String,
    val bisqEasy_tradeGuide_security: String,
    val bisqEasy_tradeGuide_process: String,
    val bisqEasy_tradeGuide_rules: String,
    val bisqEasy_tradeGuide_welcome_headline: String,
    val bisqEasy_tradeGuide_welcome_content: String,
    val bisqEasy_tradeGuide_security_headline: String,
    val bisqEasy_tradeGuide_security_content: String,
    val bisqEasy_tradeGuide_process_headline: String,
    val bisqEasy_tradeGuide_process_content: String,
    val bisqEasy_tradeGuide_process_steps: String,
    val bisqEasy_tradeGuide_rules_headline: String,
    val bisqEasy_tradeGuide_rules_content: String,
    val bisqEasy_tradeGuide_rules_confirm: String,
    val bisqEasy_tradeGuide_notConfirmed_warn: String,
    val bisqEasy_tradeGuide_open: String,
    val bisqEasy_walletGuide_open: String,
    val bisqEasy_walletGuide_tabs_headline: String,
    val bisqEasy_walletGuide_intro: String,
    val bisqEasy_walletGuide_download: String,
    val bisqEasy_walletGuide_createWallet: String,
    val bisqEasy_walletGuide_receive: String,
    val bisqEasy_walletGuide_intro_headline: String,
    val bisqEasy_walletGuide_intro_content: String,
    val bisqEasy_walletGuide_download_headline: String,
    val bisqEasy_walletGuide_download_content: String,
    val bisqEasy_walletGuide_download_link: String,
    val bisqEasy_walletGuide_createWallet_headline: String,
    val bisqEasy_walletGuide_createWallet_content: String,
    val bisqEasy_walletGuide_receive_headline: String,
    val bisqEasy_walletGuide_receive_content: String,
    val bisqEasy_walletGuide_receive_link1: String,
    val bisqEasy_walletGuide_receive_link2: String,
    val bisqEasy_offerbook_markets: String,
    val bisqEasy_offerbook_markets_CollapsedList_Tooltip: String,
    val bisqEasy_offerbook_markets_ExpandedList_Tooltip: String,
    val bisqEasy_offerbook_marketListCell_numOffers_one: String,
    val bisqEasy_offerbook_marketListCell_numOffers_many: String,
    val bisqEasy_offerbook_marketListCell_numOffers_tooltip_none: String,
    val bisqEasy_offerbook_marketListCell_numOffers_tooltip_one: String,
    val bisqEasy_offerbook_marketListCell_numOffers_tooltip_many: String,
    val bisqEasy_offerbook_marketListCell_favourites_tooltip_addToFavourites: String,
    val bisqEasy_offerbook_marketListCell_favourites_tooltip_removeFromFavourites: String,
    val bisqEasy_offerbook_marketListCell_favourites_maxReached_popup: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_tooltip: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_sortTitle: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_mostOffers: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_nameAZ: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_nameZA: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_filterTitle: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_withOffers: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_favourites: String,
    val bisqEasy_offerbook_dropdownMenu_sortAndFilterMarkets_all: String,
    val bisqEasy_offerbook_dropdownMenu_messageTypeFilter_tooltip: String,
    val bisqEasy_offerbook_dropdownMenu_messageTypeFilter_all: String,
    val bisqEasy_offerbook_dropdownMenu_messageTypeFilter_offers: String,
    val bisqEasy_offerbook_dropdownMenu_messageTypeFilter_text: String,
    val bisqEasy_offerbook_chatMessage_deleteOffer_confirmation: String,
    val bisqEasy_offerbook_chatMessage_deleteMessage_confirmation: String,
    val bisqEasy_offerbook_offerList: String,
    val bisqEasy_offerbook_offerList_collapsedList_tooltip: String,
    val bisqEasy_offerbook_offerList_expandedList_tooltip: String,
    val bisqEasy_offerbook_offerList_table_columns_peerProfile: String,
    val bisqEasy_offerbook_offerList_table_columns_price: String,
    val bisqEasy_offerbook_offerList_table_columns_fiatAmount: String,
    val bisqEasy_offerbook_offerList_table_columns_paymentMethod: String,
    val bisqEasy_offerbook_offerList_table_columns_settlementMethod: String,
    val bisqEasy_offerbook_offerList_table_filters_offerDirection_buyFrom: String,
    val bisqEasy_offerbook_offerList_table_filters_offerDirection_sellTo: String,
    val bisqEasy_offerbook_offerList_table_filters_paymentMethods_title: String,
    val bisqEasy_offerbook_offerList_table_filters_paymentMethods_title_all: String,
    val bisqEasy_offerbook_offerList_table_filters_paymentMethods_customPayments: String,
    val bisqEasy_offerbook_offerList_table_filters_paymentMethods_clearFilters: String,
    val bisqEasy_offerbook_offerList_table_filters_showMyOffersOnly: String,
    val bisqEasy_offerbook_offerList_table_columns_price_tooltip_fixPrice: String,
    val bisqEasy_offerbook_offerList_table_columns_price_tooltip_marketPrice: String,
    val bisqEasy_offerbook_offerList_table_columns_price_tooltip_floatPrice: String,
    val bisqEasy_openTrades_table_headline: String,
    val bisqEasy_openTrades_noTrades: String,
    val bisqEasy_openTrades_rejectTrade: String,
    val bisqEasy_openTrades_cancelTrade: String,
    val bisqEasy_openTrades_tradeLogMessage_rejected: String,
    val bisqEasy_openTrades_tradeLogMessage_cancelled: String,
    val bisqEasy_openTrades_rejectTrade_warning: String,
    val bisqEasy_openTrades_cancelTrade_warning_buyer: String,
    val bisqEasy_openTrades_cancelTrade_warning_seller: String,
    val bisqEasy_openTrades_cancelTrade_warning_part2: String,
    val bisqEasy_openTrades_closeTrade_warning_interrupted: String,
    val bisqEasy_openTrades_closeTrade_warning_completed: String,
    val bisqEasy_openTrades_closeTrade: String,
    val bisqEasy_openTrades_confirmCloseTrade: String,
    val bisqEasy_openTrades_exportTrade: String,
    val bisqEasy_openTrades_reportToMediator: String,
    val bisqEasy_openTrades_rejected_self: String,
    val bisqEasy_openTrades_rejected_peer: String,
    val bisqEasy_openTrades_cancelled_self: String,
    val bisqEasy_openTrades_cancelled_peer: String,
    val bisqEasy_openTrades_inMediation_info: String,
    val bisqEasy_openTrades_failed: String,
    val bisqEasy_openTrades_failed_popup: String,
    val bisqEasy_openTrades_failedAtPeer: String,
    val bisqEasy_openTrades_failedAtPeer_popup: String,
    val bisqEasy_openTrades_table_tradePeer: String,
    val bisqEasy_openTrades_table_me: String,
    val bisqEasy_openTrades_table_mediator: String,
    val bisqEasy_openTrades_table_tradeId: String,
    val bisqEasy_openTrades_table_price: String,
    val bisqEasy_openTrades_table_baseAmount: String,
    val bisqEasy_openTrades_table_quoteAmount: String,
    val bisqEasy_openTrades_table_paymentMethod: String,
    val bisqEasy_openTrades_table_paymentMethod_tooltip: String,
    val bisqEasy_openTrades_table_settlementMethod: String,
    val bisqEasy_openTrades_table_settlementMethod_tooltip: String,
    val bisqEasy_openTrades_table_makerTakerRole: String,
    val bisqEasy_openTrades_table_direction_buyer: String,
    val bisqEasy_openTrades_table_direction_seller: String,
    val bisqEasy_openTrades_table_makerTakerRole_maker: String,
    val bisqEasy_openTrades_table_makerTakerRole_taker: String,
    val bisqEasy_openTrades_csv_quoteAmount: String,
    val bisqEasy_openTrades_csv_txIdOrPreimage: String,
    val bisqEasy_openTrades_csv_receiverAddressOrInvoice: String,
    val bisqEasy_openTrades_csv_paymentMethod: String,
    val bisqEasy_openTrades_chat_peer_description: String,
    val bisqEasy_openTrades_chat_detach: String,
    val bisqEasy_openTrades_chat_detach_tooltip: String,
    val bisqEasy_openTrades_chat_attach: String,
    val bisqEasy_openTrades_chat_attach_tooltip: String,
    val bisqEasy_openTrades_chat_window_title: String,
    val bisqEasy_openTrades_chat_peerLeft_headline: String,
    val bisqEasy_openTrades_chat_peerLeft_subHeadline: String,
    val bisqEasy_openTrades_tradeDetails_open: String,
    val bisqEasy_openTrades_tradeDetails_headline: String,
    val bisqEasy_openTrades_tradeDetails_tradeDate: String,
    val bisqEasy_openTrades_tradeDetails_tradersAndRole: String,
    val bisqEasy_openTrades_tradeDetails_tradersAndRole_me: String,
    val bisqEasy_openTrades_tradeDetails_tradersAndRole_peer: String,
    val bisqEasy_openTrades_tradeDetails_tradersAndRole_copy: String,
    val bisqEasy_openTrades_tradeDetails_offerTypeAndMarket: String,
    val bisqEasy_openTrades_tradeDetails_offerTypeAndMarket_buyOffer: String,
    val bisqEasy_openTrades_tradeDetails_offerTypeAndMarket_sellOffer: String,
    val bisqEasy_openTrades_tradeDetails_offerTypeAndMarket_fiatMarket: String,
    val bisqEasy_openTrades_tradeDetails_amountAndPrice: String,
    val bisqEasy_openTrades_tradeDetails_paymentAndSettlementMethods: String,
    val bisqEasy_openTrades_tradeDetails_tradeId: String,
    val bisqEasy_openTrades_tradeDetails_tradeId_copy: String,
    val bisqEasy_openTrades_tradeDetails_peerNetworkAddress: String,
    val bisqEasy_openTrades_tradeDetails_peerNetworkAddress_copy: String,
    val bisqEasy_openTrades_tradeDetails_btcPaymentAddress: String,
    val bisqEasy_openTrades_tradeDetails_lightningInvoice: String,
    val bisqEasy_openTrades_tradeDetails_btcPaymentAddress_copy: String,
    val bisqEasy_openTrades_tradeDetails_lightningInvoice_copy: String,
    val bisqEasy_openTrades_tradeDetails_paymentAccountData: String,
    val bisqEasy_openTrades_tradeDetails_paymentAccountData_copy: String,
    val bisqEasy_openTrades_tradeDetails_assignedMediator: String,
    val bisqEasy_openTrades_tradeDetails_dataNotYetProvided: String,
    val bisqEasy_privateChats_leave: String,
    val bisqEasy_privateChats_table_myUser: String,
    val bisqEasy_topPane_filter: String,
    val bisqEasy_topPane_closeFilter: String,
    val bisqEasy_offerDetails_headline: String,
    val bisqEasy_offerDetails_buy: String,
    val bisqEasy_offerDetails_sell: String,
    val bisqEasy_offerDetails_direction: String,
    val bisqEasy_offerDetails_baseSideAmount: String,
    val bisqEasy_offerDetails_quoteSideAmount: String,
    val bisqEasy_offerDetails_price: String,
    val bisqEasy_offerDetails_priceValue: String,
    val bisqEasy_offerDetails_paymentMethods: String,
    val bisqEasy_offerDetails_id: String,
    val bisqEasy_offerDetails_date: String,
    val bisqEasy_offerDetails_makersTradeTerms: String,
    val bisqEasy_openTrades_welcome_headline: String,
    val bisqEasy_openTrades_welcome_info: String,
    val bisqEasy_openTrades_welcome_line1: String,
    val bisqEasy_openTrades_welcome_line2: String,
    val bisqEasy_openTrades_welcome_line3: String,
)
