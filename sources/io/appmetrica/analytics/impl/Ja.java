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
/* loaded from: classes5.dex */
public interface Ja extends Oc, H6, InterfaceC0113ab {
    /* synthetic */ Za a();

    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void a(Location location);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void a(boolean z);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void a(boolean z, boolean z2);

    void b(AppMetricaConfig appMetricaConfig);

    Ya c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void clearAppEnvironment();

    C0215ea d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    C0523qc i();

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.Oc
    /* synthetic */ void setUserProfileID(String str);
}
