package io.appmetrica.analytics.idsync.impl;

import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class v {
    public static String a(D d) {
        String encodeToString;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, d.f420a);
        jSONObject.put(ImagesContract.URL, d.c);
        jSONObject.put("responseCode", d.e);
        byte[] bArr = d.f;
        try {
            encodeToString = new String(bArr, Charsets.UTF_8);
        } catch (Throwable unused) {
            encodeToString = Base64.encodeToString(bArr, 0);
        }
        jSONObject.put("responseBody", encodeToString);
        Map map = d.g;
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject2.putOpt((String) entry.getKey(), new JSONArray((Collection) ((List) entry.getValue())));
        }
        jSONObject.put("responseHeaders", jSONObject2);
        return jSONObject.toString();
    }
}
