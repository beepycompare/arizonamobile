package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0407ll implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final C0685x0 f994a;

    public C0407ll(C0685x0 c0685x0) {
        this.f994a = c0685x0;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Void r3) {
        this.f994a.getClass();
        if (C0685x0.a()) {
            return new so(this, true, "");
        }
        return new so(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final so a() {
        return a((Void) null);
    }
}
