package ru.rustore.sdk.metrics.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* renamed from: ru.rustore.sdk.metrics.internal.w  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0832w {
    public static C0831v a(String uuid, String jsonString) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        String string = jSONObject.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(NAME_KEY)");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(DATA_KEY)");
        Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            arrayList.add(TuplesKt.to(next, jSONObject2.get(next).toString()));
        }
        return new C0831v(uuid, string, MapsKt.toMap(arrayList));
    }
}
