package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0478oa {

    /* renamed from: a  reason: collision with root package name */
    public final String f998a;
    public final int b;
    public final boolean c;

    public C0478oa(JSONObject jSONObject) {
        this.f998a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0478oa.class == obj.getClass()) {
            C0478oa c0478oa = (C0478oa) obj;
            if (this.b != c0478oa.b || this.c != c0478oa.c) {
                return false;
            }
            String str = this.f998a;
            String str2 = c0478oa.f998a;
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
        String str = this.f998a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C0478oa(String str, int i, boolean z) {
        this.f998a = str;
        this.b = i;
        this.c = z;
    }
}
