package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0486p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1156a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0486p1(C0610u1 c0610u1, String str, String str2) {
        this.c = c0610u1;
        this.f1156a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.c).reportEvent(this.f1156a, this.b);
    }
}
