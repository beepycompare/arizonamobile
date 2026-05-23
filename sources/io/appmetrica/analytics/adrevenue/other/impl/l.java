package io.appmetrica.analytics.adrevenue.other.impl;

import io.appmetrica.analytics.adrevenue.other.internal.ServiceSideAdRevenueOtherConfigWrapper;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final a f242a;

    public l() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final ServiceSideAdRevenueOtherConfigWrapper parse(JSONObject jSONObject) {
        this.f242a.getClass();
        return ServiceSideAdRevenueOtherConfigWrapper.Companion.toWrapper$ad_revenue_other_release(new j(RemoteConfigJsonUtils.extractFeature(jSONObject, "ad_revenue_other", f.f237a), RemoteConfigJsonUtils.extractFeature(jSONObject, "ad_revenue_other_include_source", f.b)));
    }

    public final ServiceSideAdRevenueOtherConfigWrapper b(JSONObject jSONObject) {
        return (ServiceSideAdRevenueOtherConfigWrapper) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (ServiceSideAdRevenueOtherConfigWrapper) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    public l(a aVar) {
        this.f242a = aVar;
    }

    public /* synthetic */ l(a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new a() : aVar);
    }
}
