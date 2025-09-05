package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ra  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0556ra {

    /* renamed from: a  reason: collision with root package name */
    public final String f1060a;
    public final int b;
    public final boolean c;

    public C0556ra(JSONObject jSONObject) {
        this.f1060a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0556ra.class == obj.getClass()) {
            C0556ra c0556ra = (C0556ra) obj;
            if (this.b != c0556ra.b || this.c != c0556ra.c) {
                return false;
            }
            String str = this.f1060a;
            String str2 = c0556ra.f1060a;
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
        String str = this.f1060a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0556ra(String str, int i, boolean z) {
        this.f1060a = str;
        this.b = i;
        this.c = z;
    }
}
