package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ab extends JSONObject {
    public Ab() {
    }

    public final Long a(String str) {
        try {
            return Long.valueOf(getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Ab(String str) {
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
