package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0230ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f843a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0230ei(C0735yi c0735yi, String str) {
        this.b = c0735yi;
        this.f843a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).setUserProfileID(this.f843a);
    }
}
