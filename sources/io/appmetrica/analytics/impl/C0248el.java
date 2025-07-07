package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0248el implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final C0625u0 f824a;

    public C0248el(C0625u0 c0625u0) {
        this.f824a = c0625u0;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Void r3) {
        boolean z;
        this.f824a.getClass();
        synchronized (C0600t0.class) {
            z = C0600t0.f;
        }
        if (z) {
            return new ko(this, true, "");
        }
        return new ko(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final ko a() {
        return a((Void) null);
    }
}
