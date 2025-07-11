package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0245f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f829a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0245f1(C0494p1 c0494p1, AnrListener anrListener) {
        this.b = c0494p1;
        this.f829a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).a(this.f829a);
    }
}
