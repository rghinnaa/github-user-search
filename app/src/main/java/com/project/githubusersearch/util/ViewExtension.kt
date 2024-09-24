package com.project.githubusersearch.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.project.githubusersearch.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlin.math.round

fun Activity?.hideKeyboard(view: View) {
    val imm = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

fun EditText.addDelayOnTypeWithScope(
    delayMillis: Long = 0,
    scope: CoroutineScope,
    action: (String) -> Unit
) {
    var job: Job? = null

    addTextChangedListener {
        job?.cancel()

        job = scope.launch {
            delay(delayMillis)
            action(it.toString())
        }
    }
}

fun Context?.drawable(@DrawableRes drawableRes: Int) =
    this?.let { ContextCompat.getDrawable(it, drawableRes) } ?: ColorDrawable(Color.TRANSPARENT)

fun getTimeZoneById(id: String = "GMT+07:00"): TimeZone {
    return TimeZone.getTimeZone(id)
}

val applicationTimeZone get() = getTimeZoneById()

fun dateFormatter(format: String = "yyyy-MM-dd"): SimpleDateFormat {
    val locale = Locale("id", "ID")

    return SimpleDateFormat(format, locale).apply {
        timeZone = applicationTimeZone
    }
}

fun convertDate(date: String): Date {
    val instant = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Instant.parse(date)
    } else {
        TODO("VERSION.SDK_INT < O")
    }

    return Date.from(instant)
}

@SuppressLint("CheckResult")
fun ImageView.loadImage(
    source: Any?,
    corner: ImageCornerOptions? = ImageCornerOptions.NORMAL,
    radius: Int? = null,
    overrideSize: Int? = null,
    @ColorRes background: Int? = null,
    scaleType: ImageView.ScaleType? = null,
    placeHolder: Drawable? = ColorDrawable(Color.LTGRAY),
) {
    val requestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    when (corner) {
        ImageCornerOptions.NORMAL -> {
            requestOptions.transform(
                CenterCrop()
            )
        }

        ImageCornerOptions.CIRCLE -> {
            requestOptions.transform(
                CenterCrop(),
                RoundedCorners(
                    resources.getDimensionPixelSize(
                        R.dimen._200dp
                    )
                )
            )
        }

        ImageCornerOptions.ROUNDED -> {
            val cornerRadius = if (radius != null) {
                round(
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        radius.toFloat(),
                        resources.displayMetrics
                    )
                ).toInt()
            } else {
                resources.getDimensionPixelSize(R.dimen._4dp)
            }

            requestOptions.transform(
                CenterCrop(),
                RoundedCorners(cornerRadius)
            )
        }
        else -> {}
    }

    source?.let {
        if (scaleType == ImageView.ScaleType.FIT_CENTER) requestOptions.fitCenter()
        else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) requestOptions.centerInside()

        if (overrideSize != null) {
            requestOptions.override(overrideSize)
        }

        requestOptions.placeholder(placeHolder).error(placeHolder)

        Glide.with(context)
            .load(it)
            .apply(requestOptions)
            .into(this)

        if (background != null) {
            doOnPreDraw {
                setBackground(
                    context.createCircleDrawable(
                        Pair(measuredWidth, measuredHeight),
                        background
                    )
                )
            }
        }
    }
}

fun Context.createCircleDrawable(
    whSize: Pair<Int, Int>,
    @ColorRes backgroundColor: Int = R.color.black
): GradientDrawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.OVAL
        cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        color = colorStateList(backgroundColor)
        setSize(whSize.first, whSize.second)
    }
}

fun Context?.colorStateList(@ColorRes colorRes: Int) =
    this?.let { ContextCompat.getColorStateList(it, colorRes) }
        ?: ColorStateList.valueOf(Color.TRANSPARENT)

enum class ImageCornerOptions {
    NORMAL, CIRCLE, ROUNDED
}