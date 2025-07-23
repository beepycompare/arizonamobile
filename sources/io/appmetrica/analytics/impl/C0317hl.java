package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0317hl implements po {

    /* renamed from: a  reason: collision with root package name */
    public final C0619u0 f889a;

    public C0317hl(C0619u0 c0619u0) {
        this.f889a = c0619u0;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(Void r3) {
        boolean z;
        this.f889a.getClass();
        synchronized (C0594t0.class) {
            z = C0594t0.f;
        }
        if (z) {
            return new no(this, true, "");
        }
        return new no(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final no a() {
        return a((Void) null);
    }
}
