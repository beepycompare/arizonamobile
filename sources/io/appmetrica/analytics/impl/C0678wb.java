package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0678wb {
    public static final T9 a(C0678wb c0678wb, EnumC0178ca enumC0178ca, JSONObject jSONObject) {
        int i;
        c0678wb.getClass();
        T9 t9 = new T9();
        switch (enumC0178ca.ordinal()) {
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
        t9.f639a = i;
        t9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return t9;
    }
}
