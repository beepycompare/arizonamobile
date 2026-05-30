package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Td {

    /* renamed from: a  reason: collision with root package name */
    public final List f776a;
    public final long b;

    public Td(List list, long j) {
        this.f776a = list;
        this.b = j;
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<Bd> list = this.f776a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Bd bd : list) {
                bd.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("moduleName", bd.f476a);
                jSONObject2.put("loaded", bd.b);
                arrayList.add(jSONObject2);
            }
            jSONObject.put("modulesStatus", new JSONArray((Collection) arrayList));
            jSONObject.put("lastSendTime", this.b);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Td) {
            Td td = (Td) obj;
            return Intrinsics.areEqual(this.f776a, td.f776a) && this.b == td.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f776a.hashCode() * 31);
    }

    public final String toString() {
        return "ModulesStatus(modulesStatus=" + this.f776a + ", lastSendTime=" + this.b + ')';
    }
}
