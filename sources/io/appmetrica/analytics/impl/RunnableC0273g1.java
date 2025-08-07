package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0273g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f856a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0273g1(C0497p1 c0497p1, ExternalAttribution externalAttribution) {
        this.b = c0497p1;
        this.f856a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).a(this.f856a);
    }
}
