package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class Rh implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0734z0 f760a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public Rh(C0734z0 c0734z0, Context context, ReporterConfig reporterConfig) {
        this.f760a = c0734z0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0734z0 c0734z0 = this.f760a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0734z0.getClass();
        return C0709y0.a(context).f().c(reporterConfig);
    }
}
