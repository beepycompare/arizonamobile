package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f728a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0502p1 c;

    public Z0(C0502p1 c0502p1, String str, String str2) {
        this.c = c0502p1;
        this.f728a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.c).b(this.f728a, this.b);
    }
}
