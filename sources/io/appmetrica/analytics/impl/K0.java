package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class K0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f529a;
    public final /* synthetic */ C0548r1 b;

    public K0(C0548r1 c0548r1, String str) {
        this.b = c0548r1;
        this.f529a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f529a, false);
    }
}
