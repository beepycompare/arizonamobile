package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
/* loaded from: classes5.dex */
public final class i implements PurchasesResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final BillingConfig f310a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final String d;
    public final d e;
    public final n f;

    public i(BillingConfig billingConfig, BillingClient billingClient, UtilsProvider utilsProvider, String str, d dVar, n nVar) {
        this.f310a = billingConfig;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = str;
        this.e = dVar;
        this.f = nVar;
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        this.c.getWorkerExecutor().execute(new g(this, billingResult, list));
    }
}
