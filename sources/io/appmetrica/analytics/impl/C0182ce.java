package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0182ce implements InterfaceC0566s {
    @Override // io.appmetrica.analytics.impl.InterfaceC0566s
    public final Map<String, String> a(Map<String, String> map) {
        map.put(AdRevenueConstants.LAYER_KEY, "native");
        return map;
    }
}
