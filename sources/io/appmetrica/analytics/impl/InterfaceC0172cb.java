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
/* renamed from: io.appmetrica.analytics.impl.cb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0172cb extends InterfaceC0303hd, Z6, InterfaceC0607tb {
    /* synthetic */ InterfaceC0582sb a();

    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void a(Location location);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void a(boolean z);

    void b(AppMetricaConfig appMetricaConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void b(boolean z);

    InterfaceC0557rb c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void clearAppEnvironment();

    C0706xa d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    Jc i();

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hd
    /* synthetic */ void setUserProfileID(String str);
}
