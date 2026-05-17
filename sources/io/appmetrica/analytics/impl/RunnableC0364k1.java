package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0364k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1077a;
    public final /* synthetic */ C0588t1 b;

    public RunnableC0364k1(C0588t1 c0588t1, ExternalAttribution externalAttribution) {
        this.b = c0588t1;
        this.f1077a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).a(this.f1077a);
    }
}
