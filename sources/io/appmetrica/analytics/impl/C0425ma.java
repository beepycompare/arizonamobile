package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0425ma {

    /* renamed from: a  reason: collision with root package name */
    public final String f1096a;
    public final int b;
    public final boolean c;

    public C0425ma(JSONObject jSONObject) {
        this.f1096a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0425ma.class == obj.getClass()) {
            C0425ma c0425ma = (C0425ma) obj;
            if (this.b != c0425ma.b || this.c != c0425ma.c) {
                return false;
            }
            String str = this.f1096a;
            if (str != null) {
                return str.equals(c0425ma.f1096a);
            }
            if (c0425ma.f1096a == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1096a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0425ma(String str, int i, boolean z) {
        this.f1096a = str;
        this.b = i;
        this.c = z;
    }
}
