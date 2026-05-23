package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* renamed from: ru.rustore.sdk.appupdate.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0813n {

    /* renamed from: a  reason: collision with root package name */
    public final C0809j f1534a;
    public final MetricsClient b;

    public C0813n(C0809j mapper, MetricsClient metricsClient) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(metricsClient, "metricsClient");
        this.f1534a = mapper;
        this.b = metricsClient;
    }
}
