package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0543ql implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final C0671w0 f1055a;

    public C0543ql(C0671w0 c0671w0) {
        this.f1055a = c0671w0;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Void r3) {
        boolean z;
        this.f1055a.getClass();
        synchronized (C0646v0.class) {
            z = C0646v0.f;
        }
        if (z) {
            return new wo(this, true, "");
        }
        return new wo(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final wo a() {
        return a((Void) null);
    }
}
