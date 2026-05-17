package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.td  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0600td {

    /* renamed from: a  reason: collision with root package name */
    public final List f1241a;
    public final long b;

    public C0600td(List list, long j) {
        this.f1241a = list;
        this.b = j;
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<C0144bd> list = this.f1241a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (C0144bd c0144bd : list) {
                c0144bd.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("moduleName", c0144bd.f924a);
                jSONObject2.put("loaded", c0144bd.b);
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
        if (obj instanceof C0600td) {
            C0600td c0600td = (C0600td) obj;
            return Intrinsics.areEqual(this.f1241a, c0600td.f1241a) && this.b == c0600td.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f1241a.hashCode() * 31);
    }

    public final String toString() {
        return "ModulesStatus(modulesStatus=" + this.f1241a + ", lastSendTime=" + this.b + ')';
    }
}
