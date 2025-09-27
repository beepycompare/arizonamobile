package com.airbnb.lottie.model.content;

import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
/* loaded from: classes3.dex */
public enum LBlendMode {
    NORMAL,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
    ADD,
    HARD_MIX;

    public BlendModeCompat toNativeBlendMode() {
        int ordinal = ordinal();
        if (ordinal == 1) {
            if (Build.VERSION.SDK_INT >= 29) {
                return BlendModeCompat.MULTIPLY;
            }
            return BlendModeCompat.MODULATE;
        } else if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    if (ordinal != 5) {
                        if (ordinal != 16) {
                            return null;
                        }
                        return BlendModeCompat.PLUS;
                    }
                    return BlendModeCompat.LIGHTEN;
                }
                return BlendModeCompat.DARKEN;
            }
            return BlendModeCompat.OVERLAY;
        } else {
            return BlendModeCompat.SCREEN;
        }
    }
}
