package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0431ma {

    /* renamed from: a  reason: collision with root package name */
    public final String f951a;
    public final int b;
    public final boolean c;

    public C0431ma(JSONObject jSONObject) {
        this.f951a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0431ma.class == obj.getClass()) {
            C0431ma c0431ma = (C0431ma) obj;
            if (this.b != c0431ma.b || this.c != c0431ma.c) {
                return false;
            }
            String str = this.f951a;
            String str2 = c0431ma.f951a;
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
        String str = this.f951a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0431ma(String str, int i, boolean z) {
        this.f951a = str;
        this.b = i;
        this.c = z;
    }
}
