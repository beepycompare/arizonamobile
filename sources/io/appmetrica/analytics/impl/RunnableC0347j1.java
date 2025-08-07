package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0347j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f909a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0347j1(C0497p1 c0497p1, String str) {
        this.b = c0497p1;
        this.f909a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).reportEvent(this.f909a);
    }
}
