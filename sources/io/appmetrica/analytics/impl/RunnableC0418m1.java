package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0418m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1087a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0418m1(C0651v1 c0651v1, ExternalAttribution externalAttribution) {
        this.b = c0651v1;
        this.f1087a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).a(this.f1087a);
    }
}
