package com.qianxinde.libtest.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.library.common.utils.GlideUtils

/**
 * @author yangbw
 */
object ImageViewAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setSrc(view: ImageView, bitmap: Bitmap?) {
        view.setImageBitmap(bitmap)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setSrc(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }

    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun loadImage(imageView: ImageView, url: String?) {
        GlideUtils.loadImage(imageView, url)
    }

    @JvmStatic
    @BindingAdapter("app:loadCircleImage")
    fun loadCircleImage(imageView: ImageView, url: String?) {
        GlideUtils.loadCircleImage(imageView, url)
    }

    @JvmStatic
    @BindingAdapter("app:loadRoundImage")
    fun loadRoundImage(imageView: ImageView, url: String?) {
        GlideUtils.loadRoundImage(imageView, url)
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl", "app:placeHolder", "app:error")
    fun loadImage(
        imageView: ImageView,
        url: String?,
        holderDrawable: Drawable?,
        errorDrawable: Drawable?
    ) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(holderDrawable)
            .error(errorDrawable)
            .into(imageView)
    }
}