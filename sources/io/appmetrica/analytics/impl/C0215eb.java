package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.eb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0215eb {
    public static final B9 a(C0215eb c0215eb, K9 k9, JSONObject jSONObject) {
        int i;
        c0215eb.getClass();
        B9 b9 = new B9();
        switch (k9.ordinal()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        b9.f505a = i;
        b9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return b9;
    }
}
