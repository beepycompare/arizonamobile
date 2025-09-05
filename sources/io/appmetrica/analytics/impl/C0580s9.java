package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0580s9 {

    /* renamed from: a  reason: collision with root package name */
    public final Do f1075a;

    public C0580s9(Do r1) {
        this.f1075a = r1;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        Do r0 = this.f1075a;
        synchronized (r0) {
            optJSONObject = r0.f413a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f1075a.a(optJSONObject);
    }
}
