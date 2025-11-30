package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0361k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f966a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0361k1(C0611u1 c0611u1, AnrListener anrListener) {
        this.b = c0611u1;
        this.f966a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).a(this.f966a);
    }
}
