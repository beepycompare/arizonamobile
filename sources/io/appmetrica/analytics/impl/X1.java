package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0660ve f734a;
    public final /* synthetic */ Y7 b;

    public X1(Z1 z1, Y7 y7) {
        this.f734a = z1;
        this.b = y7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f734a.consume(this.b);
    }
}
