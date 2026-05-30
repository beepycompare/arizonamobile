package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryPurchasesParams;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class a extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f303a;
    public final /* synthetic */ BillingResult b;

    public a(b bVar, BillingResult billingResult) {
        this.f303a = bVar;
        this.b = billingResult;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        b bVar = this.f303a;
        BillingResult billingResult = this.b;
        bVar.getClass();
        if (billingResult.getResponseCode() != 0) {
            bVar.e.onUpdateFinished();
        } else if (!bVar.b.isReady()) {
            bVar.e.onUpdateFinished();
        } else {
            for (String str : CollectionsKt.listOf((Object[]) new String[]{"inapp", "subs"})) {
                BillingConfig billingConfig = bVar.f304a;
                BillingClient billingClient = bVar.b;
                UtilsProvider utilsProvider = bVar.c;
                d dVar = bVar.d;
                i iVar = new i(billingConfig, billingClient, utilsProvider, str, dVar, bVar.e);
                dVar.b.add(iVar);
                bVar.b.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(str).build(), iVar);
            }
        }
    }
}
