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
public final class G0 implements InterfaceC0220eb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.S6
    public final void a(int i, Bundle bundle) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void a(boolean z, boolean z2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void b(AppMetricaConfig appMetricaConfig) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final InterfaceC0505pb c(ReporterConfig reporterConfig) {
        return new Bi();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void clearAppEnvironment() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final C0581sa d() {
        return new C0581sa();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final String e() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final Map<String, String> g() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final AdvIdentifiersResult h() {
        AdvIdentifiersResult.Details details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        return new AdvIdentifiersResult(new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"), new AdvIdentifiersResult.AdvId(null, details, "Device user is in locked state"));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final Lc i() {
        Yc yc = new Yc();
        return new Lc(yc, new Q7(yc));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void putAppEnvironmentValue(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void setDataSendingEnabled(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0326id
    public final void setUserProfileID(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        startupParamsCallback.onRequestError(StartupParamsCallback.Reason.UNKNOWN, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0220eb, io.appmetrica.analytics.impl.InterfaceC0556rb
    public final InterfaceC0531qb a() {
        return new Ei();
    }
}
