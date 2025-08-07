package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class V1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0510pe f679a;
    public final /* synthetic */ U7 b;

    public V1(X1 x1, U7 u7) {
        this.f679a = x1;
        this.b = u7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f679a.consume(this.b);
    }
}
