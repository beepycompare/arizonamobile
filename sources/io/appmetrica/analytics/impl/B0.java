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
public final class B0 implements InterfaceC0173cb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.Z6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void b(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void b(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final InterfaceC0558rb c(ReporterConfig reporterConfig) {
        return new Di();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final C0707xa d() {
        return new C0707xa();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final Jc i() {
        Xc xc = new Xc();
        return new Jc(xc, new Y7(xc));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0173cb, io.appmetrica.analytics.impl.InterfaceC0608tb
    public final InterfaceC0583sb a() {
        return new Gi();
    }
}
