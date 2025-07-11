package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.pa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0503pa {
    public static boolean a(JSONObject jSONObject, String str, boolean z) {
        return ((Boolean) WrapUtils.getOrDefault(jSONObject.has(str) ? Boolean.valueOf(jSONObject.getJSONObject(str).getBoolean("enabled")) : null, Boolean.valueOf(z))).booleanValue();
    }
}
