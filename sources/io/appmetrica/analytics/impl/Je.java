package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Je {
    public static final V9 a(Je je, EnumC0220ea enumC0220ea, Object obj) {
        int i;
        Field[] fields;
        je.getClass();
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
        Ke.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        v9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return v9;
    }
}
