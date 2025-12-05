package ru.rustore.sdk.metrics.internal.presentation;

import android.app.job.JobParameters;
import android.app.job.JobService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.internal.X;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleDoOnDisposeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/rustore/sdk/metrics/internal/presentation/SendMetricsEventJobService;", "Landroid/app/job/JobService;", "<init>", "()V", "sdk-public-metrics_release"}, k = 1, mv = {1, 7, 0})
/* loaded from: classes6.dex */
public final class SendMetricsEventJobService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f1594a = LazyKt.lazy(new a());
    public Disposable b;
    public volatile boolean c;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<X> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final X invoke() {
            return X.c.a(SendMetricsEventJobService.this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((X) SendMetricsEventJobService.this.f1594a.getValue()).f1573a.a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(JobParameters jobParameters) {
            super(0);
            this.b = jobParameters;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            SendMetricsEventJobService.a(SendMetricsEventJobService.this, this.b);
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(JobParameters jobParameters) {
            super(1);
            this.b = jobParameters;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
            SendMetricsEventJobService.a(SendMetricsEventJobService.this, this.b);
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(JobParameters jobParameters) {
            super(1);
            this.b = jobParameters;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            Unit it = unit;
            Intrinsics.checkNotNullParameter(it, "it");
            SendMetricsEventJobService.a(SendMetricsEventJobService.this, this.b);
            return Unit.INSTANCE;
        }
    }

    public static final void a(SendMetricsEventJobService sendMetricsEventJobService, JobParameters jobParameters) {
        if (sendMetricsEventJobService.c) {
            return;
        }
        sendMetricsEventJobService.jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.b = SingleSubscribeKt.subscribe(SingleDoOnDisposeKt.doOnDispose(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new b()), Dispatchers.INSTANCE.getIo()), new c(params)), new d(params), new e(params));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        this.c = true;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        return true;
    }
}
