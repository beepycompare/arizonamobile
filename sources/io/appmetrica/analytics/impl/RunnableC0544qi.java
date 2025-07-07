package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0544qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1007a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0568ri c;

    public RunnableC0544qi(C0568ri c0568ri, String str, String str2) {
        this.c = c0568ri;
        this.f1007a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportEvent(this.f1007a, this.b);
    }
}
