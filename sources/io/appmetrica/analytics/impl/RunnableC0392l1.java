package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0392l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1073a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0392l1(C0651v1 c0651v1, AnrListener anrListener) {
        this.b = c0651v1;
        this.f1073a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).a(this.f1073a);
    }
}
