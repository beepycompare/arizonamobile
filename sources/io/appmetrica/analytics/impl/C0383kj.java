package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0383kj implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1070a;
    public final String b = "rustore";

    public C0383kj(Context context) {
        this.f1070a = context;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        new C0461nj(this.f1070a).a(dg);
    }
}
