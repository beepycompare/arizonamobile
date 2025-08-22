package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class yo {

    /* renamed from: a  reason: collision with root package name */
    public final Ao f1167a;

    public yo(C0508pf c0508pf, C0727ya c0727ya) {
        this.f1167a = new Ao(c0508pf, c0727ya, new Bo() { // from class: io.appmetrica.analytics.impl.yo$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Bo
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return yo.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", Db.a(jSONObject2, "last_migration_api_level", Db.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        Ao ao = this.f1167a;
        ao.a(ao.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f1167a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        Ao ao = this.f1167a;
        ao.a(ao.a().put("referrer_checked", true));
    }

    public final synchronized Fg b() {
        byte[] decode;
        Fg fg;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f1167a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                fg = new Fg(decode);
            }
        }
        fg = null;
        return fg;
    }

    public final synchronized void a(String str) {
        Ao ao = this.f1167a;
        ao.a(ao.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f1167a.a(), "device_id_hash");
    }

    public final synchronized void a(Fg fg) {
        Ao ao = this.f1167a;
        ao.a(ao.a().put(Constants.REFERRER, fg != null ? new String(Base64.encode(fg.a(), 0), Charsets.UTF_8) : null));
    }
}
