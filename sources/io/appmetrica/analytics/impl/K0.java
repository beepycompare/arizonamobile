package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class K0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f522a;
    public final /* synthetic */ C0494p1 b;

    public K0(C0494p1 c0494p1, String str) {
        this.b = c0494p1;
        this.f522a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).b(this.f522a);
    }
}
