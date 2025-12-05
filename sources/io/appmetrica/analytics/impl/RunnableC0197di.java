package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0197di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f936a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0300hi c;

    public RunnableC0197di(C0300hi c0300hi, String str, String str2) {
        this.c = c0300hi;
        this.f936a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).putAppEnvironmentValue(this.f936a, this.b);
    }
}
