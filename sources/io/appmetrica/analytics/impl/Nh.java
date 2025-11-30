package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Nh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f608a;
    public final /* synthetic */ C0301hi b;

    public Nh(C0301hi c0301hi, String str) {
        this.b = c0301hi;
        this.f608a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).setUserProfileID(this.f608a);
    }
}
