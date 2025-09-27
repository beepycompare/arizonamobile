package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Do {

    /* renamed from: a  reason: collision with root package name */
    public final Eo f418a;

    public Do(C0537qf c0537qf, Ho ho, String str) {
        this.f418a = new Eo(c0537qf, ho, new Fo() { // from class: io.appmetrica.analytics.impl.Do$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Fo
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return Do.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        Boolean bool = Boolean.FALSE;
        jSONObject3.put("first_event_done", JsonUtils.optBooleanOrNullable(jSONObject2, "first_event_done", JsonUtils.optBooleanOrNullable(jSONObject, "first_event_done", bool)));
        jSONObject3.put("init_event_done", JsonUtils.optBooleanOrNullable(jSONObject2, "init_event_done", JsonUtils.optBooleanOrNullable(jSONObject, "init_event_done", bool)));
        jSONObject3.put("report_request_id", Gb.a(jSONObject2, "report_request_id", Gb.a(jSONObject, "report_request_id", -1)));
        jSONObject3.put("global_number", JsonUtils.optLongOrDefault(jSONObject2, "global_number", JsonUtils.optLongOrDefault(jSONObject, "global_number", 0L)));
        jSONObject3.put("session_id", JsonUtils.optLongOrDefault(jSONObject2, "session_id", JsonUtils.optLongOrDefault(jSONObject, "session_id", -1L)));
        jSONObject3.put("referrer_handled", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_handled", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_handled", bool)));
        jSONObject3.put("numbers_of_type", JsonUtils.optJsonObjectOrNullable(jSONObject2, "numbers_of_type", JsonUtils.optJsonObjectOrNull(jSONObject, "numbers_of_type")));
        jSONObject3.put("open_id", Gb.a(jSONObject2, "open_id", Gb.a(jSONObject, "open_id", 1)));
        jSONObject3.put("attribution_id", Gb.a(jSONObject2, "attribution_id", Gb.a(jSONObject, "attribution_id", 1)));
        jSONObject3.put("last_migration_api_level", Gb.a(jSONObject2, "last_migration_api_level", Gb.a(jSONObject, "last_migration_api_level", 0)));
        jSONObject3.put("external_attribution_window_start", JsonUtils.optLongOrDefault(jSONObject2, "external_attribution_window_start", JsonUtils.optLongOrDefault(jSONObject, "external_attribution_window_start", -1L)));
        return jSONObject3;
    }

    public final synchronized void b(long j) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("global_number", j));
    }

    public final synchronized boolean c() {
        return this.f418a.a().optBoolean("first_event_done", false);
    }

    public final synchronized boolean d() {
        return this.f418a.a().optBoolean("init_event_done", false);
    }

    public final synchronized int b() {
        return this.f418a.a().optInt("open_id", 1);
    }

    public final synchronized void c(long j) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("session_id", j));
    }

    public final synchronized void b(int i) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("last_migration_api_level", i));
    }

    public final synchronized void c(int i) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("open_id", i));
    }

    public final synchronized void a(JSONObject jSONObject) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("numbers_of_type", jSONObject));
    }

    public final synchronized int a() {
        return this.f418a.a().optInt("attribution_id", 1);
    }

    public final synchronized void a(int i) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("attribution_id", i));
    }

    public final synchronized void a(long j) {
        Eo eo = this.f418a;
        eo.a(eo.a().put("external_attribution_window_start", j));
    }
}
