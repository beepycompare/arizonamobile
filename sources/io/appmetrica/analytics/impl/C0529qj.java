package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0529qj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1188a;
    public final /* synthetic */ Throwable b;

    public C0529qj(String str, Throwable th) {
        this.f1188a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportError(this.f1188a, this.b);
    }
}
