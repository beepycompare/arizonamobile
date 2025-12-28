package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0205e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f959a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0205e1(C0610u1 c0610u1, String str, String str2) {
        this.c = c0610u1;
        this.f959a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.c).b(this.f959a, this.b);
    }
}
