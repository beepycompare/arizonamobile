package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class G3 implements O5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap c = Ib.c(asString);
        if (AbstractC0311hn.a(c)) {
            return c;
        }
        Gj.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
