package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.yb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0728yb extends JSONObject {
    public C0728yb() {
    }

    public final Long a(String str) {
        try {
            return Long.valueOf(getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0728yb(String str) {
        super(str);
    }

    public final String b(String str) {
        if (has(str)) {
            try {
                return getString(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }
}
