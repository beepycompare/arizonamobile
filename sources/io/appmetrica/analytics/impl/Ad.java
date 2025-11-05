package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class Ad {

    /* renamed from: a  reason: collision with root package name */
    public final List f396a;
    public final long b;

    public Ad(List list, long j) {
        this.f396a = list;
        this.b = j;
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<C0322id> list = this.f396a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (C0322id c0322id : list) {
                c0322id.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("moduleName", c0322id.f933a);
                jSONObject2.put("loaded", c0322id.b);
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
        if (obj instanceof Ad) {
            Ad ad = (Ad) obj;
            return Intrinsics.areEqual(this.f396a, ad.f396a) && this.b == ad.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f396a.hashCode() * 31);
    }

    public final String toString() {
        return "ModulesStatus(modulesStatus=" + this.f396a + ", lastSendTime=" + this.b + ')';
    }
}
