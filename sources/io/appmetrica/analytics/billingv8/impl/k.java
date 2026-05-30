package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public final class k implements PurchasesResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final UtilsProvider f313a;
    public final Function0 b;
    public final List c;
    public final List d;
    public final d e;
    public final n f;

    public k(UtilsProvider utilsProvider, Function0 function0, List list, List list2, d dVar, n nVar) {
        this.f313a = utilsProvider;
        this.b = function0;
        this.c = list;
        this.d = list2;
        this.e = dVar;
        this.f = nVar;
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        this.f313a.getWorkerExecutor().execute(new j(this, billingResult, list));
    }
}
