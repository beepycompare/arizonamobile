package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0714xj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1139a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final Aj d;

    public C0714xj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, Aj aj) {
        this.f1139a = str;
        this.b = context;
        int i = AbstractC0689wj.f1124a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = aj;
    }
}
