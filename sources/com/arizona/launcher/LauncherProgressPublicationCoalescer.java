package com.arizona.launcher;

import com.arizona.launcher.updater.apk.LauncherApkProgress;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateLifecyclePolicy.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/LauncherProgressPublicationCoalescer;", "", "minimumIntervalMillis", "", "clockMillis", "Lkotlin/Function0;", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "lock", "activeToken", "Ljava/lang/Long;", "latest", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "published", "publicationScheduled", "", "lastPublishedAtMillis", "begin", "", "token", "offer", "progress", "consumeScheduled", "replayLatest", "Lcom/arizona/launcher/LauncherProgressDispatch;", "finish", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherProgressPublicationCoalescer {
    @Deprecated
    public static final long MINIMUM_INTERVAL_MILLIS = 300;
    private Long activeToken;
    private final Function0<Long> clockMillis;
    private long lastPublishedAtMillis;
    private LauncherApkProgress latest;
    private final Object lock;
    private final long minimumIntervalMillis;
    private boolean publicationScheduled;
    private LauncherApkProgress published;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LauncherProgressPublicationCoalescer() {
        this(0L, null, 3, null);
    }

    public LauncherProgressPublicationCoalescer(long j, Function0<Long> clockMillis) {
        Intrinsics.checkNotNullParameter(clockMillis, "clockMillis");
        this.minimumIntervalMillis = j;
        this.clockMillis = clockMillis;
        this.lock = new Object();
        if (j < 0) {
            throw new IllegalArgumentException("minimumIntervalMillis must be non-negative".toString());
        }
    }

    public /* synthetic */ LauncherProgressPublicationCoalescer(long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 300L : j, (i & 2) != 0 ? new Function0() { // from class: com.arizona.launcher.LauncherProgressPublicationCoalescer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(LauncherProgressPublicationCoalescer._init_$lambda$0());
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long _init_$lambda$0() {
        return System.nanoTime() / 1000000;
    }

    public final void begin(long j) {
        synchronized (this.lock) {
            this.activeToken = Long.valueOf(j);
            this.latest = null;
            this.published = null;
            this.publicationScheduled = false;
            this.lastPublishedAtMillis = this.clockMillis.invoke().longValue();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean offer(long j, LauncherApkProgress progress) {
        boolean z;
        Intrinsics.checkNotNullParameter(progress, "progress");
        synchronized (this.lock) {
            Long l = this.activeToken;
            z = false;
            if (l != null && l.longValue() == j) {
                this.latest = progress;
                if (!this.publicationScheduled && this.clockMillis.invoke().longValue() - this.lastPublishedAtMillis >= this.minimumIntervalMillis) {
                    z = true;
                    this.publicationScheduled = true;
                }
            }
        }
        return z;
    }

    public final LauncherApkProgress consumeScheduled(long j) {
        LauncherApkProgress launcherApkProgress;
        synchronized (this.lock) {
            Long l = this.activeToken;
            launcherApkProgress = null;
            if (l != null && l.longValue() == j && this.publicationScheduled) {
                this.publicationScheduled = false;
                this.lastPublishedAtMillis = this.clockMillis.invoke().longValue();
                LauncherApkProgress launcherApkProgress2 = this.latest;
                if (launcherApkProgress2 != null) {
                    this.published = launcherApkProgress2;
                    launcherApkProgress = launcherApkProgress2;
                }
            }
        }
        return launcherApkProgress;
    }

    public final LauncherProgressDispatch replayLatest() {
        LauncherProgressDispatch launcherProgressDispatch;
        synchronized (this.lock) {
            Long l = this.activeToken;
            launcherProgressDispatch = null;
            if (l != null) {
                long longValue = l.longValue();
                LauncherApkProgress launcherApkProgress = this.latest;
                if (launcherApkProgress != null) {
                    this.publicationScheduled = false;
                    this.lastPublishedAtMillis = this.clockMillis.invoke().longValue();
                    this.published = launcherApkProgress;
                    launcherProgressDispatch = new LauncherProgressDispatch(longValue, launcherApkProgress);
                }
            }
        }
        return launcherProgressDispatch;
    }

    public final LauncherApkProgress finish(long j) {
        LauncherApkProgress launcherApkProgress;
        synchronized (this.lock) {
            Long l = this.activeToken;
            launcherApkProgress = null;
            if (l != null && l.longValue() == j) {
                LauncherApkProgress launcherApkProgress2 = this.latest;
                if (launcherApkProgress2 == null || Intrinsics.areEqual(launcherApkProgress2, this.published)) {
                    launcherApkProgress2 = null;
                }
                this.activeToken = null;
                this.latest = null;
                this.published = null;
                this.publicationScheduled = false;
                launcherApkProgress = launcherApkProgress2;
            }
        }
        return launcherApkProgress;
    }

    /* compiled from: LauncherUpdateLifecyclePolicy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/LauncherProgressPublicationCoalescer$Companion;", "", "<init>", "()V", "MINIMUM_INTERVAL_MILLIS", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
