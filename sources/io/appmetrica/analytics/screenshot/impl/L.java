package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class L implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1341a;
    public final X b;

    public L() {
        this(null, null, 3, null);
    }

    public final J b(JSONObject jSONObject) {
        return (J) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (J) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    public L(Y y, X x) {
        this.f1341a = y;
        this.b = x;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final J parse(JSONObject jSONObject) {
        N n;
        P p;
        Q q;
        boolean z = AbstractC0773o.f1373a;
        boolean extractFeature = RemoteConfigJsonUtils.extractFeature(jSONObject, "screenshot", AbstractC0773o.f1373a);
        Y y = this.f1341a;
        X x = this.b;
        x.getClass();
        JSONObject optJSONObject = jSONObject.optJSONObject("screenshot");
        if (optJSONObject == null) {
            q = new Q();
            q.f1346a = new N();
            q.b = new P();
            O o = new O();
            o.c = AbstractC0773o.b;
            q.c = o;
        } else {
            Q q2 = new Q();
            x.f1350a.getClass();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("api_captor_config");
            O o2 = null;
            if (optJSONObject2 == null) {
                n = null;
            } else {
                n = new N();
                Boolean optBooleanOrNull = JsonUtils.optBooleanOrNull(optJSONObject2, "enabled");
                if (optBooleanOrNull != null) {
                    n.f1343a = optBooleanOrNull.booleanValue();
                }
            }
            if (n != null) {
                q2.f1346a = n;
            }
            x.b.getClass();
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("service_captor_config");
            if (optJSONObject3 == null) {
                p = null;
            } else {
                p = new P();
                Boolean optBooleanOrNull2 = JsonUtils.optBooleanOrNull(optJSONObject3, "enabled");
                if (optBooleanOrNull2 != null) {
                    p.f1345a = optBooleanOrNull2.booleanValue();
                }
                Long optLongOrNull = JsonUtils.optLongOrNull(optJSONObject3, "delay_seconds");
                if (optLongOrNull != null) {
                    p.b = optLongOrNull.longValue();
                }
            }
            if (p != null) {
                q2.b = p;
            }
            x.c.getClass();
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("content_observer_captor_config");
            if (optJSONObject4 != null) {
                o2 = new O();
                Boolean optBooleanOrNull3 = JsonUtils.optBooleanOrNull(optJSONObject4, "enabled");
                if (optBooleanOrNull3 != null) {
                    o2.f1344a = optBooleanOrNull3.booleanValue();
                }
                JSONArray optJSONArray = optJSONObject4.optJSONArray("media_store_column_names");
                if (optJSONArray != null) {
                    IntRange until = RangesKt.until(0, optJSONArray.length());
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                    Iterator<Integer> it = until.iterator();
                    while (it.hasNext()) {
                        arrayList.add(optJSONArray.getString(((IntIterator) it).nextInt()));
                    }
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array != null) {
                        o2.c = (String[]) array;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                }
                Long optLongOrNull2 = JsonUtils.optLongOrNull(optJSONObject4, "detect_window_seconds");
                if (optLongOrNull2 != null) {
                    o2.b = optLongOrNull2.longValue();
                }
            }
            if (o2 != null) {
                q2.c = o2;
            }
            q = q2;
        }
        return new J(extractFeature, y.toModel(q));
    }

    public /* synthetic */ L(Y y, X x, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Y(null, null, null, 7, null) : y, (i & 2) != 0 ? new X() : x);
    }
}
