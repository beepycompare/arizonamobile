package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0554rj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1104a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public C0554rj(String str, String str2, Throwable th) {
        this.f1104a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportError(this.f1104a, this.b, this.c);
    }
}
