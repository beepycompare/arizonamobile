package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.DeviceProperties;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static final int zab(int i, int i2, int i3, int i4) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return i4;
                }
                throw new IllegalStateException("Unknown color scheme: " + i);
            }
            return i3;
        }
        return i2;
    }

    public final void zaa(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int zab = zab(i2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
        int zab2 = zab(i2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
        if (i == 0 || i == 1) {
            zab = zab2;
        } else if (i != 2) {
            throw new IllegalStateException("Unknown button size: " + i);
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(zab));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
        if (i == 0) {
            setText(resources.getString(R.string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(R.string.common_signin_button_text_long));
        } else if (i == 2) {
            setText((CharSequence) null);
        } else {
            throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
