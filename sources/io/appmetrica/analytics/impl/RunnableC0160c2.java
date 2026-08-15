package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0160c2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Be f919a;
    public final /* synthetic */ Q7 b;

    public RunnableC0160c2(C0211e2 c0211e2, Q7 q7) {
        this.f919a = c0211e2;
        this.b = q7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f919a.consume(this.b);
    }
}
