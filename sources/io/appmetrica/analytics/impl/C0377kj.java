package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0377kj implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1073a;
    public final String b = "rustore";

    public C0377kj(Context context) {
        this.f1073a = context;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        new C0455nj(this.f1073a).a(dg);
    }
}
