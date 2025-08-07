package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0422m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f946a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0497p1 c;

    public RunnableC0422m1(C0497p1 c0497p1, String str, Throwable th) {
        this.c = c0497p1;
        this.f946a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.c).reportError(this.f946a, this.b);
    }
}
