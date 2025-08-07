package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* renamed from: ru.rustore.sdk.appupdate.n  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0808n {

    /* renamed from: a  reason: collision with root package name */
    public final C0804j f1386a;
    public final MetricsClient b;

    public C0808n(C0804j mapper, MetricsClient metricsClient) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(metricsClient, "metricsClient");
        this.f1386a = mapper;
        this.b = metricsClient;
    }
}
