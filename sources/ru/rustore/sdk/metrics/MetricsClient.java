package ru.rustore.sdk.metrics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.internal.C0830m;
import ru.rustore.sdk.metrics.internal.C0831n;
import ru.rustore.sdk.metrics.internal.X;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u000e"}, d2 = {"Lru/rustore/sdk/metrics/MetricsClient;", "", "Lru/rustore/sdk/metrics/internal/n;", "metricsClientController", "<init>", "(Lru/rustore/sdk/metrics/internal/n;)V", "Lru/rustore/sdk/metrics/MetricsEvent;", "metricsEvent", "Lru/rustore/sdk/reactive/single/Single;", "", "send", "(Lru/rustore/sdk/metrics/MetricsEvent;)Lru/rustore/sdk/reactive/single/Single;", "Lru/rustore/sdk/metrics/internal/n;", "Companion", "sdk-public-metrics_release"}, k = 1, mv = {1, 7, 0})
/* loaded from: classes6.dex */
public final class MetricsClient {
    public static final Companion Companion = new Companion(null);
    private final C0831n metricsClientController;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lru/rustore/sdk/metrics/MetricsClient$Companion;", "", "()V", "getInstance", "Lru/rustore/sdk/metrics/MetricsClient;", "context", "Landroid/content/Context;", "sdk-public-metrics_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public final MetricsClient getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return X.c.a(context).b;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MetricsClient(C0831n metricsClientController) {
        Intrinsics.checkNotNullParameter(metricsClientController, "metricsClientController");
        this.metricsClientController = metricsClientController;
    }

    public final Single<Unit> send(MetricsEvent metricsEvent) {
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        C0831n c0831n = this.metricsClientController;
        c0831n.getClass();
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        return SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0830m(c0831n, metricsEvent)), c0831n.d);
    }
}
