package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.n9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0454n9 {

    /* renamed from: a  reason: collision with root package name */
    public final uo f967a;

    public C0454n9(uo uoVar) {
        this.f967a = uoVar;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        uo uoVar = this.f967a;
        synchronized (uoVar) {
            optJSONObject = uoVar.f1092a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f967a.a(optJSONObject);
    }
}
