package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Co {

    /* renamed from: a  reason: collision with root package name */
    public final Eo f393a;

    public Co(C0611tf c0611tf, Ba ba) {
        this.f393a = new Eo(c0611tf, ba, new Fo() { // from class: io.appmetrica.analytics.impl.Co$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Fo
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return Co.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", Gb.a(jSONObject2, "last_migration_api_level", Gb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        Eo eo = this.f393a;
        eo.a(eo.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f393a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        Eo eo = this.f393a;
        eo.a(eo.a().put("referrer_checked", true));
    }

    public final synchronized Jg b() {
        byte[] decode;
        Jg jg;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f393a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                jg = new Jg(decode);
            }
        }
        jg = null;
        return jg;
    }

    public final synchronized void a(String str) {
        Eo eo = this.f393a;
        eo.a(eo.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f393a.a(), "device_id_hash");
    }

    public final synchronized void a(Jg jg) {
        Eo eo = this.f393a;
        eo.a(eo.a().put(Constants.REFERRER, jg != null ? new String(Base64.encode(jg.a(), 0), Charsets.UTF_8) : null));
    }
}
