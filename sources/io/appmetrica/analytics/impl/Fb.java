package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Fb {
    public static final V9 a(Fb fb, EnumC0220ea enumC0220ea, JSONObject jSONObject) {
        int i;
        fb.getClass();
        V9 v9 = new V9();
        switch (enumC0220ea.ordinal()) {
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
        v9.f807a = i;
        v9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return v9;
    }
}
