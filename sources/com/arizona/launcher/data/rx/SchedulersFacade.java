package com.arizona.launcher.data.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SchedulersFacade.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/data/rx/SchedulersFacade;", "", "<init>", "()V", "ui", "Lio/reactivex/Scheduler;", "io", "computation", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
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
