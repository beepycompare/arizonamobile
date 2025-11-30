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
public final class E0 implements Da {
    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.B6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z, boolean z2) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void b(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Sa c(ReporterConfig reporterConfig) {
        return new C0326ii();
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Y9 d() {
        return new Y9();
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final C0372kc i() {
        C0722yc c0722yc = new C0722yc();
        return new C0372kc(c0722yc, new C0742z7(c0722yc));
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ic
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Da
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.Da, io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return new C0404li();
    }
}
