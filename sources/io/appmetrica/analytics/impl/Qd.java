package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Qd implements InterfaceC0583t {
    @Override // io.appmetrica.analytics.impl.InterfaceC0583t
    public final Map<String, String> a(Map<String, String> map) {
        map.put(AdRevenueConstants.LAYER_KEY, "native");
        return map;
    }
}
