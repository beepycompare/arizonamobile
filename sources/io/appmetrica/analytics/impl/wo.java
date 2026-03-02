package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class wo {

    /* renamed from: a  reason: collision with root package name */
    public final yo f1293a;

    public wo(Ze ze, C0141ba c0141ba) {
        this.f1293a = new yo(ze, c0141ba, new zo() { // from class: io.appmetrica.analytics.impl.wo$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.zo
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return wo.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", AbstractC0271gb.a(jSONObject2, "last_migration_api_level", AbstractC0271gb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        yo yoVar = this.f1293a;
        yoVar.a(yoVar.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f1293a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        yo yoVar = this.f1293a;
        yoVar.a(yoVar.a().put("referrer_checked", true));
    }

    public final synchronized C0454ng b() {
        byte[] decode;
        C0454ng c0454ng;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f1293a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                c0454ng = new C0454ng(decode);
            }
        }
        c0454ng = null;
        return c0454ng;
    }

    public final synchronized void a(String str) {
        yo yoVar = this.f1293a;
        yoVar.a(yoVar.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f1293a.a(), "device_id_hash");
    }

    public final synchronized void a(C0454ng c0454ng) {
        yo yoVar = this.f1293a;
        yoVar.a(yoVar.a().put(Constants.REFERRER, c0454ng != null ? new String(Base64.encode(c0454ng.a(), 0), Charsets.UTF_8) : null));
    }
}
