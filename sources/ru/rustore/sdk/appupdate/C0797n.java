package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* renamed from: ru.rustore.sdk.appupdate.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0797n {

    /* renamed from: a  reason: collision with root package name */
    public final C0793j f1548a;
    public final MetricsClient b;

    public C0797n(C0793j mapper, MetricsClient metricsClient) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(metricsClient, "metricsClient");
        this.f1548a = mapper;
        this.b = metricsClient;
    }
}
