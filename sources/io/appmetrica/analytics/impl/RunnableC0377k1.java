package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0377k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f898a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0502p1 c;

    public RunnableC0377k1(C0502p1 c0502p1, String str, String str2) {
        this.c = c0502p1;
        this.f898a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.c).reportEvent(this.f898a, this.b);
    }
}
