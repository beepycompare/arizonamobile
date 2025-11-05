package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Rh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f668a;
    public final /* synthetic */ C0404li b;

    public Rh(C0404li c0404li, String str) {
        this.b = c0404li;
        this.f668a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).setUserProfileID(this.f668a);
    }
}
