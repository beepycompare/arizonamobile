package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0464o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1150a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0588t1 c;

    public RunnableC0464o1(C0588t1 c0588t1, String str, String str2) {
        this.c = c0588t1;
        this.f1150a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.c).reportEvent(this.f1150a, this.b);
    }
}
