package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f467a;
    public final /* synthetic */ C0494p1 b;

    public I0(C0494p1 c0494p1, String str) {
        this.b = c0494p1;
        this.f467a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f467a, false);
    }
}
