package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0420m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f984a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0547r1 c;

    public RunnableC0420m1(C0547r1 c0547r1, String str, String str2) {
        this.c = c0547r1;
        this.f984a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.c).reportEvent(this.f984a, this.b);
    }
}
