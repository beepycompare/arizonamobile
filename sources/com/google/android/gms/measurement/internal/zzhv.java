package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhv implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzhy zza;
    private final String zzb;

    public zzhv(zzhy zzhyVar, String str) {
        Objects.requireNonNull(zzhyVar);
        this.zza = zzhyVar;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzu.zzaV().zzb().zzb(this.zzb, th);
    }
}
