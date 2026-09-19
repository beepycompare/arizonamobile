package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0235f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f974a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0649v1 c;

    public RunnableC0235f1(C0649v1 c0649v1, String str, String str2) {
        this.c = c0649v1;
        this.f974a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.c).b(this.f974a, this.b);
    }
}
