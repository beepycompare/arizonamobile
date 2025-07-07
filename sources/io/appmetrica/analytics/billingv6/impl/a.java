package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.google.android.billing.IabHelper;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class a extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f223a;
    public final /* synthetic */ BillingResult b;

    public a(b bVar, BillingResult billingResult) {
        this.f223a = bVar;
        this.b = billingResult;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        b bVar = this.f223a;
        BillingResult billingResult = this.b;
        bVar.getClass();
        if (billingResult.getResponseCode() != 0) {
            bVar.e.onUpdateFinished();
            return;
        }
        for (String str : CollectionsKt.listOf((Object[]) new String[]{IabHelper.ITEM_TYPE_INAPP, IabHelper.ITEM_TYPE_SUBS})) {
            BillingConfig billingConfig = bVar.f224a;
            BillingClient billingClient = bVar.b;
            UtilsProvider utilsProvider = bVar.c;
            d dVar = bVar.d;
            i iVar = new i(billingConfig, billingClient, utilsProvider, str, dVar, bVar.e);
            dVar.b.add(iVar);
            if (bVar.b.isReady()) {
                bVar.b.queryPurchaseHistoryAsync(QueryPurchaseHistoryParams.newBuilder().setProductType(str).build(), iVar);
            } else {
                bVar.d.a(iVar);
                bVar.e.onUpdateFinished();
            }
        }
    }
}
