package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class xo {

    /* renamed from: a  reason: collision with root package name */
    public final zo f1206a;

    public xo(C0117af c0117af, C0164ca c0164ca) {
        this.f1206a = new zo(c0117af, c0164ca, new Ao() { // from class: io.appmetrica.analytics.impl.xo$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Ao
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return xo.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", AbstractC0294hb.a(jSONObject2, "last_migration_api_level", AbstractC0294hb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        zo zoVar = this.f1206a;
        zoVar.a(zoVar.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f1206a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        zo zoVar = this.f1206a;
        zoVar.a(zoVar.a().put("referrer_checked", true));
    }

    public final synchronized C0477og b() {
        byte[] decode;
        C0477og c0477og;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f1206a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                c0477og = new C0477og(decode);
            }
        }
        c0477og = null;
        return c0477og;
    }

    public final synchronized void a(String str) {
        zo zoVar = this.f1206a;
        zoVar.a(zoVar.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f1206a.a(), "device_id_hash");
    }

    public final synchronized void a(C0477og c0477og) {
        zo zoVar = this.f1206a;
        zoVar.a(zoVar.a().put(Constants.REFERRER, c0477og != null ? new String(Base64.encode(c0477og.a(), 0), Charsets.UTF_8) : null));
    }
}
