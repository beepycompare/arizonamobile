package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Gj {

    /* renamed from: a  reason: collision with root package name */
    public final String f462a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final Jj d;

    public Gj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, Jj jj) {
        this.f462a = str;
        this.b = context;
        int i = Fj.f449a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = jj;
    }
}
