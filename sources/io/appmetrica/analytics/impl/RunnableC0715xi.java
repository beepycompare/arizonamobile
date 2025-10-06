package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0715xi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f1158a;

    public RunnableC0715xi(Ci ci) {
        this.f1158a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f1158a;
        Ci.a(ci.f393a, ci.d, ci.e).sendEventsBuffer();
    }
}
