package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0387l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f984a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0387l1(C0611u1 c0611u1, ExternalAttribution externalAttribution) {
        this.b = c0611u1;
        this.f984a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).a(this.f984a);
    }
}
