package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0195db {
    public static final A9 a(C0195db c0195db, J9 j9, JSONObject jSONObject) {
        int i;
        c0195db.getClass();
        A9 a9 = new A9();
        switch (j9.ordinal()) {
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
        a9.f496a = i;
        a9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return a9;
    }
}
