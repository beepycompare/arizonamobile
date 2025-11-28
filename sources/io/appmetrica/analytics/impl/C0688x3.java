package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.x3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0688x3 implements F5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap c = AbstractC0447nb.c(asString);
        if (Jm.a(c)) {
            return c;
        }
        AbstractC0379kj.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
