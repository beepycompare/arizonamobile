package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0579sj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1122a;

    public C0579sj(Throwable th) {
        this.f1122a = th;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportUnhandledException(this.f1122a);
    }
}
