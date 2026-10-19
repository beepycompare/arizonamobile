package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0411m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1093a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0411m1(C0644v1 c0644v1, ExternalAttribution externalAttribution) {
        this.b = c0644v1;
        this.f1093a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).a(this.f1093a);
    }
}
