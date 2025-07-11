package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0536qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1008a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0560ri c;

    public RunnableC0536qi(C0560ri c0560ri, String str, String str2) {
        this.c = c0560ri;
        this.f1008a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportEvent(this.f1008a, this.b);
    }
}
