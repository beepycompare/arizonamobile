package ru.rustore.sdk.metrics.internal;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class K {

    /* renamed from: a  reason: collision with root package name */
    public final C0844t f1562a;
    public final c0 b;

    public K(C0844t metricsEventSerializer, c0 uuidFactory) {
        Intrinsics.checkNotNullParameter(metricsEventSerializer, "metricsEventSerializer");
        Intrinsics.checkNotNullParameter(uuidFactory, "uuidFactory");
        this.f1562a = metricsEventSerializer;
        this.b = uuidFactory;
    }

    public final J a(MetricsEvent metricsEvent) {
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        this.b.getClass();
        String value = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(value, "randomUUID().toString()");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f1562a.getClass();
        byte[] bytes = C0844t.a(metricsEvent).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new J(value, bytes);
    }
}
