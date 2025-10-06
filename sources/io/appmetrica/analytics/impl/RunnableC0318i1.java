package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0318i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f916a;
    public final /* synthetic */ C0548r1 b;

    public RunnableC0318i1(C0548r1 c0548r1, ExternalAttribution externalAttribution) {
        this.b = c0548r1;
        this.f916a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).a(this.f916a);
    }
}
