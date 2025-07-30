package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0572s3 extends Pi {
    public C0572s3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Pi
    public final Object a(int i) {
        return Boolean.valueOf(this.f599a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f599a.getResources().getBoolean(i));
    }
}
