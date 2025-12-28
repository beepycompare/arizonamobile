package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class A implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final String f458a = "request_state";
    public final String b = "type";
    public final String c = "last_attempt";
    public final String d = "prev_attempt_result";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final String fromModel(List<z> list) {
        ?? emptyList;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        String str = this.f458a;
        if (list != null) {
            emptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (z zVar : list) {
                try {
                    jSONObject = new JSONObject();
                    jSONObject.put(this.b, zVar.f480a);
                    jSONObject.put(this.c, zVar.b);
                    jSONObject.put(this.d, u.a(zVar.c));
                } catch (Throwable unused) {
                    jSONObject = new JSONObject();
                }
                emptyList.add(jSONObject);
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        jSONObject2.put(str, new JSONArray((Collection) emptyList));
        return jSONObject2.toString();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<z> toModel(String str) {
        JSONArray optJSONArray;
        z zVar;
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            if (str == null || (optJSONArray = new JSONObject(str).optJSONArray(this.f458a)) == null) {
                return arrayList;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    try {
                        String string = optJSONObject.getString(this.b);
                        long j = optJSONObject.getLong(this.c);
                        String string2 = optJSONObject.getString(this.d);
                        int[] b = v.b(4);
                        int length2 = b.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                i = 0;
                                break;
                            }
                            i = b[i3];
                            if (Intrinsics.areEqual(u.a(i), string2)) {
                                break;
                            }
                            i3++;
                        }
                        if (i == 0) {
                            i = 1;
                        }
                        zVar = new z(string, j, i);
                    } catch (Throwable unused) {
                        zVar = null;
                    }
                    if (zVar != null) {
                        arrayList.add(zVar);
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused2) {
            return CollectionsKt.emptyList();
        }
    }
}
