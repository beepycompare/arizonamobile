package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Um extends Di {
    public Um(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.Di
    public final Object a(int i) {
        return this.f544a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.f544a.getResources().getStringArray(i);
    }
}
