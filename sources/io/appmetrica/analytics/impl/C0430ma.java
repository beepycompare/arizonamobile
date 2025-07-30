package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0430ma {

    /* renamed from: a  reason: collision with root package name */
    public final String f952a;
    public final int b;
    public final boolean c;

    public C0430ma(JSONObject jSONObject) {
        this.f952a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0430ma.class == obj.getClass()) {
            C0430ma c0430ma = (C0430ma) obj;
            if (this.b != c0430ma.b || this.c != c0430ma.c) {
                return false;
            }
            String str = this.f952a;
            String str2 = c0430ma.f952a;
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
        String str = this.f952a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0430ma(String str, int i, boolean z) {
        this.f952a = str;
        this.b = i;
        this.c = z;
    }
}
