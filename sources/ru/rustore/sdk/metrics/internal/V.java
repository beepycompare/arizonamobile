package ru.rustore.sdk.metrics.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import ru.rustore.sdk.metrics.BuildConfig;
import ru.rustore.sdk.metrics.internal.presentation.SendMetricsEventJobService;
/* loaded from: classes6.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1528a;
    public final C0808d b;

    public V(Context context, C0808d getJobRepeatIntervalUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(getJobRepeatIntervalUseCase, "getJobRepeatIntervalUseCase");
        this.f1528a = context;
        this.b = getJobRepeatIntervalUseCase;
    }

    public final void a() {
        Object systemService = this.f1528a.getSystemService(JobScheduler.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService(JobScheduler::class.java)");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        Intrinsics.checkNotNullExpressionValue(allPendingJobs, "jobScheduler.allPendingJobs");
        if (!(allPendingJobs instanceof Collection) || !allPendingJobs.isEmpty()) {
            for (JobInfo jobInfo : allPendingJobs) {
                if (jobInfo.getId() == 88123556) {
                    return;
                }
            }
        }
        JobInfo.Builder builder = new JobInfo.Builder(88123556, new ComponentName(this.f1528a, SendMetricsEventJobService.class));
        this.b.f1538a.f1542a.getClass();
        Duration.Companion companion = Duration.Companion;
        Integer JOB_REPEAT_INTERVAL_MINUTES = BuildConfig.JOB_REPEAT_INTERVAL_MINUTES;
        Intrinsics.checkNotNullExpressionValue(JOB_REPEAT_INTERVAL_MINUTES, "JOB_REPEAT_INTERVAL_MINUTES");
        jobScheduler.schedule(builder.setPeriodic(Duration.m11307getInWholeMillisecondsimpl(DurationKt.toDuration(JOB_REPEAT_INTERVAL_MINUTES.intValue(), DurationUnit.MINUTES))).setPersisted(true).build());
    }
}
