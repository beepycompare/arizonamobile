package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0495p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1142a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0495p1(C0650v1 c0650v1, String str) {
        this.b = c0650v1;
        this.f1142a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportEvent(this.f1142a);
    }
}
