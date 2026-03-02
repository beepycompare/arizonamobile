package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.p3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0491p3 implements InterfaceC0717y5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap c = AbstractC0271gb.c(asString);
        if (Fm.a(c)) {
            return c;
        }
        AbstractC0253fj.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
