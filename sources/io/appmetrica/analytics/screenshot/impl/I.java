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
/* loaded from: classes4.dex */
public final class I implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public final V f1274a;
    public final U b;

    public I() {
        this(null, null, 3, null);
    }

    public final G b(JSONObject jSONObject) {
        return (G) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return (G) JsonParser.DefaultImpls.parseOrNull(this, jSONObject);
    }

    public I(V v, U u) {
        this.f1274a = v;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    /* renamed from: a */
    public final G parse(JSONObject jSONObject) {
        K k;
        M m;
        N n;
        boolean z = AbstractC0787n.f1306a;
        boolean extractFeature = RemoteConfigJsonUtils.extractFeature(jSONObject, "screenshot", AbstractC0787n.f1306a);
        V v = this.f1274a;
        U u = this.b;
        u.getClass();
        JSONObject optJSONObject = jSONObject.optJSONObject("screenshot");
        if (optJSONObject == null) {
            n = new N();
            n.f1279a = new K();
            n.b = new M();
            L l = new L();
            l.c = AbstractC0787n.b;
            n.c = l;
        } else {
            N n2 = new N();
            u.f1283a.getClass();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("api_captor_config");
            L l2 = null;
            if (optJSONObject2 == null) {
                k = null;
            } else {
                k = new K();
                Boolean optBooleanOrNull = JsonUtils.optBooleanOrNull(optJSONObject2, "enabled");
                if (optBooleanOrNull != null) {
                    k.f1276a = optBooleanOrNull.booleanValue();
                }
            }
            if (k != null) {
                n2.f1279a = k;
            }
            u.b.getClass();
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("service_captor_config");
            if (optJSONObject3 == null) {
                m = null;
            } else {
                m = new M();
                Boolean optBooleanOrNull2 = JsonUtils.optBooleanOrNull(optJSONObject3, "enabled");
                if (optBooleanOrNull2 != null) {
                    m.f1278a = optBooleanOrNull2.booleanValue();
                }
                Long optLongOrNull = JsonUtils.optLongOrNull(optJSONObject3, "delay_seconds");
                if (optLongOrNull != null) {
                    m.b = optLongOrNull.longValue();
                }
            }
            if (m != null) {
                n2.b = m;
            }
            u.c.getClass();
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("content_observer_captor_config");
            if (optJSONObject4 != null) {
                l2 = new L();
                Boolean optBooleanOrNull3 = JsonUtils.optBooleanOrNull(optJSONObject4, "enabled");
                if (optBooleanOrNull3 != null) {
                    l2.f1277a = optBooleanOrNull3.booleanValue();
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
                        l2.c = (String[]) array;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                }
                Long optLongOrNull2 = JsonUtils.optLongOrNull(optJSONObject4, "detect_window_seconds");
                if (optLongOrNull2 != null) {
                    l2.b = optLongOrNull2.longValue();
                }
            }
            if (l2 != null) {
                n2.c = l2;
            }
            n = n2;
        }
        return new G(extractFeature, v.toModel(n));
    }

    public /* synthetic */ I(V v, U u, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new V(null, null, null, 7, null) : v, (i & 2) != 0 ? new U() : u);
    }
}
