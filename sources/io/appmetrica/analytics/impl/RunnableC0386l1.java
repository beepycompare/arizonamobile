package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0386l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f1082a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0386l1(C0610u1 c0610u1, ExternalAttribution externalAttribution) {
        this.b = c0610u1;
        this.f1082a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).a(this.f1082a);
    }
}
