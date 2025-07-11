package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzco extends zzct {
    private final AtomicReference zza = new AtomicReference();
    private boolean zzb;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
        r2 = r2.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object zzf(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", cls.getCanonicalName(), obj.getClass().getCanonicalName()), e);
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcu
    public final void zzb(Bundle bundle) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                atomicReference.set(bundle);
                this.zzb = true;
                this.zza.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String zzc(long j) {
        return (String) zzf(zze(j), String.class);
    }

    public final Long zzd(long j) {
        return (Long) zzf(zze(j), Long.class);
    }

    public final Bundle zze(long j) {
        Bundle bundle;
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            if (!this.zzb) {
                try {
                    atomicReference.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.zza.get();
        }
        return bundle;
    }
}
