package com.vip.mvvm_setup.ui.callback

/**
 * Created by vipin
 */
interface HomeListenerView {
    fun ShowWarningMessage(str: String?)
    fun ItemClick(id: String?)
    fun deleteItem(data: String?, pos: Int)
}