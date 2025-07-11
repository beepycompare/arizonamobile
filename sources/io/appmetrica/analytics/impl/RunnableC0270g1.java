package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0270g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f848a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0270g1(C0494p1 c0494p1, ExternalAttribution externalAttribution) {
        this.b = c0494p1;
        this.f848a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).a(this.f848a);
    }
}
