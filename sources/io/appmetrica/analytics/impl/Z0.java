package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f729a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0494p1 c;

    public Z0(C0494p1 c0494p1, String str, String str2) {
        this.c = c0494p1;
        this.f729a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.c).b(this.f729a, this.b);
    }
}
