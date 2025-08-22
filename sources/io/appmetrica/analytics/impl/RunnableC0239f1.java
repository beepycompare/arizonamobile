package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0239f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f849a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0239f1(C0494p1 c0494p1, AnrListener anrListener) {
        this.b = c0494p1;
        this.f849a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).a(this.f849a);
    }
}
