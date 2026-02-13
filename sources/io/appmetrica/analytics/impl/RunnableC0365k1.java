package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0365k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1072a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0365k1(C0589t1 c0589t1, ExternalAttribution externalAttribution) {
        this.b = c0589t1;
        this.f1072a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).a(this.f1072a);
    }
}
