package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0369k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f899a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0494p1 c;

    public RunnableC0369k1(C0494p1 c0494p1, String str, String str2) {
        this.c = c0494p1;
        this.f899a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.c).reportEvent(this.f899a, this.b);
    }
}
