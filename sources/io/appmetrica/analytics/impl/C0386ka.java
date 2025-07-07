package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0386ka {

    /* renamed from: a  reason: collision with root package name */
    public final String f903a;
    public final int b;
    public final boolean c;

    public C0386ka(JSONObject jSONObject) {
        this.f903a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0386ka.class == obj.getClass()) {
            C0386ka c0386ka = (C0386ka) obj;
            if (this.b != c0386ka.b || this.c != c0386ka.c) {
                return false;
            }
            String str = this.f903a;
            String str2 = c0386ka.f903a;
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
        String str = this.f903a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0386ka(String str, int i, boolean z) {
        this.f903a = str;
        this.b = i;
        this.c = z;
    }
}
