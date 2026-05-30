package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class F implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final String f417a = "request_state";
    public final String b = "type";
    public final String c = "last_attempt";
    public final String d = "prev_attempt_result";

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final String fromModel(List<E> list) {
        Collection emptyList;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        String str = this.f417a;
        if (list != null) {
            emptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (E e : list) {
                try {
                    jSONObject = new JSONObject();
                    jSONObject.put(this.b, e.f416a);
                    jSONObject.put(this.c, e.b);
                    jSONObject.put(this.d, e.c.f413a);
                } catch (Throwable unused) {
                    jSONObject = new JSONObject();
                }
                emptyList.add(jSONObject);
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        jSONObject2.put(str, new JSONArray(emptyList));
        return jSONObject2.toString();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<E> toModel(String str) {
        JSONArray optJSONArray;
        E a2;
        try {
            ArrayList arrayList = new ArrayList();
            if (str != null && (optJSONArray = new JSONObject(str).optJSONArray(this.f417a)) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && (a2 = a(optJSONObject)) != null) {
                        arrayList.add(a2);
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final E a(JSONObject jSONObject) {
        A a2;
        try {
            String string = jSONObject.getString(this.b);
            long j = jSONObject.getLong(this.c);
            z zVar = A.b;
            String string2 = jSONObject.getString(this.d);
            zVar.getClass();
            A[] values = A.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    a2 = null;
                    break;
                }
                a2 = values[i];
                if (Intrinsics.areEqual(a2.f413a, string2)) {
                    break;
                }
                i++;
            }
            if (a2 == null) {
                a2 = A.c;
            }
            return new E(string, j, a2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
