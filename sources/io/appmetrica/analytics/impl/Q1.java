package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0141be f728a;
    public final /* synthetic */ C0741z7 b;

    public Q1(S1 s1, C0741z7 c0741z7) {
        this.f728a = s1;
        this.b = c0741z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f728a.consume(this.b);
    }
}
