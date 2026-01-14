package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0533qj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1192a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public C0533qj(String str, String str2, Throwable th) {
        this.f1192a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportError(this.f1192a, this.b, this.c);
    }
}
