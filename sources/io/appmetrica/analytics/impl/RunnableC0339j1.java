package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0339j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1054a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0339j1(C0589t1 c0589t1, AnrListener anrListener) {
        this.b = c0589t1;
        this.f1054a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).a(this.f1054a);
    }
}
