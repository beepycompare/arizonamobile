package io.appmetrica.analytics.idsync.impl;

import android.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j {
    public static String a(y yVar) {
        String encodeToString;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", yVar.f378a);
        jSONObject.put("url", yVar.c);
        jSONObject.put("responseCode", yVar.e);
        byte[] bArr = yVar.f;
        try {
            encodeToString = new String(bArr, Charsets.UTF_8);
        } catch (Throwable unused) {
            encodeToString = Base64.encodeToString(bArr, 0);
        }
        jSONObject.put("responseBody", encodeToString);
        Map map = yVar.g;
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject2.putOpt((String) entry.getKey(), new JSONArray((Collection) ((List) entry.getValue())));
        }
        jSONObject.put("responseHeaders", jSONObject2);
        return jSONObject.toString();
    }
}
