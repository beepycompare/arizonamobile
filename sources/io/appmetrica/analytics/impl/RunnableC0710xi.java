package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0710xi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1143a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0735yi c;

    public RunnableC0710xi(C0735yi c0735yi, String str, String str2) {
        this.c = c0735yi;
        this.f1143a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.c;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportEvent(this.f1143a, this.b);
    }
}
