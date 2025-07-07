package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0320hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f867a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0568ri c;

    public RunnableC0320hi(C0568ri c0568ri, String str, byte[] bArr) {
        this.c = c0568ri;
        this.f867a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).setSessionExtra(this.f867a, this.b);
    }
}
