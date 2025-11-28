package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0422mb extends JSONObject {
    public C0422mb() {
    }

    public final Long a(String str) {
        try {
            return Long.valueOf(getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0422mb(String str) {
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
