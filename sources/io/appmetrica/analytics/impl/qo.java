package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class qo {

    /* renamed from: a  reason: collision with root package name */
    public final so f1013a;

    public qo(C0408lf c0408lf, C0627ua c0627ua) {
        this.f1013a = new so(c0408lf, c0627ua, new to() { // from class: io.appmetrica.analytics.impl.qo$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.to
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return qo.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", AbstractC0753zb.a(jSONObject2, "last_migration_api_level", AbstractC0753zb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        so soVar = this.f1013a;
        soVar.a(soVar.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f1013a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        so soVar = this.f1013a;
        soVar.a(soVar.a().put("referrer_checked", true));
    }

    public final synchronized C0733yg b() {
        byte[] decode;
        C0733yg c0733yg;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f1013a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                c0733yg = new C0733yg(decode);
            }
        }
        c0733yg = null;
        return c0733yg;
    }

    public final synchronized void a(String str) {
        so soVar = this.f1013a;
        soVar.a(soVar.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f1013a.a(), "device_id_hash");
    }

    public final synchronized void a(C0733yg c0733yg) {
        so soVar = this.f1013a;
        soVar.a(soVar.a().put(Constants.REFERRER, c0733yg != null ? new String(Base64.encode(c0733yg.a(), 0), Charsets.UTF_8) : null));
    }
}
