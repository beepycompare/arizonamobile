package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561s1 f714a;

    public U0(C0561s1 c0561s1) {
        this.f714a = c0561s1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.f714a).sendEventsBuffer();
    }
}
