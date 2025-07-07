package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;
/* loaded from: classes3.dex */
public class IgnoreDisabledSystemAnimationsOption implements ReducedMotionOption {
    @Override // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(Context context) {
        return ReducedMotionMode.STANDARD_MOTION;
    }
}
