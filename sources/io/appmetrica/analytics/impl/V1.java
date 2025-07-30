package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class V1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0509pe f680a;
    public final /* synthetic */ U7 b;

    public V1(X1 x1, U7 u7) {
        this.f680a = x1;
        this.b = u7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f680a.consume(this.b);
    }
}
