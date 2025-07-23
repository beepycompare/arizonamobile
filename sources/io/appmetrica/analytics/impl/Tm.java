package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Tm extends Pi {
    public Tm(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.Pi
    public final Object a(int i) {
        return this.f598a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.f598a.getResources().getStringArray(i);
    }
}
