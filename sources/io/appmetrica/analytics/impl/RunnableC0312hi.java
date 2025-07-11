package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0312hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f868a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0560ri c;

    public RunnableC0312hi(C0560ri c0560ri, String str, byte[] bArr) {
        this.c = c0560ri;
        this.f868a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).setSessionExtra(this.f868a, this.b);
    }
}
