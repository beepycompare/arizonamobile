package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0469ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f958a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0568ri c;

    public RunnableC0469ni(C0568ri c0568ri, String str, String str2) {
        this.c = c0568ri;
        this.f958a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).putAppEnvironmentValue(this.f958a, this.b);
    }
}
