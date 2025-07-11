package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0160bi implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0617u0 f771a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0160bi(C0617u0 c0617u0, Context context, ReporterConfig reporterConfig) {
        this.f771a = c0617u0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0617u0 c0617u0 = this.f771a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0617u0.getClass();
        return C0592t0.a(context).f().c(reporterConfig);
    }
}
