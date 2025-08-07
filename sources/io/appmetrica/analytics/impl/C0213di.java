package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0213di implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0620u0 f817a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0213di(C0620u0 c0620u0, Context context, ReporterConfig reporterConfig) {
        this.f817a = c0620u0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0620u0 c0620u0 = this.f817a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0620u0.getClass();
        return C0595t0.a(context).f().c(reporterConfig);
    }
}
