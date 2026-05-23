package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmn implements zzmj {
    private final zzkk zza;

    public zzmn(zzkk zzkkVar) {
        Preconditions.checkNotNull(zzkkVar);
        this.zza = zzkkVar;
    }

    private static ListenableFuture zzf(Task task) {
        return Futures.catchingAsync(zzlb.zza(task, null), ApiException.class, zzml.zza, MoreExecutors.directExecutor());
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zza(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull("");
        return zzf(this.zza.zzb(str, "", null).continueWith(MoreExecutors.directExecutor(), new Continuation(this) { // from class: com.google.android.gms.internal.measurement.zzmm
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                zzjf[] zzjfVarArr;
                zzjo[] zzjoVarArr;
                zzadu zzbd;
                zzjh zzjhVar = (zzjh) task.getResult();
                zzmf zzh = zzmg.zzh();
                zzh.zza(zzjhVar.zza);
                zzh.zzc(zzjhVar.zzc);
                zzh.zzf(zzjhVar.zzf);
                zzh.zzg(zzjhVar.zzg);
                byte[] bArr = zzjhVar.zzb;
                if (bArr != null) {
                    zzh.zzb(zzacr.zzj(bArr, 0, bArr.length));
                }
                for (zzjf zzjfVar : zzjhVar.zzd) {
                    for (zzjo zzjoVar : zzjfVar.zzb) {
                        int i = zzjoVar.zzg;
                        if (i == 1) {
                            zzmh zzh2 = zzmi.zzh();
                            zzh2.zza(zzjoVar.zza);
                            zzh2.zzb(zzjoVar.zza());
                            zzbd = zzh2.zzbd();
                        } else if (i == 2) {
                            zzmh zzh3 = zzmi.zzh();
                            zzh3.zza(zzjoVar.zza);
                            zzh3.zzc(zzjoVar.zzb());
                            zzbd = zzh3.zzbd();
                        } else if (i == 3) {
                            zzmh zzh4 = zzmi.zzh();
                            zzh4.zza(zzjoVar.zza);
                            zzh4.zzd(zzjoVar.zzc());
                            zzbd = zzh4.zzbd();
                        } else if (i == 4) {
                            zzmh zzh5 = zzmi.zzh();
                            zzh5.zza(zzjoVar.zza);
                            zzh5.zze(zzjoVar.zzd());
                            zzbd = zzh5.zzbd();
                        } else if (i == 5) {
                            zzmh zzh6 = zzmi.zzh();
                            zzh6.zza(zzjoVar.zza);
                            byte[] zze = zzjoVar.zze();
                            zzacr zzacrVar = zzacr.zza;
                            zzh6.zzf(zzacr.zzj(zze, 0, zze.length));
                            zzbd = zzh6.zzbd();
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 24);
                            sb.append("Unrecognized flag type: ");
                            sb.append(i);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        zzh.zzd((zzmi) zzbd);
                    }
                    String[] strArr = zzjfVar.zzc;
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            zzh.zze(str3);
                        }
                    }
                }
                return (zzmg) zzh.zzbd();
            }
        }));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzb(String str) {
        Preconditions.checkNotNull(str);
        return zzf(this.zza.zzc(str));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzc(zzme zzmeVar) {
        return zzf(this.zza.zzd(zzmeVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zzd() {
        return zzf(this.zza.zze());
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final ListenableFuture zze(zzpm zzpmVar) {
        return zzf(this.zza.zzf(zzpmVar));
    }
}
