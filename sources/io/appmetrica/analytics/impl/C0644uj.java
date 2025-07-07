package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.uj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0644uj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1078a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C0719xj d;

    public C0644uj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C0719xj c0719xj) {
        this.f1078a = str;
        this.b = context;
        int i = AbstractC0619tj.f1062a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c0719xj;
    }
}
