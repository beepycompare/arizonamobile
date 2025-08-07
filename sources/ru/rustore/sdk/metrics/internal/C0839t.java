package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ru.rustore.sdk.metrics.MetricsEvent;
/* renamed from: ru.rustore.sdk.metrics.internal.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0839t {
    public static String a(MetricsEvent model) {
        Intrinsics.checkNotNullParameter(model, "model");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", model.getEventName());
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : model.getEventData().entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put("data", jSONObject2);
        jSONObject.put("time", model.getEventTime$sdk_public_metrics_release());
        String jSONObject3 = jSONObject.toString(0);
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString(0)");
        return jSONObject3;
    }
}
