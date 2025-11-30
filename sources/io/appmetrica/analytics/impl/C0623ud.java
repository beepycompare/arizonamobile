package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ud  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0623ud {

    /* renamed from: a  reason: collision with root package name */
    public final List f1149a;
    public final long b;

    public C0623ud(List list, long j) {
        this.f1149a = list;
        this.b = j;
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<C0167cd> list = this.f1149a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (C0167cd c0167cd : list) {
                c0167cd.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("moduleName", c0167cd.f831a);
                jSONObject2.put("loaded", c0167cd.b);
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
        if (obj instanceof C0623ud) {
            C0623ud c0623ud = (C0623ud) obj;
            return Intrinsics.areEqual(this.f1149a, c0623ud.f1149a) && this.b == c0623ud.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f1149a.hashCode() * 31);
    }

    public final String toString() {
        return "ModulesStatus(modulesStatus=" + this.f1149a + ", lastSendTime=" + this.b + ')';
    }
}
