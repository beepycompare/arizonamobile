package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0227ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f980a;
    public final /* synthetic */ C0279gi b;

    public RunnableC0227ei(C0279gi c0279gi, String str) {
        this.b = c0279gi;
        this.f980a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportEvent(this.f980a);
    }
}
