package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0154c2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Be f922a;
    public final /* synthetic */ Q7 b;

    public RunnableC0154c2(C0205e2 c0205e2, Q7 q7) {
        this.f922a = c0205e2;
        this.b = q7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f922a.consume(this.b);
    }
}
