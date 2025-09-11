package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0136b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f801a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0547r1 c;

    public RunnableC0136b1(C0547r1 c0547r1, String str, String str2) {
        this.c = c0547r1;
        this.f801a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.c).b(this.f801a, this.b);
    }
}
