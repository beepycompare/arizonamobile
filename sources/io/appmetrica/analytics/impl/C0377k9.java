package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0377k9 {

    /* renamed from: a  reason: collision with root package name */
    public final ro f903a;

    public C0377k9(ro roVar) {
        this.f903a = roVar;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        ro roVar = this.f903a;
        synchronized (roVar) {
            optJSONObject = roVar.f1034a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f903a.a(optJSONObject);
    }
}
