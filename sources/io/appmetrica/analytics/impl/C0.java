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
/* loaded from: classes3.dex */
public final class C0 implements Ja {
    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.H6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void a(boolean z, boolean z2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void b(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Ya c(ReporterConfig reporterConfig) {
        return new C0429mi();
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C0215ea d() {
        return new C0215ea();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C0523qc i() {
        Ec ec = new Ec();
        return new C0523qc(ec, new G7(ec));
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Oc
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC0113ab
    public final Za a() {
        return new C0504pi();
    }
}
