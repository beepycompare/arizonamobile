package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Hb extends JSONObject {
    public Hb() {
    }

    public final Boolean a(String str) {
        try {
            return Boolean.valueOf(getBoolean(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Long b(String str) {
        try {
            return Long.valueOf(getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Hb(String str) {
        super(str);
    }

    public final String c(String str) {
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
