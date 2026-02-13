package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class Qh implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0738z0 f752a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public Qh(C0738z0 c0738z0, Context context, ReporterConfig reporterConfig) {
        this.f752a = c0738z0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0738z0 c0738z0 = this.f752a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0738z0.getClass();
        return C0713y0.a(context).f().c(reporterConfig);
    }
}
