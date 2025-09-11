package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Db {
    public static final C0119aa a(Db db, EnumC0351ja enumC0351ja, JSONObject jSONObject) {
        int i;
        db.getClass();
        C0119aa c0119aa = new C0119aa();
        switch (enumC0351ja.ordinal()) {
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
        c0119aa.f790a = i;
        c0119aa.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return c0119aa;
    }
}
