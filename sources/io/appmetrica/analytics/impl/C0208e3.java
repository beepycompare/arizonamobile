package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.e3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0208e3 extends Hi {
    public C0208e3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Hi
    public final Object a(int i) {
        return Boolean.valueOf(this.f509a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f509a.getResources().getBoolean(i));
    }
}
