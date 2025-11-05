package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0181d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f837a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0181d1(C0561s1 c0561s1, String str) {
        this.b = c0561s1;
        this.f837a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).b(this.f837a);
    }
}
