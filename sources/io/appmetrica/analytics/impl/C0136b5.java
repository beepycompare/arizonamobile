package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.b5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0136b5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f917a;
    public final Q4 b;
    public final C0732yk c = C0448na.k().B();

    public C0136b5(Context context, Q4 q4) {
        this.f917a = context;
        this.b = q4;
    }

    public final We a() {
        return new We(this.c.b(this.f917a, this.b));
    }
}
