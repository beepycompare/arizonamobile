package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ml implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f671a;

    public Ml(B0 b0) {
        this.f671a = b0;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Void r3) {
        this.f671a.getClass();
        if (B0.a()) {
            return new To(this, true, "");
        }
        return new To(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final To a() {
        return a((Void) null);
    }
}
