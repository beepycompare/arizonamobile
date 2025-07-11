package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0344j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f885a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0344j1(C0494p1 c0494p1, String str) {
        this.b = c0494p1;
        this.f885a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportEvent(this.f885a);
    }
}
