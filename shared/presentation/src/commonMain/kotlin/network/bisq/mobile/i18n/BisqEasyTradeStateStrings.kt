package network.bisq.mobile.i18n

// Can't have 500+ (or even less) keys in a single class. So splitting it up
// Partial from BisqEasyStrings.kt
data class BisqEasyTradeStateStrings(
    val bisqEasy_tradeState_requestMediation: String,
    val bisqEasy_tradeState_reportToMediator: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_title: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_description_buyersPrice: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_description_sellersPrice: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_description_question: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_description_disclaimer: String,
    val bisqEasy_tradeState_acceptOrRejectSellersPrice_button_accept: String,
    val bisqEasy_tradeState_header_peer: String,
    val bisqEasy_tradeState_header_direction: String,
    val bisqEasy_tradeState_header_send: String,
    val bisqEasy_tradeState_header_pay: String,
    val bisqEasy_tradeState_header_receive: String,
    val bisqEasy_tradeState_header_tradeId: String,
    val bisqEasy_tradeState_phase1: String,
    val bisqEasy_tradeState_phase2: String,
    val bisqEasy_tradeState_phase3: String,
    val bisqEasy_tradeState_phase4: String,
    val bisqEasy_tradeState_info_phase3b_balance_help_explorerLookup: String,
    val bisqEasy_tradeState_info_phase3b_balance_help_notConfirmed: String,
    val bisqEasy_tradeState_info_phase3b_balance_help_confirmed: String,
    val bisqEasy_tradeState_info_phase3b_txId_failed: String,
    val bisqEasy_tradeState_info_phase3b_button_skip: String,
    val bisqEasy_tradeState_info_phase3b_balance_invalid_noOutputsForAddress: String,
    val bisqEasy_tradeState_info_phase3b_balance_invalid_multipleOutputsForAddress: String,
    val bisqEasy_tradeState_info_phase3b_balance_invalid_amountNotMatching: String,
    val bisqEasy_tradeState_info_phase3b_button_next: String,
    val bisqEasy_tradeState_info_phase3b_button_next_amountNotMatching: String,
    val bisqEasy_tradeState_info_phase3b_button_next_noOutputForAddress: String,
    val bisqEasy_tradeState_info_phase3b_button_next_amountNotMatching_resolved: String,
    val bisqEasy_tradeState_info_phase3b_txId: String,
    val bisqEasy_tradeState_info_phase3b_txId_tooltip: String,
    val bisqEasy_tradeState_info_phase3b_lightning_preimage: String,
    val bisqEasy_tradeState_info_phase4_txId_tooltip: String,
    val bisqEasy_tradeState_info_phase4_exportTrade: String,
    val bisqEasy_tradeState_info_phase4_leaveChannel: String,
    val bisqEasy_tradeState_bitcoinPaymentData_MAIN_CHAIN: String,
    val bisqEasy_tradeState_bitcoinPaymentData_LN: String,
    val bisqEasy_tradeState_paymentProof_MAIN_CHAIN: String,
    val bisqEasy_tradeState_paymentProof_LN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_headline_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_description_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_prompt_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_tradeLogMessage_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_headline_LN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_description_LN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_prompt_LN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_tradeLogMessage_LN: String,
    val bisqEasy_tradeState_info_buyer_phase1a_bitcoinPayment_walletHelp: String,
    val bisqEasy_tradeState_info_buyer_phase1a_walletHelpButton: String,
    val bisqEasy_tradeState_info_buyer_phase1a_send: String,
    val bisqEasy_tradeState_info_buyer_phase1a_scanQrCode_tooltip: String,
    val bisqEasy_tradeState_info_buyer_phase1a_scanQrCode_webcamState_description: String,
    val bisqEasy_tradeState_info_buyer_phase1a_scanQrCode_webcamState_connecting: String,
    val bisqEasy_tradeState_info_buyer_phase1a_scanQrCode_webcamState_imageRecognized: String,
    val bisqEasy_tradeState_info_buyer_phase1a_scanQrCode_webcamState_failed: String,
    val bisqEasy_tradeState_info_buyer_phase1b_headline: String,
    val bisqEasy_tradeState_info_buyer_phase1b_info: String,
    val bisqEasy_tradeState_info_buyer_phase2a_headline: (String) -> String,
    val bisqEasy_tradeState_info_buyer_phase2a_quoteAmount: String,
    val bisqEasy_tradeState_info_buyer_phase2a_sellersAccount: String,
    val bisqEasy_tradeState_info_buyer_phase2a_reasonForPaymentInfo: String,
    val bisqEasy_tradeState_info_buyer_phase2a_confirmFiatSent: (String) -> String,
    val bisqEasy_tradeState_info_buyer_phase2a_tradeLogMessage: String,
    val bisqEasy_tradeState_info_buyer_phase2b_headline: String,
    val bisqEasy_tradeState_info_buyer_phase2b_info: (String, String) -> String,
    val bisqEasy_tradeState_info_buyer_phase3a_headline: String,
    val bisqEasy_tradeState_info_buyer_phase3a_info: (String) -> String,
    val bisqEasy_tradeState_info_buyer_phase3b_headline_ln: String,
    val bisqEasy_tradeState_info_buyer_phase3b_info_ln: String,
    val bisqEasy_tradeState_info_buyer_phase3b_confirmButton_ln: String,
    val bisqEasy_tradeState_info_buyer_phase3b_tradeLogMessage_ln: String,
    val bisqEasy_tradeState_info_buyer_phase3b_headline_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase3b_info_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_buyer_phase3b_balance: String,
    val bisqEasy_tradeState_info_buyer_phase3b_balance_prompt: String,
    val bisqEasy_tradeState_info_seller_phase1_headline: String,
    val bisqEasy_tradeState_info_seller_phase1_accountData: String,
    val bisqEasy_tradeState_info_seller_phase1_accountData_prompt: String,
    val bisqEasy_tradeState_info_seller_phase1_buttonText: String,
    val bisqEasy_tradeState_info_seller_phase1_note: String,
    val bisqEasy_tradeState_info_seller_phase1_tradeLogMessage: String,
    val bisqEasy_tradeState_info_seller_phase2a_waitForPayment_headline: String,
    val bisqEasy_tradeState_info_seller_phase2a_waitForPayment_info: String,
    val bisqEasy_tradeState_info_seller_phase2b_headline: String,
    val bisqEasy_tradeState_info_seller_phase2b_info: String,
    val bisqEasy_tradeState_info_seller_phase2b_fiatReceivedButton: String,
    val bisqEasy_tradeState_info_seller_phase2b_tradeLogMessage: String,
    val bisqEasy_tradeState_info_seller_phase3a_fiatPaymentReceivedCheckBox: String,
    val bisqEasy_tradeState_info_seller_phase3a_sendBtc: String,
    val bisqEasy_tradeState_info_seller_phase3a_baseAmount: String,
    val bisqEasy_tradeState_info_seller_phase3a_qrCodeDisplay_openWindow: String,
    val bisqEasy_tradeState_info_seller_phase3a_qrCodeDisplay_window_title: String,
    val bisqEasy_tradeState_info_seller_phase3b_headline_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3b_info_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3b_balance: String,
    val bisqEasy_tradeState_info_seller_phase3b_balance_prompt: String,
    val bisqEasy_tradeState_info_seller_phase3a_bitcoinPayment_description_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_description_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_prompt_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3a_tradeLogMessage_paymentProof_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3a_bitcoinPayment_description_LN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_description_LN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_prompt_LN: String,
    val bisqEasy_tradeState_info_seller_phase3a_tradeLogMessage_paymentProof_LN: String,
    val bisqEasy_tradeState_info_seller_phase3a_btcSentButton: String,
    val bisqEasy_tradeState_info_seller_phase3a_tradeLogMessage: String,
    val bisqEasy_tradeState_info_seller_phase3a_tradeLogMessage_noProofProvided: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_warning_MAIN_CHAIN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_warning_LN: String,
    val bisqEasy_tradeState_info_seller_phase3a_paymentProof_warning_proceed: String,
    val bisqEasy_tradeState_info_seller_phase3b_headline_ln: String,
    val bisqEasy_tradeState_info_seller_phase3b_info_ln: String,
    val bisqEasy_tradeState_info_seller_phase3b_confirmButton_ln: String,
    val bisqEasy_tradeCompleted_title: String,
    val bisqEasy_tradeCompleted_tableTitle: String,
    val bisqEasy_tradeCompleted_header_tradeWith: String,
    val bisqEasy_tradeCompleted_header_myDirection_seller: String,
    val bisqEasy_tradeCompleted_header_myDirection_buyer: String,
    val bisqEasy_tradeCompleted_header_myDirection_btc: String,
    val bisqEasy_tradeCompleted_header_myOutcome_seller: String,
    val bisqEasy_tradeCompleted_header_myOutcome_buyer: String,
    val bisqEasy_tradeCompleted_header_paymentMethod: String,
    val bisqEasy_tradeCompleted_header_tradeId: String,
    val bisqEasy_tradeCompleted_body_date: String,
    val bisqEasy_tradeCompleted_body_tradePrice: String,
    val bisqEasy_tradeCompleted_body_tradeFee: String,
    val bisqEasy_tradeCompleted_body_tradeFee_value: String,
    val bisqEasy_tradeCompleted_body_copy_txId_tooltip: String,
    val bisqEasy_tradeCompleted_body_copy_explorerLink_tooltip: String,
    val bisqEasy_tradeCompleted_body_txId_tooltip: String,
    val bisqEasy_mediation_request_confirm_headline: String,
    val bisqEasy_mediation_request_confirm_msg: String,
    val bisqEasy_mediation_request_confirm_openMediation: String,
    val bisqEasy_mediation_request_feedback_headline: String,
    val bisqEasy_mediation_request_feedback_msg: String,
    val bisqEasy_mediation_request_feedback_noMediatorAvailable: String,
    val bisqEasy_mediation_requester_tradeLogMessage: String,

    // Mobile app specific
    val bisqEasy_tradeState_info_buyer_phase1a_seller_wait_message: String,
    val bisqEasy_tradeState_info_buyer_phase1a_wallet_prompt_prefix: String,
    val bisqEasy_tradeState_info_buyer_phase2a_seller_wait_message: String,
    val bisqEasy_tradeState_info_buyer_phase3a_seller_wait_message: String,
    val bisqEasy_tradeCompleted_body_you_have_receveid: String,
    val bisqEasy_tradeCompleted_body_you_have_sold: String,
)
