package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import java.util.LinkedHashSet;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final BillingClient f291a;
    public final LinkedHashSet b = new LinkedHashSet();

    public d(BillingClient billingClient) {
        this.f291a = billingClient;
    }

    public final void a(Object obj) {
        this.b.remove(obj);
        if (this.b.size() == 0) {
            this.f291a.endConnection();
        }
    }
}
