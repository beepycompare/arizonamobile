package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0198di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f853a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0301hi c;

    public RunnableC0198di(C0301hi c0301hi, String str, String str2) {
        this.c = c0301hi;
        this.f853a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.c;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).putAppEnvironmentValue(this.f853a, this.b);
    }
}
