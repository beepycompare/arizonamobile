package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.we  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0683we {
    public static final V9 a(C0683we c0683we, EnumC0229ea enumC0229ea, Object obj) {
        int i;
        Field[] fields;
        c0683we.getClass();
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
        C0708xe.b.getClass();
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
