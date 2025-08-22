package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f760a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0735yi c;

    public Zh(C0735yi c0735yi, String str, Throwable th) {
        this.c = c0735yi;
        this.f760a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.c;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportError(this.f760a, this.b);
    }
}
