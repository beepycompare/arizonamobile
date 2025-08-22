package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ye  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0731ye {
    public static final X9 a(C0731ye c0731ye, EnumC0274ga enumC0274ga, Object obj) {
        int i;
        Field[] fields;
        c0731ye.getClass();
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
        C0756ze.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        x9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return x9;
    }
}
