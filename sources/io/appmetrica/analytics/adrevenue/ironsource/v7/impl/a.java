package io.appmetrica.analytics.adrevenue.ironsource.v7.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class a extends HashMap {
    public a(String str) {
        put(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-ironsource-v7");
        put(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, str == null ? AbstractJsonLexerKt.NULL : str);
        put("source", "ironsource");
    }
}
