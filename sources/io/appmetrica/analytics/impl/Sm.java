package io.appmetrica.analytics.impl;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
/* loaded from: classes4.dex */
public final class Sm extends Mi {
    public Sm(Context context, String str) {
        super(context, str, TypedValues.Custom.S_STRING);
    }

    @Override // io.appmetrica.analytics.impl.Mi
    public final Object a(int i) {
        return this.f538a.getString(i);
    }

    public final String b(int i) {
        return this.f538a.getString(i);
    }
}
