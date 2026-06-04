package com.arizona.launcher.data.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SchedulersFacade.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\b\u0007\u001a\u0002\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006Ê\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/data/rx/SchedulersFacade;", "", "<init>", "()V", "Ljavax/inject/Inject;", "ui", "Lio/reactivex/Scheduler;", "io", "computation", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SchedulersFacade {
    public static final int $stable = 0;

    public final Scheduler ui() {
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread(...)");
        return mainThread;
    }

    public final Scheduler io() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io(...)");
        return io2;
    }

    public final Scheduler computation() {
        Scheduler computation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation, "computation(...)");
        return computation;
    }
}
