package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.il  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329il implements to {

    /* renamed from: a  reason: collision with root package name */
    public final C0735z0 f944a;

    public C0329il(C0735z0 c0735z0) {
        this.f944a = c0735z0;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Void r3) {
        this.f944a.getClass();
        if (C0735z0.a()) {
            return new ro(this, true, "");
        }
        return new ro(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final ro a() {
        return a((Void) null);
    }
}
