package ru.rustore.sdk.metrics.internal;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Dispatcher;
import ru.rustore.sdk.reactive.core.Disposable;
/* loaded from: classes5.dex */
public final class Z implements Dispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1427a = new ScheduledThreadPoolExecutor(1);

    /* loaded from: classes5.dex */
    public static final class a implements Disposable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicBoolean f1428a = new AtomicBoolean();
        public final /* synthetic */ ScheduledFuture<?> b;

        public a(ScheduledFuture<?> scheduledFuture) {
            this.b = scheduledFuture;
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public final void dispose() {
            if (this.f1428a.compareAndSet(false, true)) {
                this.b.cancel(false);
            }
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public final boolean isDisposed() {
            return this.f1428a.get();
        }
    }

    public static final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // ru.rustore.sdk.reactive.core.Dispatcher
    public final void execute(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.f1427a.submit(new Runnable() { // from class: ru.rustore.sdk.metrics.internal.Z$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Z.a(Function0.this);
            }
        });
    }

    @Override // ru.rustore.sdk.reactive.core.Dispatcher
    public final Disposable executeDelayed(long j, TimeUnit timeUnit, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(block, "block");
        return new a(this.f1427a.schedule(new Runnable() { // from class: ru.rustore.sdk.metrics.internal.Z$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Z.b(Function0.this);
            }
        }, j, timeUnit));
    }
}
