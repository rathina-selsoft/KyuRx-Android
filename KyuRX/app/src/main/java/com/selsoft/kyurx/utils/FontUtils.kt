package com.selsoft.kyurx.utils

import android.content.Context
import android.graphics.Typeface

class FontUtils() {

    companion object {
        fun getPrimaryFont(context: Context): Typeface {
            return Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf")
        }

        fun getPrimaryBoldFont(context: Context): Typeface {
            return Typeface.createFromAsset(context.assets, "fonts/Oxygen-Bold.ttf")
        }

        fun getPrimaryItalicFont(context: Context): Typeface {
            return Typeface.createFromAsset(context.assets, "fonts/Roboto-Italic.ttf")
        }
    }

}