package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* renamed from: ru.rustore.sdk.appupdate.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0810n {

    /* renamed from: a  reason: collision with root package name */
    public final C0806j f1406a;
    public final MetricsClient b;

    public C0810n(C0806j mapper, MetricsClient metricsClient) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(metricsClient, "metricsClient");
        this.f1406a = mapper;
        this.b = metricsClient;
    }
}
