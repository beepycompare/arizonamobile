package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ke  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0382ke implements InterfaceC0571s {
    @Override // io.appmetrica.analytics.impl.InterfaceC0571s
    public final Map<String, String> a(Map<String, String> map) {
        map.put(AdRevenueConstants.LAYER_KEY, "native");
        return map;
    }
}
