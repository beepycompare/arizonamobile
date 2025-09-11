package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryPurchasesParams;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.List;
import kotlin.jvm.functions.Function0;
/* loaded from: classes4.dex */
public final class e extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f227a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ List c;

    public e(f fVar, BillingResult billingResult, List list) {
        this.f227a = fVar;
        this.b = billingResult;
        this.c = list;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        f fVar = this.f227a;
        BillingResult billingResult = this.b;
        List list = this.c;
        fVar.getClass();
        if (billingResult.getResponseCode() == 0 && !list.isEmpty()) {
            UtilsProvider utilsProvider = fVar.c;
            Function0 function0 = fVar.d;
            List list2 = fVar.e;
            d dVar = fVar.f;
            k kVar = new k(utilsProvider, function0, list2, list, dVar, fVar.g);
            dVar.b.add(kVar);
            if (fVar.b.isReady()) {
                fVar.b.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(fVar.f228a).build(), kVar);
            } else {
                fVar.f.a(kVar);
                fVar.g.onUpdateFinished();
            }
        } else {
            fVar.g.onUpdateFinished();
        }
        f fVar2 = this.f227a;
        fVar2.f.a(fVar2);
    }
}
