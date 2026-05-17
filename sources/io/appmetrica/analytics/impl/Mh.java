package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f701a;
    public final /* synthetic */ C0278gi b;

    public Mh(C0278gi c0278gi, String str) {
        this.b = c0278gi;
        this.f701a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).setUserProfileID(this.f701a);
    }
}
