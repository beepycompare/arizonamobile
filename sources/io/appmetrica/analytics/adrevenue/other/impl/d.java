package io.appmetrica.analytics.adrevenue.other.impl;

import android.os.Bundle;
import io.appmetrica.analytics.adrevenue.other.internal.ClientSideAdRevenueOtherConfigWrapper;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
/* loaded from: classes5.dex */
public final class d implements BundleToServiceConfigConverter {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter
    /* renamed from: a */
    public final ClientSideAdRevenueOtherConfigWrapper fromBundle(Bundle bundle) {
        boolean z = f.f240a;
        return ClientSideAdRevenueOtherConfigWrapper.Companion.toWrapper$ad_revenue_other_release(new e(bundle.getBoolean("enabled", f.f240a), bundle.getBoolean("include_source", f.b)));
    }
}
