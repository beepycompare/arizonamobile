package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import io.appmetrica.analytics.screenshot.internal.ServiceSideScreenshotConfigWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class S implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final E f1443a;

    public S() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.ArrayList] */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final ServiceSideScreenshotConfigWrapper parse(JSONObject jSONObject) {
        N n;
        U u;
        P p;
        ?? list;
        E e = this.f1443a;
        e.getClass();
        boolean extractFeature = RemoteConfigJsonUtils.extractFeature(jSONObject, "screenshot", AbstractC0791m.f1453a);
        JSONObject optJSONObject = jSONObject.optJSONObject("screenshot");
        if (optJSONObject == null) {
            p = new P(extractFeature, new N(new w().f1461a), new U(), new O());
        } else {
            e.f1432a.getClass();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("api_captor_config");
            O o = null;
            if (optJSONObject2 == null) {
                n = null;
            } else {
                w wVar = new w();
                Boolean optBooleanOrNull = JsonUtils.optBooleanOrNull(optJSONObject2, "enabled");
                n = new N(optBooleanOrNull != null ? optBooleanOrNull.booleanValue() : wVar.f1461a);
            }
            if (n == null) {
                n = new N(new w().f1461a);
            }
            e.b.getClass();
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("service_captor_config");
            if (optJSONObject3 == null) {
                u = null;
            } else {
                y yVar = new y();
                Boolean optBooleanOrNull2 = JsonUtils.optBooleanOrNull(optJSONObject3, "enabled");
                boolean booleanValue = optBooleanOrNull2 != null ? optBooleanOrNull2.booleanValue() : yVar.f1463a;
                Long optLongOrNull = JsonUtils.optLongOrNull(optJSONObject3, "delay_seconds");
                u = new U(booleanValue, optLongOrNull != null ? optLongOrNull.longValue() : yVar.b);
            }
            if (u == null) {
                u = new U();
            }
            e.c.getClass();
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("content_observer_captor_config");
            if (optJSONObject4 != null) {
                x xVar = new x();
                Boolean optBooleanOrNull3 = JsonUtils.optBooleanOrNull(optJSONObject4, "enabled");
                boolean booleanValue2 = optBooleanOrNull3 != null ? optBooleanOrNull3.booleanValue() : xVar.f1462a;
                JSONArray optJSONArray = optJSONObject4.optJSONArray("media_store_column_names");
                if (optJSONArray != null) {
                    IntRange until = RangesKt.until(0, optJSONArray.length());
                    list = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                    Iterator<Integer> it = until.iterator();
                    while (it.hasNext()) {
                        list.add(optJSONArray.getString(((IntIterator) it).nextInt()));
                    }
                } else {
                    list = ArraysKt.toList(xVar.c);
                }
                Long optLongOrNull2 = JsonUtils.optLongOrNull(optJSONObject4, "detect_window_seconds");
                o = new O(booleanValue2, list, optLongOrNull2 != null ? optLongOrNull2.longValue() : xVar.b);
            }
            if (o == null) {
                o = new O();
            }
            p = new P(extractFeature, n, u, o);
        }
        return ServiceSideScreenshotConfigWrapper.Companion.toWrapper$screenshot_release(p);
    }

    public final ServiceSideScreenshotConfigWrapper b(JSONObject jSONObject) {
        return (ServiceSideScreenshotConfigWrapper) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (ServiceSideScreenshotConfigWrapper) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    public S(E e) {
        this.f1443a = e;
    }

    public /* synthetic */ S(E e, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new E() : e);
    }
}
