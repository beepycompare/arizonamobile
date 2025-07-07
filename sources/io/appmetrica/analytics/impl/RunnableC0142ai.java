package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0142ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f755a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0142ai(C0568ri c0568ri, AdRevenue adRevenue) {
        this.b = c0568ri;
        this.f755a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportAdRevenue(this.f755a);
    }
}
