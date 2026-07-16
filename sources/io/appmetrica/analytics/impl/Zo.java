package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Zo {

    /* renamed from: a  reason: collision with root package name */
    public final bp f878a;

    public Zo(C0769zf c0769zf, C0738ya c0738ya) {
        this.f878a = new bp(c0769zf, c0738ya, new cp() { // from class: io.appmetrica.analytics.impl.Zo$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.cp
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return Zo.a(jSONObject, jSONObject2);
            }
        });
    }

    public final synchronized void a(Bg bg) {
        String str;
        if (bg != null) {
            try {
                str = new String(Base64.encode(bg.a(), 0), Charsets.UTF_8);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            str = null;
        }
        JSONObject a2 = this.f878a.a();
        if (!Intrinsics.areEqual(JsonUtils.optStringOrNull(a2, Constants.REFERRER), str)) {
            this.f878a.a(a2.put(Constants.REFERRER, str));
        }
        bp bpVar = this.f878a;
        bp.a(bpVar.f916a);
        bp.a(bpVar.b);
    }

    public final synchronized void b(String str) {
        JSONObject a2 = this.f878a.a();
        if (!Intrinsics.areEqual(JsonUtils.optStringOrNull(a2, "device_id_hash"), str)) {
            this.f878a.a(a2.put("device_id_hash", str));
        }
        bp bpVar = this.f878a;
        bp.a(bpVar.f916a);
        bp.a(bpVar.b);
    }

    public final synchronized Bg b() {
        byte[] decode;
        Bg bg;
        String optStringOrNull = JsonUtils.optStringOrNull(this.f878a.a(), Constants.REFERRER);
        if (optStringOrNull != null) {
            try {
                decode = Base64.decode(optStringOrNull.getBytes(Charsets.UTF_8), 0);
            } catch (Throwable unused) {
            }
            if (decode != null && decode.length != 0) {
                bg = new Bg(decode);
            }
        }
        bg = null;
        return bg;
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(NotificationStatsPayloadFactory.KEY_DEVICE_ID, JsonUtils.optStringOrNullable(jSONObject2, NotificationStatsPayloadFactory.KEY_DEVICE_ID, JsonUtils.optStringOrNull(jSONObject, NotificationStatsPayloadFactory.KEY_DEVICE_ID)));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", Ib.a(jSONObject2, "last_migration_api_level", Ib.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void a(String str) {
        JSONObject a2 = this.f878a.a();
        if (!Intrinsics.areEqual(JsonUtils.optStringOrNull(a2, NotificationStatsPayloadFactory.KEY_DEVICE_ID), str)) {
            this.f878a.a(a2.put(NotificationStatsPayloadFactory.KEY_DEVICE_ID, str));
        }
        bp bpVar = this.f878a;
        bp.a(bpVar.f916a);
        bp.a(bpVar.b);
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f878a.a(), "device_id_hash");
    }
}
