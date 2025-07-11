package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0582sf implements R5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Cf invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("tracking_id");
        if (TextUtils.isEmpty(asString)) {
            AbstractC0512pj.a("Tracking id is empty", new Object[0]);
            return null;
        } else if (ParseUtils.parseLong(asString) == null) {
            AbstractC0512pj.a("Tracking id from preload info content provider is not a number", new Object[0]);
            return null;
        } else {
            try {
                String asString2 = contentValues.getAsString("additional_params");
                if (TextUtils.isEmpty(asString2)) {
                    AbstractC0512pj.a("No additional params", new Object[0]);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(asString2);
                if (jSONObject.length() == 0) {
                    AbstractC0512pj.a("Additional params are empty", new Object[0]);
                    return null;
                }
                AbstractC0512pj.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
                return new Cf(asString, jSONObject, true, false, EnumC0327i8.e);
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Could not parse additional parameters", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                return null;
            }
        }
    }
}
