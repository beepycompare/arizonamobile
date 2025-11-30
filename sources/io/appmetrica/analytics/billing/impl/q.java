package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billing.internal.config.BillingConfig;
import io.appmetrica.analytics.billing.internal.config.RemoteBillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class q implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final g f221a;
    public final f b;

    public q() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final RemoteBillingConfig parse(JSONObject jSONObject) {
        s sVar;
        g gVar = this.f221a;
        this.b.getClass();
        JSONObject optJSONObject = jSONObject.optJSONObject("auto_inapp_collecting");
        if (optJSONObject == null) {
            sVar = new s();
        } else {
            s sVar2 = new s();
            Integer optIntOrNull = JsonUtils.optIntOrNull(optJSONObject, "send_frequency_seconds");
            if (optIntOrNull != null) {
                sVar2.f223a = optIntOrNull.intValue();
            }
            Integer optIntOrNull2 = JsonUtils.optIntOrNull(optJSONObject, "first_collecting_inapp_max_age_seconds");
            if (optIntOrNull2 != null) {
                sVar2.b = optIntOrNull2.intValue();
            }
            sVar = sVar2;
        }
        gVar.getClass();
        return new RemoteBillingConfig(true, new BillingConfig(sVar.f223a, sVar.b));
    }

    public final RemoteBillingConfig b(JSONObject jSONObject) {
        return (RemoteBillingConfig) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (RemoteBillingConfig) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    public q(g gVar, f fVar) {
        this.f221a = gVar;
        this.b = fVar;
    }

    public /* synthetic */ q(g gVar, f fVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new g() : gVar, (i & 2) != 0 ? new f() : fVar);
    }
}
