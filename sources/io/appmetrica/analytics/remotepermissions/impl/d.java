package io.appmetrica.analytics.remotepermissions.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final String f1264a = "permissions";
    public final String b = "name";
    public final String c = "list";
    public final String d = "enabled";

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final a parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashSet hashSet = new HashSet();
        JSONObject optJSONObject = jSONObject.optJSONObject(this.f1264a);
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray(this.c)) != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null && optJSONObject2.optBoolean(this.d)) {
                    String optString = optJSONObject2.optString(this.b);
                    if (!TextUtils.isEmpty(optString)) {
                        hashSet.add(optString);
                    }
                }
            }
        }
        return new a(hashSet);
    }

    public final a b(JSONObject jSONObject) {
        return (a) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (a) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }
}
