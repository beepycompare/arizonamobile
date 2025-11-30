package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0146bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f819a;
    public final /* synthetic */ C0301hi b;

    public RunnableC0146bi(C0301hi c0301hi, V v) {
        this.b = c0301hi;
        this.f819a = v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).a(this.f819a);
    }
}
