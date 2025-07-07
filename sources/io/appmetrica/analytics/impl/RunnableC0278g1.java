package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0278g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f847a;
    public final /* synthetic */ C0502p1 b;

    public RunnableC0278g1(C0502p1 c0502p1, ExternalAttribution externalAttribution) {
        this.b = c0502p1;
        this.f847a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).a(this.f847a);
    }
}
