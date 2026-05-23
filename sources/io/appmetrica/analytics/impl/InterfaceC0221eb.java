package io.appmetrica.analytics.impl;

import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.eb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0221eb extends InterfaceC0327id, S6, InterfaceC0557rb {
    /* synthetic */ InterfaceC0532qb a();

    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void a(Location location);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void a(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void a(boolean z, boolean z2);

    void b(AppMetricaConfig appMetricaConfig);

    InterfaceC0506pb c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void clearAppEnvironment();

    C0582sa d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    Lc i();

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    /* synthetic */ void setUserProfileID(String str);
}
