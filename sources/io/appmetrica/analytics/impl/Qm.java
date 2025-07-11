package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Qm extends Mi {
    public Qm(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.Mi
    public final Object a(int i) {
        return this.f539a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.f539a.getResources().getStringArray(i);
    }
}
