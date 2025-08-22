package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0127ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f781a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0735yi d;

    public RunnableC0127ai(C0735yi c0735yi, String str, String str2, Throwable th) {
        this.d = c0735yi;
        this.f781a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.d;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportError(this.f781a, this.b, this.c);
    }
}
