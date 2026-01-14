package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0308hl implements so {

    /* renamed from: a  reason: collision with root package name */
    public final C0738z0 f1033a;

    public C0308hl(C0738z0 c0738z0) {
        this.f1033a = c0738z0;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Void r3) {
        this.f1033a.getClass();
        if (C0738z0.a()) {
            return new qo(this, true, "");
        }
        return new qo(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final qo a() {
        return a((Void) null);
    }
}
