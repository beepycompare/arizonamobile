package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0416m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1090a;
    public final /* synthetic */ C0649v1 b;

    public RunnableC0416m1(C0649v1 c0649v1, ExternalAttribution externalAttribution) {
        this.b = c0649v1;
        this.f1090a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.b).a(this.f1090a);
    }
}
