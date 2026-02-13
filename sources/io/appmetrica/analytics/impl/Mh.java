package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f696a;
    public final /* synthetic */ C0279gi b;

    public Mh(C0279gi c0279gi, String str) {
        this.b = c0279gi;
        this.f696a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).setUserProfileID(this.f696a);
    }
}
