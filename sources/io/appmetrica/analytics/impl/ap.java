package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ap {

    /* renamed from: a  reason: collision with root package name */
    public final bp f893a;

    public ap(C0691wf c0691wf, ep epVar, String str) {
        this.f893a = new bp(c0691wf, epVar, new cp() { // from class: io.appmetrica.analytics.impl.ap$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.cp
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return ap.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        Boolean bool = Boolean.FALSE;
        jSONObject3.put("first_event_done", JsonUtils.optBooleanOrNullable(jSONObject2, "first_event_done", JsonUtils.optBooleanOrNullable(jSONObject, "first_event_done", bool)));
        jSONObject3.put("init_event_done", JsonUtils.optBooleanOrNullable(jSONObject2, "init_event_done", JsonUtils.optBooleanOrNullable(jSONObject, "init_event_done", bool)));
        jSONObject3.put("report_request_id", Ib.a(jSONObject2, "report_request_id", Ib.a(jSONObject, "report_request_id", -1)));
        jSONObject3.put("global_number", JsonUtils.optLongOrDefault(jSONObject2, "global_number", JsonUtils.optLongOrDefault(jSONObject, "global_number", 0L)));
        jSONObject3.put("session_id", JsonUtils.optLongOrDefault(jSONObject2, "session_id", JsonUtils.optLongOrDefault(jSONObject, "session_id", -1L)));
        jSONObject3.put("referrer_handled", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_handled", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_handled", bool)));
        jSONObject3.put("numbers_of_type", JsonUtils.optJsonObjectOrNullable(jSONObject2, "numbers_of_type", JsonUtils.optJsonObjectOrNull(jSONObject, "numbers_of_type")));
        jSONObject3.put("open_id", Ib.a(jSONObject2, "open_id", Ib.a(jSONObject, "open_id", 1)));
        jSONObject3.put("attribution_id", Ib.a(jSONObject2, "attribution_id", Ib.a(jSONObject, "attribution_id", 1)));
        jSONObject3.put("last_migration_api_level", Ib.a(jSONObject2, "last_migration_api_level", Ib.a(jSONObject, "last_migration_api_level", 0)));
        jSONObject3.put("external_attribution_window_start", JsonUtils.optLongOrDefault(jSONObject2, "external_attribution_window_start", JsonUtils.optLongOrDefault(jSONObject, "external_attribution_window_start", -1L)));
        return jSONObject3;
    }

    public final synchronized void b(long j) {
        JSONObject a2 = this.f893a.a();
        if (a2.optLong("session_id", -1L) != j) {
            this.f893a.a(a2.put("session_id", j));
        }
    }

    public final synchronized boolean c() {
        return this.f893a.a().optBoolean("first_event_done", false);
    }

    public final synchronized boolean d() {
        return this.f893a.a().optBoolean("init_event_done", false);
    }

    public final synchronized void c(int i) {
        JSONObject a2 = this.f893a.a();
        if (a2.optInt("open_id", 1) != i) {
            this.f893a.a(a2.put("open_id", i));
        }
    }

    public final synchronized int b() {
        return this.f893a.a().optInt("open_id", 1);
    }

    public final synchronized void b(int i) {
        JSONObject a2 = this.f893a.a();
        if (a2.optInt("last_migration_api_level", 0) != i) {
            this.f893a.a(a2.put("last_migration_api_level", i));
        }
        bp bpVar = this.f893a;
        bp.a(bpVar.f913a);
        bp.a(bpVar.b);
    }

    public final synchronized int a() {
        return this.f893a.a().optInt("attribution_id", 1);
    }

    public final synchronized void a(int i) {
        JSONObject a2 = this.f893a.a();
        if (a2.optInt("attribution_id", 1) == i) {
            return;
        }
        this.f893a.a(a2.put("attribution_id", i));
        bp bpVar = this.f893a;
        bp.a(bpVar.f913a);
        bp.a(bpVar.b);
    }

    public final synchronized void a(long j) {
        JSONObject a2 = this.f893a.a();
        if (a2.optLong("external_attribution_window_start", -1L) != j) {
            this.f893a.a(a2.put("external_attribution_window_start", j));
        }
        bp bpVar = this.f893a;
        bp.a(bpVar.f913a);
        bp.a(bpVar.b);
    }
}
