package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0515q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1161a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0644v1 c;

    public RunnableC0515q1(C0644v1 c0644v1, String str, String str2) {
        this.c = c0644v1;
        this.f1161a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.c).reportEvent(this.f1161a, this.b);
    }
}
