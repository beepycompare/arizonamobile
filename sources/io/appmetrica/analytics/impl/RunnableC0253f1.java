package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0253f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f828a;
    public final /* synthetic */ C0502p1 b;

    public RunnableC0253f1(C0502p1 c0502p1, AnrListener anrListener) {
        this.b = c0502p1;
        this.f828a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).a(this.f828a);
    }
}
