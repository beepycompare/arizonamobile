package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0420ma {

    /* renamed from: a  reason: collision with root package name */
    public final String f1099a;
    public final int b;
    public final boolean c;

    public C0420ma(JSONObject jSONObject) {
        this.f1099a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt("version", -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0420ma.class == obj.getClass()) {
            C0420ma c0420ma = (C0420ma) obj;
            if (this.b != c0420ma.b || this.c != c0420ma.c) {
                return false;
            }
            String str = this.f1099a;
            if (str != null) {
                return str.equals(c0420ma.f1099a);
            }
            if (c0420ma.f1099a == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1099a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0420ma(String str, int i, boolean z) {
        this.f1099a = str;
        this.b = i;
        this.c = z;
    }
}
