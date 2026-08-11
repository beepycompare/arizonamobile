package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* renamed from: ru.rustore.sdk.appupdate.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0793n {

    /* renamed from: a  reason: collision with root package name */
    public final C0789j f1492a;
    public final MetricsClient b;

    public C0793n(C0789j mapper, MetricsClient metricsClient) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(metricsClient, "metricsClient");
        this.f1492a = mapper;
        this.b = metricsClient;
    }
}
