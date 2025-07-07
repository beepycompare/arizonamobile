package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0352j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f884a;
    public final /* synthetic */ C0502p1 b;

    public RunnableC0352j1(C0502p1 c0502p1, String str) {
        this.b = c0502p1;
        this.f884a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportEvent(this.f884a);
    }
}
