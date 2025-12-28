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
public final class C0622ud {

    /* renamed from: a  reason: collision with root package name */
    public final List f1247a;
    public final long b;

    public C0622ud(List list, long j) {
        this.f1247a = list;
        this.b = j;
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<C0166cd> list = this.f1247a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (C0166cd c0166cd : list) {
                c0166cd.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("moduleName", c0166cd.f929a);
                jSONObject2.put("loaded", c0166cd.b);
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
        if (obj instanceof C0622ud) {
            C0622ud c0622ud = (C0622ud) obj;
            return Intrinsics.areEqual(this.f1247a, c0622ud.f1247a) && this.b == c0622ud.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f1247a.hashCode() * 31);
    }

    public final String toString() {
        return "ModulesStatus(modulesStatus=" + this.f1247a + ", lastSendTime=" + this.b + ')';
    }
}
