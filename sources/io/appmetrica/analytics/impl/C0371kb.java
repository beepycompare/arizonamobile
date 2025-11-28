package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.kb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0371kb {
    public static final H9 a(C0371kb c0371kb, Q9 q9, JSONObject jSONObject) {
        int i;
        c0371kb.getClass();
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
        h9.b = jSONObject.toString().getBytes(Charsets.UTF_8);
        return h9;
    }
}
