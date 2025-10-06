package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ra  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0557ra {

    /* renamed from: a  reason: collision with root package name */
    public final String f1065a;
    public final int b;
    public final boolean c;

    public C0557ra(JSONObject jSONObject) {
        this.f1065a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0557ra.class == obj.getClass()) {
            C0557ra c0557ra = (C0557ra) obj;
            if (this.b != c0557ra.b || this.c != c0557ra.c) {
                return false;
            }
            String str = this.f1065a;
            String str2 = c0557ra.f1065a;
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
        String str = this.f1065a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0557ra(String str, int i, boolean z) {
        this.f1065a = str;
        this.b = i;
        this.c = z;
    }
}
