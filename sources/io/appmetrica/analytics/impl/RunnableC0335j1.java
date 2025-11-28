package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0335j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f943a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0335j1(C0561s1 c0561s1, ExternalAttribution externalAttribution) {
        this.b = c0561s1;
        this.f943a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).a(this.f943a);
    }
}
