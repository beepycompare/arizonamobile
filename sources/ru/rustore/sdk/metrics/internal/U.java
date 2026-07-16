package ru.rustore.sdk.metrics.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.internal.W;
/* loaded from: classes6.dex */
public final class U {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final N f1572a;
    public final T b;

    public U(N persistentMetricsEventRepository, T sendMetricsEventBatchUseCase) {
        Intrinsics.checkNotNullParameter(persistentMetricsEventRepository, "persistentMetricsEventRepository");
        Intrinsics.checkNotNullParameter(sendMetricsEventBatchUseCase, "sendMetricsEventBatchUseCase");
        this.f1572a = persistentMetricsEventRepository;
        this.b = sendMetricsEventBatchUseCase;
    }

    public final void a() {
        synchronized (c) {
            while (true) {
                W a2 = this.b.a();
                if (Intrinsics.areEqual(a2, W.a.f1574a)) {
                    Unit unit = Unit.INSTANCE;
                } else if (a2 instanceof W.b) {
                    this.f1572a.a(((W.b) a2).f1575a);
                }
            }
        }
    }
}
