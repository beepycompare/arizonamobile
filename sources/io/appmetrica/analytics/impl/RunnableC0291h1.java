package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0291h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f904a;
    public final /* synthetic */ C0547r1 b;

    public RunnableC0291h1(C0547r1 c0547r1, AnrListener anrListener) {
        this.b = c0547r1;
        this.f904a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).a(this.f904a);
    }
}
