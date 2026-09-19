package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0261g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f991a;
    public final /* synthetic */ C0649v1 b;

    public RunnableC0261g1(C0649v1 c0649v1, String str) {
        this.b = c0649v1;
        this.f991a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.b).b(this.f991a);
    }
}
