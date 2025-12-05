package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.hf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0297hf implements InterfaceC0739z5 {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final C0549rf invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("tracking_id");
        if (TextUtils.isEmpty(asString)) {
            AbstractC0275gj.a("Tracking id is empty", new Object[0]);
            return null;
        } else if (ParseUtils.parseLong(asString) == null) {
            AbstractC0275gj.a("Tracking id from preload info content provider is not a number", new Object[0]);
            return null;
        } else {
            try {
                String asString2 = contentValues.getAsString("additional_params");
                if (TextUtils.isEmpty(asString2)) {
                    AbstractC0275gj.a("No additional params", new Object[0]);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(asString2);
                if (jSONObject.length() == 0) {
                    AbstractC0275gj.a("Additional params are empty", new Object[0]);
                    return null;
                }
                AbstractC0275gj.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
                return new C0549rf(asString, jSONObject, true, false, T7.e);
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Could not parse additional parameters", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                return null;
            }
        }
    }
}
