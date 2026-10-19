package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0385l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1078a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0385l1(C0644v1 c0644v1, AnrListener anrListener) {
        this.b = c0644v1;
        this.f1078a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).a(this.f1078a);
    }
}
