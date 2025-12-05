package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class S9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f759a;
    public final int b;
    public final boolean c;

    public S9(JSONObject jSONObject) {
        this.f759a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && S9.class == obj.getClass()) {
            S9 s9 = (S9) obj;
            if (this.b != s9.b || this.c != s9.c) {
                return false;
            }
            String str = this.f759a;
            String str2 = s9.f759a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f759a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public S9(String str, int i, boolean z) {
        this.f759a = str;
        this.b = i;
        this.c = z;
    }
}
