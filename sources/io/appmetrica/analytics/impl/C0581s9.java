package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0581s9 {

    /* renamed from: a  reason: collision with root package name */
    public final Do f1080a;

    public C0581s9(Do r1) {
        this.f1080a = r1;
    }

    public final void a(int i, long j) {
        JSONObject optJSONObject;
        Do r0 = this.f1080a;
        synchronized (r0) {
            optJSONObject = r0.f418a.a().optJSONObject("numbers_of_type");
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put(String.valueOf(i), j);
        this.f1080a.a(optJSONObject);
    }
}
