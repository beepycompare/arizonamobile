package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0486oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1001a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0735yi c;

    public RunnableC0486oi(C0735yi c0735yi, String str, byte[] bArr) {
        this.c = c0735yi;
        this.f1001a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.c;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).setSessionExtra(this.f1001a, this.b);
    }
}
