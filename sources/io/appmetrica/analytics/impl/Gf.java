package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Gf implements O5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Qf invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("tracking_id");
        if (StringUtils.isNullOrEmpty(asString)) {
            Gj.a("Tracking id is empty", new Object[0]);
            return null;
        } else if (ParseUtils.parseLong(asString) == null) {
            Gj.a("Tracking id from preload info content provider is not a number", new Object[0]);
            return null;
        } else {
            try {
                String asString2 = contentValues.getAsString("additional_params");
                if (StringUtils.isNullOrEmpty(asString2)) {
                    Gj.a("No additional params", new Object[0]);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(asString2);
                if (jSONObject.length() == 0) {
                    Gj.a("Additional params are empty", new Object[0]);
                    return null;
                }
                Gj.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
                return new Qf(asString, jSONObject, true, false, EnumC0399l8.f);
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Could not parse additional parameters", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                return null;
            }
        }
    }
}
