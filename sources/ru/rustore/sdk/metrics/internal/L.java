package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final C0841t f1434a;

    public L(C0841t metricsEventSerializer) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        this.f1434a = metricsEventSerializer;
    }

    public final J a(D model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.f1424a;
        C0841t c0841t = this.f1434a;
        MetricsEvent metricsEvent = model.b;
        c0841t.getClass();
        byte[] bytes = C0841t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(str, bytes);
    }
}
