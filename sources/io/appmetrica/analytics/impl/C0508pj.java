package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0508pj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1179a;
    public final /* synthetic */ Throwable b;

    public C0508pj(String str, Throwable th) {
        this.f1179a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportError(this.f1179a, this.b);
    }
}
