package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0519pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f992a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0519pi(C0568ri c0568ri, String str) {
        this.b = c0568ri;
        this.f992a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportEvent(this.f992a);
    }
}
