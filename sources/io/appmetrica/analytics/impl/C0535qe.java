package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0535qe implements InterfaceC0623u {
    @Override // io.appmetrica.analytics.impl.InterfaceC0623u
    public final Map<String, String> a(Map<String, String> map) {
        map.put(AdRevenueConstants.LAYER_KEY, "native");
        return map;
    }
}
