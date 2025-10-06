package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Db {
    public static final C0120aa a(Db db, EnumC0352ja enumC0352ja, JSONObject jSONObject) {
        int i;
        db.getClass();
        C0120aa c0120aa = new C0120aa();
        switch (enumC0352ja.ordinal()) {
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
        c0120aa.f791a = i;
        c0120aa.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return c0120aa;
    }
}
