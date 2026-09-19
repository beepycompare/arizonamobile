package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0649v1 f849a;

    public Y0(C0649v1 c0649v1) {
        this.f849a = c0649v1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.f849a).sendEventsBuffer();
    }
}
