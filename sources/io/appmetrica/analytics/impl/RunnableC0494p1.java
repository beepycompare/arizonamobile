package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0494p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1142a;
    public final /* synthetic */ C0649v1 b;

    public RunnableC0494p1(C0649v1 c0649v1, String str) {
        this.b = c0649v1;
        this.f1142a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.b).reportEvent(this.f1142a);
    }
}
