package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
/* loaded from: classes4.dex */
public final class i implements PurchaseHistoryResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final BillingConfig f231a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final String d;
    public final d e;
    public final n f;

    public i(BillingConfig billingConfig, BillingClient billingClient, UtilsProvider utilsProvider, String str, d dVar, n nVar) {
        this.f231a = billingConfig;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = str;
        this.e = dVar;
        this.f = nVar;
    }

    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        this.c.getWorkerExecutor().execute(new g(this, billingResult, list));
    }
}
