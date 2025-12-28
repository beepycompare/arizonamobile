package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.il  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328il implements to {

    /* renamed from: a  reason: collision with root package name */
    public final C0734z0 f1042a;

    public C0328il(C0734z0 c0734z0) {
        this.f1042a = c0734z0;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Void r3) {
        this.f1042a.getClass();
        if (C0734z0.a()) {
            return new ro(this, true, "");
        }
        return new ro(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final ro a() {
        return a((Void) null);
    }
}
