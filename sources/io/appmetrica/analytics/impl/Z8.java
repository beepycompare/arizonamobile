package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Z8 {

    /* renamed from: a  reason: collision with root package name */
    public final zo f782a;

    public Z8(zo zoVar) {
        this.f782a = zoVar;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        zo zoVar = this.f782a;
        synchronized (zoVar) {
            optJSONObject = zoVar.f1238a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f782a.a(optJSONObject);
    }
}
