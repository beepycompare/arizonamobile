package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0363ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f917a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0612ti c;

    public RunnableC0363ji(C0612ti c0612ti, String str, byte[] bArr) {
        this.c = c0612ti;
        this.f917a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.c;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).setSessionExtra(this.f917a, this.b);
    }
}
