package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class K0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f498a;
    public final /* synthetic */ C0502p1 b;

    public K0(C0502p1 c0502p1, String str) {
        this.b = c0502p1;
        this.f498a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).b(this.f498a);
    }
}
