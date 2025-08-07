package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class to {

    /* renamed from: a  reason: collision with root package name */
    public final vo f1073a;

    public to(C0461nf c0461nf, C0680wa c0680wa) {
        this.f1073a = new vo(c0461nf, c0680wa, new wo() { // from class: io.appmetrica.analytics.impl.to$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.wo
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return to.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", Bb.a(jSONObject2, "last_migration_api_level", Bb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        vo voVar = this.f1073a;
        voVar.a(voVar.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f1073a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        vo voVar = this.f1073a;
        voVar.a(voVar.a().put("referrer_checked", true));
    }

    public final synchronized Ag b() {
        byte[] decode;
        Ag ag;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f1073a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                ag = new Ag(decode);
            }
        }
        ag = null;
        return ag;
    }

    public final synchronized void a(String str) {
        vo voVar = this.f1073a;
        voVar.a(voVar.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f1073a.a(), "device_id_hash");
    }

    public final synchronized void a(Ag ag) {
        vo voVar = this.f1073a;
        voVar.a(voVar.a().put(Constants.REFERRER, ag != null ? new String(Base64.encode(ag.a(), 0), Charsets.UTF_8) : null));
    }
}
