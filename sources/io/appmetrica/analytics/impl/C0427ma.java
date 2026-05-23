package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0427ma {

    /* renamed from: a  reason: collision with root package name */
    public final String f1093a;
    public final int b;
    public final boolean c;

    public C0427ma(JSONObject jSONObject) {
        this.f1093a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0427ma.class == obj.getClass()) {
            C0427ma c0427ma = (C0427ma) obj;
            if (this.b != c0427ma.b || this.c != c0427ma.c) {
                return false;
            }
            String str = this.f1093a;
            if (str != null) {
                return str.equals(c0427ma.f1093a);
            }
            if (c0427ma.f1093a == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1093a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0427ma(String str, int i, boolean z) {
        this.f1093a = str;
        this.b = i;
        this.c = z;
    }
}
