package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0589si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1083a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ Ci c;

    public RunnableC0589si(Ci ci, String str, byte[] bArr) {
        this.c = ci;
        this.f1083a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f392a, ci.d, ci.e).setSessionExtra(this.f1083a, this.b);
    }
}
