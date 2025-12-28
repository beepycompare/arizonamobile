package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class X2 extends Di {
    public X2(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Di
    public final Object a(int i) {
        return Boolean.valueOf(this.f545a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f545a.getResources().getBoolean(i));
    }
}
