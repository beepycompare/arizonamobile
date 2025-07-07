package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0427m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f930a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0502p1 c;

    public RunnableC0427m1(C0502p1 c0502p1, String str, Throwable th) {
        this.c = c0502p1;
        this.f930a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.c).reportError(this.f930a, this.b);
    }
}
