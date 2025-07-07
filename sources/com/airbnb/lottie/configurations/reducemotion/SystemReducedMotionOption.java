package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;
import com.airbnb.lottie.utils.Utils;
/* loaded from: classes3.dex */
public class SystemReducedMotionOption implements ReducedMotionOption {
    @Override // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(Context context) {
        if (context == null || Utils.getAnimationScale(context) != 0.0f) {
            return ReducedMotionMode.STANDARD_MOTION;
        }
        return ReducedMotionMode.REDUCED_MOTION;
    }
}
