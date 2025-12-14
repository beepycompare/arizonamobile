package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.internal.X;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* renamed from: ru.rustore.sdk.metrics.internal.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0823n {

    /* renamed from: a  reason: collision with root package name */
    public final U f1605a;
    public final C0812c b;
    public final V c;
    public final Dispatcher d;
    public final InterfaceC0816g e;
    public boolean f;

    public C0823n(U sendMetricsEventInteractor, C0812c enqueueMetricsEventUseCase, V sendMetricsEventJobScheduler, Z singleThreadDispatcher, X.b logger) {
        Intrinsics.checkNotNullParameter(sendMetricsEventInteractor, "sendMetricsEventInteractor");
        Intrinsics.checkNotNullParameter(enqueueMetricsEventUseCase, "enqueueMetricsEventUseCase");
        Intrinsics.checkNotNullParameter(sendMetricsEventJobScheduler, "sendMetricsEventJobScheduler");
        Intrinsics.checkNotNullParameter(singleThreadDispatcher, "singleThreadDispatcher");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1605a = sendMetricsEventInteractor;
        this.b = enqueueMetricsEventUseCase;
        this.c = sendMetricsEventJobScheduler;
        this.d = singleThreadDispatcher;
        this.e = logger;
    }
}
