package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0404lj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1093a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0479oj d;

    public C0404lj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0479oj c0479oj) {
        this.f1093a = str;
        this.b = context;
        int i = AbstractC0378kj.f1078a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0479oj;
    }
}
