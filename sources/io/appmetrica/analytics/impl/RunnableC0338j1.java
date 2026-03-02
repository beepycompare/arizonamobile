package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0338j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1053a;
    public final /* synthetic */ C0588t1 b;

    public RunnableC0338j1(C0588t1 c0588t1, AnrListener anrListener) {
        this.b = c0588t1;
        this.f1053a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).a(this.f1053a);
    }
}
