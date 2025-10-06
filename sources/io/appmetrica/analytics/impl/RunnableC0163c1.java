package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0163c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f818a;
    public final /* synthetic */ C0548r1 b;

    public RunnableC0163c1(C0548r1 c0548r1, String str) {
        this.b = c0548r1;
        this.f818a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).b(this.f818a);
    }
}
