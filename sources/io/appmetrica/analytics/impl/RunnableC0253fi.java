package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0253fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f996a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0279gi c;

    public RunnableC0253fi(C0279gi c0279gi, String str, String str2) {
        this.c = c0279gi;
        this.f996a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportEvent(this.f996a, this.b);
    }
}
