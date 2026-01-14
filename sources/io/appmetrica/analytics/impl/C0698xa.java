package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0698xa {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f1304a;

    static {
        HashSet hashSet = new HashSet();
        f1304a = hashSet;
        hashSet.add("get_ad");
        hashSet.add("report");
        hashSet.add("report_ad");
        hashSet.add("startup");
        hashSet.add("diagnostic");
    }

    public static ArrayList a(JSONObject jSONObject, String str) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                return AbstractC0272gb.a(optJSONObject.getJSONArray("urls"));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
