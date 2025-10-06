package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0548r1 f678a;

    public T0(C0548r1 c0548r1) {
        this.f678a = c0548r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.f678a).sendEventsBuffer();
    }
}
