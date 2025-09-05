package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0394l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f957a;
    public final /* synthetic */ C0547r1 b;

    public RunnableC0394l1(C0547r1 c0547r1, String str) {
        this.b = c0547r1;
        this.f957a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportEvent(this.f957a);
    }
}
