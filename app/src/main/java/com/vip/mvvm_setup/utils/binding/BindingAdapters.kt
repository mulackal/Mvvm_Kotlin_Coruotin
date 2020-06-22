package com.vip.mvvm_setup.utils.binding

import android.os.Build
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.ui.activity.home.HomeAdapter
import com.vip.mvvm_setup.ui.activity.home.HomeProductwiseData


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:dataListHome")
    fun setDataListHome(
        recyclerView: RecyclerView,
        datalist: List<HomeProductwiseData>
    ) {
        val adapter = recyclerView.adapter
        if (adapter != null && adapter is HomeAdapter) {
            (adapter as HomeAdapter).setHomeDataList(datalist!!)
        } else {
            throw IllegalStateException(
                "RecyclerView either has no adapter set or the "
                        + "adapter isn't of type Adapter"
            )
        }
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun loadImage(imageView: ImageView, imageURL: String) {
        val imagePath = "" + imageURL

        val options = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .fitCenter()

        Glide.with(imageView.context)
            .load(imagePath)
            .apply(options)
            .into(imageView)

    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun imageSrcLoader(imageView: ImageView, id: Int) {
        imageView.setImageResource(id)
    }

    @JvmStatic
    @BindingAdapter("android:background")
    fun backgroundLoader(view: View, id: Int) {
        val context = view.context
        val drawable = ContextCompat.getDrawable(context, id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.background = drawable
        } else {
            view.setBackgroundDrawable(drawable)
        }
    }

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun visibility(view: View, visibility: Int) {
        view.visibility = visibility
    }

    @JvmStatic
    @BindingAdapter("android:if")
    fun setViewShowOrGone(view: View, show: Boolean) {
        if (show) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("android:show")
    fun setViewShowOrHide(view: View, show: Boolean) {
        if (show) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.INVISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("android:layout_marginTop")
    fun setLayoutMarginTop(view: View, margin: Float) {
        val lp = view.layoutParams as MarginLayoutParams
        if (lp != null) {
            lp.setMargins(lp.leftMargin, margin.toInt(), lp.rightMargin, lp.bottomMargin)
            view.layoutParams = lp
        }
    }

    @JvmStatic
    @BindingAdapter("android:layout_marginLeft")
    fun setLayoutMarginLeft(view: View, margin: Float) {
        val lp = view.layoutParams as MarginLayoutParams
        if (lp != null) {
            lp.setMargins(margin.toInt(), lp.topMargin, lp.rightMargin, lp.bottomMargin)
            view.layoutParams = lp
        }
    }

    @JvmStatic
    @BindingAdapter("android:layout_marginBottom")
    fun setLayoutMarginBottom(view: View, margin: Float) {
        val lp = view.layoutParams as MarginLayoutParams
        if (lp != null) {
            lp.setMargins(lp.leftMargin, lp.topMargin, lp.rightMargin, margin.toInt())
            view.layoutParams = lp
        }
    }

    @JvmStatic
    @BindingAdapter("android:layout_marginRight")
    fun setLayoutMarginRight(view: View, margin: Float) {
        val lp = view.layoutParams as MarginLayoutParams
        if (lp != null) {
            lp.setMargins(lp.leftMargin, lp.topMargin, margin.toInt(), lp.bottomMargin)
            view.layoutParams = lp
        }
    }

    @JvmStatic
    @BindingAdapter("android:layout_width")
    fun setLayoutWidth(view: View, width: Int) {
        val layoutParams = view.layoutParams
        layoutParams.width = width
        view.layoutParams = layoutParams
    }

    @JvmStatic
    @BindingAdapter("android:layout_height")
    fun setLayoutHeight(view: View, height: Int) {
        val layoutParams = view.layoutParams
        layoutParams.height = height
        view.layoutParams = layoutParams
    }

    @JvmStatic
    @BindingAdapter("android:src", "android:placeholder")
    fun setImageSrcFromUrl(
        imageView: ImageView,
        url: String?,
        placeholder: Int
    ) {
        if (url == null) {
            return
        }

        val options = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .fitCenter()

        Glide.with(imageView.context)
            .load(url)
            .apply(options)
            .into(imageView)

    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageSrcFromUrl(imageView: ImageView, url: String?) {
        if (url == null) {
            return
        }
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("android:onKeyEvent")
    fun onKeyEvent(
        view: View,
        onKeyListener: View.OnKeyListener?
    ) {
        view.setOnKeyListener(onKeyListener)
    }

    @JvmStatic
    @BindingAdapter("android:onEditorAction")
    fun onEditorAction(
        view: TextView,
        onEditorActionListener: OnEditorActionListener?
    ) {
        view.setOnEditorActionListener(onEditorActionListener)
    }
}