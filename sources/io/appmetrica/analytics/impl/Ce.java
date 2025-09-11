package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ce {
    public static final C0119aa a(Ce ce, EnumC0351ja enumC0351ja, Object obj) {
        int i;
        Field[] fields;
        ce.getClass();
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
        De.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        c0119aa.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return c0119aa;
    }
}
