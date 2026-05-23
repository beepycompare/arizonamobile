package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhx extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzhz zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhx(zzhz zzhzVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        Objects.requireNonNull(zzhzVar);
        this.zzb = zzhzVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzhz.zzj;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzhzVar.zzu.zzaW().zzb().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhx zzhxVar = (zzhx) obj;
        boolean z = zzhxVar.zza;
        boolean z2 = this.zza;
        if (z2 != z) {
            return !z2 ? 1 : -1;
        }
        long j = this.zzc;
        int i = (j > zzhxVar.zzc ? 1 : (j == zzhxVar.zzc ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        this.zzb.zzu.zzaW().zzc().zzb("Two tasks share the same index. index", Long.valueOf(j));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzu.zzaW().zzb().zzb(this.zzd, th);
        if ((th instanceof zzhv) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhx(zzhz zzhzVar, Callable callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        Objects.requireNonNull(zzhzVar);
        this.zzb = zzhzVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        atomicLong = zzhz.zzj;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzhzVar.zzu.zzaW().zzb().zza("Tasks index overflow");
        }
    }
}
