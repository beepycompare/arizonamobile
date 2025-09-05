package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0660ve f730a;
    public final /* synthetic */ Y7 b;

    public X1(Z1 z1, Y7 y7) {
        this.f730a = z1;
        this.b = y7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f730a.consume(this.b);
    }
}
