package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0502p9 {

    /* renamed from: a  reason: collision with root package name */
    public final zo f1009a;

    public C0502p9(zo zoVar) {
        this.f1009a = zoVar;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        zo zoVar = this.f1009a;
        synchronized (zoVar) {
            optJSONObject = zoVar.f1187a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f1009a.a(optJSONObject);
    }
}
