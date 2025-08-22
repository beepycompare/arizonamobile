package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class V1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0556re f687a;
    public final /* synthetic */ V7 b;

    public V1(X1 x1, V7 v7) {
        this.f687a = x1;
        this.b = v7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f687a.consume(this.b);
    }
}
