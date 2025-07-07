package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor$updateBilling$1;
/* loaded from: classes4.dex */
public final class b implements BillingClientStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final BillingConfig f224a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final d d;
    public final n e;

    public b(BillingConfig billingConfig, BillingClient billingClient, BillingLibraryMonitor$updateBilling$1 billingLibraryMonitor$updateBilling$1, d dVar, n nVar) {
        this.f224a = billingConfig;
        this.b = billingClient;
        this.c = billingLibraryMonitor$updateBilling$1;
        this.d = dVar;
        this.e = nVar;
    }

    public final void onBillingServiceDisconnected() {
    }

    public final void onBillingSetupFinished(BillingResult billingResult) {
        this.c.getWorkerExecutor().execute(new a(this, billingResult));
    }
}
