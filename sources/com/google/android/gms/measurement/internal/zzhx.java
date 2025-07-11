package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhx extends Thread {
    final /* synthetic */ zzhy zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd;

    public zzhx(zzhy zzhyVar, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(zzhyVar);
        this.zza = zzhyVar;
        this.zzd = false;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        zzhy zzhyVar = this.zza;
        synchronized (zzhyVar.zzr()) {
            if (!this.zzd) {
                zzhyVar.zzs().release();
                zzhyVar.zzr().notifyAll();
                if (this == zzhyVar.zzn()) {
                    zzhyVar.zzo(null);
                } else if (this != zzhyVar.zzp()) {
                    zzhyVar.zzu.zzaV().zzb().zza("Current scheduler thread is neither worker nor network");
                } else {
                    zzhyVar.zzq(null);
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        zzgr zze = this.zza.zzu.zzaV().zze();
        String name = getName();
        String.valueOf(name);
        zze.zzb(String.valueOf(name).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzs().acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.zzc;
                zzhw zzhwVar = (zzhw) blockingQueue.poll();
                if (zzhwVar != null) {
                    Process.setThreadPriority(true != zzhwVar.zza ? 10 : threadPriority);
                    zzhwVar.run();
                } else {
                    Object obj = this.zzb;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.zza.zzt();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    synchronized (this.zza.zzr()) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        Object obj = this.zzb;
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
