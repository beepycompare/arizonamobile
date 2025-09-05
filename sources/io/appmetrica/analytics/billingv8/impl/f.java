package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsResult;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
import kotlin.jvm.functions.Function0;
/* loaded from: classes4.dex */
public final class f implements ProductDetailsResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final String f238a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final Function0 d;
    public final List e;
    public final d f;
    public final n g;

    public f(String str, BillingClient billingClient, UtilsProvider utilsProvider, h hVar, List list, d dVar, n nVar) {
        this.f238a = str;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = hVar;
        this.e = list;
        this.f = dVar;
        this.g = nVar;
    }

    public final void onProductDetailsResponse(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
        this.c.getWorkerExecutor().execute(new e(this, billingResult, queryProductDetailsResult));
    }
}
