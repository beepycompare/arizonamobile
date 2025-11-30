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
public interface Da extends Ic, B6, Ua {
    /* synthetic */ Ta a();

    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(Location location);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(boolean z);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void a(boolean z, boolean z2);

    void b(AppMetricaConfig appMetricaConfig);

    Sa c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void clearAppEnvironment();

    Y9 d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    C0372kc i();

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.Ic
    /* synthetic */ void setUserProfileID(String str);
}
