package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.he  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0300he {
    public static final A9 a(C0300he c0300he, J9 j9, Object obj) {
        int i;
        Field[] fields;
        c0300he.getClass();
        A9 a9 = new A9();
        switch (j9.ordinal()) {
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
        a9.f496a = i;
        C0326ie.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        a9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return a9;
    }
}
