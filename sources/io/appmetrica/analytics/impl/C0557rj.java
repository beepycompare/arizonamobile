package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0557rj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1210a;

    public C0557rj(Throwable th) {
        this.f1210a = th;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportUnhandledException(this.f1210a);
    }
}
