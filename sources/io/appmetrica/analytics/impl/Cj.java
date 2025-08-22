package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Cj {

    /* renamed from: a  reason: collision with root package name */
    public final String f382a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final Fj d;

    public Cj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, Fj fj) {
        this.f382a = str;
        this.b = context;
        int i = Bj.f367a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = fj;
    }
}
