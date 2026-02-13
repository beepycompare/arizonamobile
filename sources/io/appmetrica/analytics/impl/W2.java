package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class W2 extends Ci {
    public W2(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Ci
    public final Object a(int i) {
        return Boolean.valueOf(this.f536a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f536a.getResources().getBoolean(i));
    }
}
