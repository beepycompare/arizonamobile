package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.core.math.MathUtils;
/* loaded from: classes4.dex */
public class TypefaceUtils {
    private TypefaceUtils() {
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Context context, Typeface typeface) {
        return maybeCopyWithFontWeightAdjustment(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, MathUtils.clamp(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
