package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0155c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f822a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0561s1 c;

    public RunnableC0155c1(C0561s1 c0561s1, String str, String str2) {
        this.c = c0561s1;
        this.f822a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.c).b(this.f822a, this.b);
    }
}
