package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0679wj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1190a;

    public C0679wj(Throwable th) {
        this.f1190a = th;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportUnhandledException(this.f1190a);
    }
}
