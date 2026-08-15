package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382ki implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B0 f1069a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public C0382ki(B0 b0, Context context, ReporterConfig reporterConfig) {
        this.f1069a = b0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        B0 b0 = this.f1069a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        b0.getClass();
        return A0.a(context).f().c(reporterConfig);
    }
}
