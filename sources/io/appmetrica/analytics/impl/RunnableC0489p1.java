package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0489p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1145a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0489p1(C0644v1 c0644v1, String str) {
        this.b = c0644v1;
        this.f1145a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportEvent(this.f1145a);
    }
}
