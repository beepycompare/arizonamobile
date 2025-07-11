package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0421m3 implements ApplicationStateObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0446n3 f933a;

    public C0421m3(C0446n3 c0446n3) {
        this.f933a = c0446n3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
    public final void onApplicationStateChanged(ApplicationState applicationState) {
        C0446n3 c0446n3 = this.f933a;
        c0446n3.getClass();
        if (applicationState == ApplicationState.VISIBLE) {
            try {
                BillingMonitor billingMonitor = c0446n3.f951a;
                if (billingMonitor != null) {
                    billingMonitor.onSessionResumed();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
