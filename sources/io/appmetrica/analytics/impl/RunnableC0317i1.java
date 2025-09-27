package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0317i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f916a;
    public final /* synthetic */ C0547r1 b;

    public RunnableC0317i1(C0547r1 c0547r1, ExternalAttribution externalAttribution) {
        this.b = c0547r1;
        this.f916a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).a(this.f916a);
    }
}
