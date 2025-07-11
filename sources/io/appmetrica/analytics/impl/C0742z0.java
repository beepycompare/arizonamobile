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
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0742z0 implements Va {
    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void b(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void b(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final InterfaceC0379kb c(ReporterConfig reporterConfig) {
        return new C0585si();
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final C0528qa d() {
        return new C0528qa();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final Cc i() {
        Qc qc = new Qc();
        return new Cc(qc, new R7(qc));
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.Va, io.appmetrica.analytics.impl.InterfaceC0429mb
    public final InterfaceC0404lb a() {
        return new C0660vi();
    }
}
