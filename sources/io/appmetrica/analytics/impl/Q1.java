package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0142be f645a;
    public final /* synthetic */ C0742z7 b;

    public Q1(S1 s1, C0742z7 c0742z7) {
        this.f645a = s1;
        this.b = c0742z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f645a.consume(this.b);
    }
}
