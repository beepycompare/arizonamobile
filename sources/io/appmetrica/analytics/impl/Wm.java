package io.appmetrica.analytics.impl;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
/* loaded from: classes5.dex */
public final class Wm extends Di {
    public Wm(Context context, String str) {
        super(context, str, TypedValues.Custom.S_STRING);
    }

    @Override // io.appmetrica.analytics.impl.Di
    public final Object a(int i) {
        return this.f545a.getString(i);
    }

    public final String b(int i) {
        return this.f545a.getString(i);
    }
}
