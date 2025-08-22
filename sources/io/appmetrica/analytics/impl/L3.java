package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class L3 implements U5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap c = Db.c(asString);
        if (Lm.a(c)) {
            return c;
        }
        AbstractC0711xj.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
