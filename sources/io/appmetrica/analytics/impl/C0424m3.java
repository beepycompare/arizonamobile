package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0424m3 implements ApplicationStateObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0449n3 f948a;

    public C0424m3(C0449n3 c0449n3) {
        this.f948a = c0449n3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
    public final void onApplicationStateChanged(ApplicationState applicationState) {
        C0449n3 c0449n3 = this.f948a;
        c0449n3.getClass();
        if (applicationState == ApplicationState.VISIBLE) {
            try {
                BillingMonitor billingMonitor = c0449n3.f963a;
                if (billingMonitor != null) {
                    billingMonitor.onSessionResumed();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
