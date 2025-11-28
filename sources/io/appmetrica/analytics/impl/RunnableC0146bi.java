package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0146bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f817a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0404li c;

    public RunnableC0146bi(C0404li c0404li, String str, byte[] bArr) {
        this.c = c0404li;
        this.f817a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).setSessionExtra(this.f817a, this.b);
    }
}
