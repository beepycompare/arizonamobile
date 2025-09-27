package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0333ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f925a;
    public final /* synthetic */ Ci b;

    public RunnableC0333ii(Ci ci, String str) {
        this.b = ci;
        this.f925a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).setUserProfileID(this.f925a);
    }
}
