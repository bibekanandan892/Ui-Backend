package com.example.domain.model

sealed class Endpoint(val path : String){
    object Root : Endpoint(path = "/")
    object TokenVerification : Endpoint(path = "/token_verification")
    object GetUiScreen: Endpoint(path = "/get_screen")
    object SaveUi: Endpoint(path = "/save_ui")

    object UpdateMainScreen : Endpoint(path = "/update_main_screen")
    object UpdateRowItem : Endpoint(path = "/update_row_item")
    object UpdateDetailsColumn : Endpoint(path = "/update_details_column")
    object UpdateImageUI : Endpoint(path = "/update_image")
    object DeleteUser : Endpoint(path = "/delete_user")
    object SignOut : Endpoint(path = "/sign_out")
    object Unauthorized : Endpoint(path = "/unauthorized")
    object Authorized : Endpoint(path = "/authorized")
}
