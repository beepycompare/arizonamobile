package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0371k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f920a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0496p1 c;

    public RunnableC0371k1(C0496p1 c0496p1, String str, String str2) {
        this.c = c0496p1;
        this.f920a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.c).reportEvent(this.f920a, this.b);
    }
}
