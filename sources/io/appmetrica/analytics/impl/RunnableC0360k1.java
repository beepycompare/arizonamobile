package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0360k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1063a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0360k1(C0610u1 c0610u1, AnrListener anrListener) {
        this.b = c0610u1;
        this.f1063a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).a(this.f1063a);
    }
}
