package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0342j3 extends Wi {
    public C0342j3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Wi
    public final Object a(int i) {
        return Boolean.valueOf(this.f826a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f826a.getResources().getBoolean(i));
    }
}
