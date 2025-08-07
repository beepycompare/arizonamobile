package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes5.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final C0839t f1414a;

    public L(C0839t metricsEventSerializer) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        this.f1414a = metricsEventSerializer;
    }

    public final J a(D model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String str = model.f1404a;
        C0839t c0839t = this.f1414a;
        MetricsEvent metricsEvent = model.b;
        c0839t.getClass();
        byte[] bytes = C0839t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(str, bytes);
    }
}
