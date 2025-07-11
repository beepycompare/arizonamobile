package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0378ka {

    /* renamed from: a  reason: collision with root package name */
    public final String f904a;
    public final int b;
    public final boolean c;

    public C0378ka(JSONObject jSONObject) {
        this.f904a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0378ka.class == obj.getClass()) {
            C0378ka c0378ka = (C0378ka) obj;
            if (this.b != c0378ka.b || this.c != c0378ka.c) {
                return false;
            }
            String str = this.f904a;
            String str2 = c0378ka.f904a;
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
        String str = this.f904a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0378ka(String str, int i, boolean z) {
        this.f904a = str;
        this.b = i;
        this.c = z;
    }
}
