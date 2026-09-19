package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0571s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1192a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0649v1 c;

    public RunnableC0571s1(C0649v1 c0649v1, String str, Throwable th) {
        this.c = c0649v1;
        this.f1192a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.c).reportError(this.f1192a, this.b);
    }
}
