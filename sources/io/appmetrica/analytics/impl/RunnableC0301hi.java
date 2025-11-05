package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0301hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f913a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0404li c;

    public RunnableC0301hi(C0404li c0404li, String str, String str2) {
        this.c = c0404li;
        this.f913a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).putAppEnvironmentValue(this.f913a, this.b);
    }
}
