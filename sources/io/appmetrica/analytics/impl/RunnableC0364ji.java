package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0364ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f916a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0613ti c;

    public RunnableC0364ji(C0613ti c0613ti, String str, byte[] bArr) {
        this.c = c0613ti;
        this.f916a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).setSessionExtra(this.f916a, this.b);
    }
}
