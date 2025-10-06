package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
/* renamed from: io.appmetrica.analytics.impl.p3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0501p3 implements ApplicationStateObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0526q3 f1031a;

    public C0501p3(C0526q3 c0526q3) {
        this.f1031a = c0526q3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
    public final void onApplicationStateChanged(ApplicationState applicationState) {
        C0526q3 c0526q3 = this.f1031a;
        c0526q3.getClass();
        if (applicationState == ApplicationState.VISIBLE) {
            try {
                BillingMonitor billingMonitor = c0526q3.f1045a;
                if (billingMonitor != null) {
                    billingMonitor.onSessionResumed();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
