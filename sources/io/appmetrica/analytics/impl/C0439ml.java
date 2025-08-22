package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0439ml implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f972a;

    public C0439ml(C0617u0 c0617u0) {
        this.f972a = c0617u0;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Void r3) {
        boolean z;
        this.f972a.getClass();
        synchronized (C0592t0.class) {
            z = C0592t0.f;
        }
        if (z) {
            return new so(this, true, "");
        }
        return new so(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final so a() {
        return a((Void) null);
    }
}
