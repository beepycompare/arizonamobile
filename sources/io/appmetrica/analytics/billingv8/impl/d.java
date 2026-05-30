package io.appmetrica.analytics.billingv8.impl;

import com.android.billingclient.api.BillingClient;
import java.util.LinkedHashSet;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final BillingClient f306a;
    public final LinkedHashSet b = new LinkedHashSet();

    public d(BillingClient billingClient) {
        this.f306a = billingClient;
    }

    public final void a(Object obj) {
        this.b.remove(obj);
        if (this.b.size() == 0) {
            this.f306a.endConnection();
        }
    }
}
