package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ab {
    public static final X9 a(Ab ab, EnumC0274ga enumC0274ga, JSONObject jSONObject) {
        int i;
        ab.getClass();
        X9 x9 = new X9();
        switch (enumC0274ga.ordinal()) {
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
        x9.f724a = i;
        x9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return x9;
    }
}
