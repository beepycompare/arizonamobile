package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class L3 implements R5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap c = AbstractC0753zb.c(asString);
        if (Dm.a(c)) {
            return c;
        }
        AbstractC0512pj.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
