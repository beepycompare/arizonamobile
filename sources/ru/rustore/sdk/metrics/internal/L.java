package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final C0824t f1520a;

    public L(C0824t metricsEventSerializer) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        this.f1520a = metricsEventSerializer;
    }

    public final J a(D model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.f1510a;
        C0824t c0824t = this.f1520a;
        MetricsEvent metricsEvent = model.b;
        c0824t.getClass();
        byte[] bytes = C0824t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(str, bytes);
    }
}
