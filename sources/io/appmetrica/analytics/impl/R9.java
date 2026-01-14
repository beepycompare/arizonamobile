package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class R9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f765a;
    public final int b;
    public final boolean c;

    public R9(JSONObject jSONObject) {
        this.f765a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && R9.class == obj.getClass()) {
            R9 r9 = (R9) obj;
            if (this.b != r9.b || this.c != r9.c) {
                return false;
            }
            String str = this.f765a;
            String str2 = r9.f765a;
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
        String str = this.f765a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public R9(String str, int i, boolean z) {
        this.f765a = str;
        this.b = i;
        this.c = z;
    }
}
