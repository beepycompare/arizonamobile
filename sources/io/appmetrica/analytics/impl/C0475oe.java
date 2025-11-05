package io.appmetrica.analytics.impl;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0475oe {
    public static final H9 a(C0475oe c0475oe, Q9 q9, Object obj) {
        int i;
        Field[] fields;
        c0475oe.getClass();
        H9 h9 = new H9();
        switch (q9.ordinal()) {
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
        h9.f504a = i;
        C0500pe.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        h9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return h9;
    }
}
