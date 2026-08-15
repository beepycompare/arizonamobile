package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0417m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1090a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0417m1(C0650v1 c0650v1, ExternalAttribution externalAttribution) {
        this.b = c0650v1;
        this.f1090a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).a(this.f1090a);
    }
}
