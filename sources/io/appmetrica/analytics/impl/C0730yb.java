package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.yb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0730yb {
    public static final V9 a(C0730yb c0730yb, EnumC0229ea enumC0229ea, JSONObject jSONObject) {
        int i;
        c0730yb.getClass();
        V9 v9 = new V9();
        switch (enumC0229ea.ordinal()) {
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
        v9.f684a = i;
        v9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return v9;
    }
}
