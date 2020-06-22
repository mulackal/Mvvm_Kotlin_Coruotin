package com.vip.mvvm_setup


import android.app.Dialog
import android.content.Context

import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar



open class BaseFragment : Fragment() {

    // This is for showing the progress
    var mLoadingDialog: Dialog? = null

    fun showLoadingDialog(context: Context) {
        if (mLoadingDialog == null) {
            callLoader(context)
        }else{
            hideaLoadingDialog()
            callLoader(context)
        }
    }

    private fun callLoader(context: Context) {
        mLoadingDialog = Dialog(context)
        mLoadingDialog!!.setCancelable(false)
        mLoadingDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mLoadingDialog!!.setContentView(R.layout.dialogue_loading_layout)
        mLoadingDialog!!.window!!.setBackgroundDrawableResource(
            android.R.color.transparent)

        mLoadingDialog!!.show()
    }

    // This is for hiding the progress
    fun hideaLoadingDialog() {
        if (mLoadingDialog != null)
            if (mLoadingDialog!!.isShowing) {
                mLoadingDialog!!.cancel()
                mLoadingDialog!!.window!!.closeAllPanels()
            }
    }


    fun showSnackBar(snackBarView: View, message: String) {
        val snackbar: Snackbar
        snackbar = Snackbar.make(snackBarView, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }



    fun startFragment(frame: Int, fragment: Fragment, tag: String) {
        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(frame, fragment, tag)
        fragmentTransaction.commitAllowingStateLoss()
    }

}
