package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Tm extends Ci {
    public Tm(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.Ci
    public final Object a(int i) {
        return this.f541a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.f541a.getResources().getStringArray(i);
    }
}
