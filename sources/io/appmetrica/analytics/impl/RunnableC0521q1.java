package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0521q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1158a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0650v1 c;

    public RunnableC0521q1(C0650v1 c0650v1, String str, String str2) {
        this.c = c0650v1;
        this.f1158a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.c).reportEvent(this.f1158a, this.b);
    }
}
