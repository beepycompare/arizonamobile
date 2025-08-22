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
/* loaded from: classes4.dex */
public interface Za extends InterfaceC0225ed, W6, InterfaceC0529qb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0529qb
    /* synthetic */ InterfaceC0504pb a();

    @Override // io.appmetrica.analytics.impl.W6
    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void a(Location location);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void a(boolean z);

    void b(AppMetricaConfig appMetricaConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void b(boolean z);

    InterfaceC0479ob c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void clearAppEnvironment();

    C0627ua d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    Gc i();

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ed
    /* synthetic */ void setUserProfileID(String str);
}
