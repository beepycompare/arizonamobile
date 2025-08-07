package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.uf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0635uf implements U5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Ef invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("tracking_id");
        if (TextUtils.isEmpty(asString)) {
            AbstractC0589sj.a("Tracking id is empty", new Object[0]);
            return null;
        } else if (ParseUtils.parseLong(asString) == null) {
            AbstractC0589sj.a("Tracking id from preload info content provider is not a number", new Object[0]);
            return null;
        } else {
            try {
                String asString2 = contentValues.getAsString("additional_params");
                if (TextUtils.isEmpty(asString2)) {
                    AbstractC0589sj.a("No additional params", new Object[0]);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(asString2);
                if (jSONObject.length() == 0) {
                    AbstractC0589sj.a("Additional params are empty", new Object[0]);
                    return null;
                }
                AbstractC0589sj.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
                return new Ef(asString, jSONObject, true, false, EnumC0404l8.e);
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Could not parse additional parameters", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                return null;
            }
        }
    }
}
