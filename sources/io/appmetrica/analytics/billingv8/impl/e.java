package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.QueryPurchasesParams;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.List;
import kotlin.jvm.functions.Function0;
/* loaded from: classes3.dex */
public final class e extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f341a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ QueryProductDetailsResult c;

    public e(f fVar, BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
        this.f341a = fVar;
        this.b = billingResult;
        this.c = queryProductDetailsResult;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        f fVar = this.f341a;
        BillingResult billingResult = this.b;
        List productDetailsList = this.c.getProductDetailsList();
        fVar.getClass();
        if (billingResult.getResponseCode() == 0 && !productDetailsList.isEmpty()) {
            UtilsProvider utilsProvider = fVar.c;
            Function0 function0 = fVar.d;
            List list = fVar.e;
            d dVar = fVar.f;
            k kVar = new k(utilsProvider, function0, list, productDetailsList, dVar, fVar.g);
            dVar.b.add(kVar);
            if (fVar.b.isReady()) {
                fVar.b.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(fVar.f342a).build(), kVar);
            } else {
                fVar.f.a(kVar);
                fVar.g.onUpdateFinished();
            }
        } else {
            fVar.g.onUpdateFinished();
        }
        f fVar2 = this.f341a;
        fVar2.f.a(fVar2);
    }
}
