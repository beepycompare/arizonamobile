package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0578sj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1220a;

    public C0578sj(Throwable th) {
        this.f1220a = th;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportUnhandledException(this.f1220a);
    }
}
