package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0240el implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f825a;

    public C0240el(C0617u0 c0617u0) {
        this.f825a = c0617u0;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Void r3) {
        boolean z;
        this.f825a.getClass();
        synchronized (C0592t0.class) {
            z = C0592t0.f;
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
