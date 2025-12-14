package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0274gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1005a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0300hi c;

    public RunnableC0274gi(C0300hi c0300hi, String str, String str2) {
        this.c = c0300hi;
        this.f1005a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportEvent(this.f1005a, this.b);
    }
}
