package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0246f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f839a;
    public final /* synthetic */ C0496p1 b;

    public RunnableC0246f1(C0496p1 c0496p1, AnrListener anrListener) {
        this.b = c0496p1;
        this.f839a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).a(this.f839a);
    }
}
