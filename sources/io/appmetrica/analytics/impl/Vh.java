package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class Vh implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0685x0 f734a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public Vh(C0685x0 c0685x0, Context context, ReporterConfig reporterConfig) {
        this.f734a = c0685x0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C0685x0 c0685x0 = this.f734a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c0685x0.getClass();
        return C0660w0.a(context).f().c(reporterConfig);
    }
}
