package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0461o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1137a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0461o1(C0610u1 c0610u1, String str) {
        this.b = c0610u1;
        this.f1137a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportEvent(this.f1137a);
    }
}
