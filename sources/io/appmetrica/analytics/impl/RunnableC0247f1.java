package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0247f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f838a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0247f1(C0497p1 c0497p1, AnrListener anrListener) {
        this.b = c0497p1;
        this.f838a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).a(this.f838a);
    }
}
