package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.internal.X;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* renamed from: ru.rustore.sdk.metrics.internal.n  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0839n {

    /* renamed from: a  reason: collision with root package name */
    public final U f1594a;
    public final C0828c b;
    public final V c;
    public final Dispatcher d;
    public final InterfaceC0832g e;
    public boolean f;

    public C0839n(U sendMetricsEventInteractor, C0828c enqueueMetricsEventUseCase, V sendMetricsEventJobScheduler, Z singleThreadDispatcher, X.b logger) {
        Intrinsics.checkNotNullParameter(sendMetricsEventInteractor, "sendMetricsEventInteractor");
        Intrinsics.checkNotNullParameter(enqueueMetricsEventUseCase, "enqueueMetricsEventUseCase");
        Intrinsics.checkNotNullParameter(sendMetricsEventJobScheduler, "sendMetricsEventJobScheduler");
        Intrinsics.checkNotNullParameter(singleThreadDispatcher, "singleThreadDispatcher");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1594a = sendMetricsEventInteractor;
        this.b = enqueueMetricsEventUseCase;
        this.c = sendMetricsEventJobScheduler;
        this.d = singleThreadDispatcher;
        this.e = logger;
    }
}
