package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.v3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0649v3 extends Yi {
    public C0649v3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Yi
    public final Object a(int i) {
        return Boolean.valueOf(this.f755a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f755a.getResources().getBoolean(i));
    }
}
