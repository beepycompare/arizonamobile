package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0686wb {
    public static final T9 a(C0686wb c0686wb, EnumC0186ca enumC0186ca, JSONObject jSONObject) {
        int i;
        c0686wb.getClass();
        T9 t9 = new T9();
        switch (enumC0186ca.ordinal()) {
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
        t9.f638a = i;
        t9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return t9;
    }
}
