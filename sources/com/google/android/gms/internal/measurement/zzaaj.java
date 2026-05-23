package com.google.android.gms.internal.measurement;

import android.os.Build;
import dalvik.system.VMStack;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaaj extends zzaad {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzaac zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
    /* loaded from: classes4.dex */
    public final class zza {
        zza() {
        }

        static boolean zza() {
            return zzaaj.zzp();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzaac() { // from class: com.google.android.gms.internal.measurement.zzaaj.1
            @Override // com.google.android.gms.internal.measurement.zzaac
            public String zza(Class<? extends zzxi<?>> cls) {
                StackTraceElement zza2;
                if (zzaaj.zza) {
                    try {
                        if (cls.equals(zzaaj.zzr())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzaaj.zzb || (zza2 = zzabq.zza(cls, 1)) == null) {
                    return null;
                }
                return zza2.getClassName();
            }

            @Override // com.google.android.gms.internal.measurement.zzaac
            public zzyc zzb(Class<?> cls, int i) {
                return zzyc.zza;
            }
        };
    }

    static boolean zzp() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> zzr() {
        return VMStack.getStackClass2();
    }

    @Override // com.google.android.gms.internal.measurement.zzaad
    protected zzaac zzc() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzaad
    protected zzzf zze(String str) {
        return zzaao.zze(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzaad
    protected zzaat zzg() {
        return zzaap.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzaad
    protected String zzn() {
        return "platform: Android";
    }
}
