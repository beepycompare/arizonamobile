package com.google.android.gms.internal.measurement;

import java.io.File;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzyb extends zzyc {
    private int zzf = 0;
    private final String zzb = "com/google/android/libraries/phenotype/client/Phlogger";
    private final String zzc = "logInternal";
    private final int zzd = 44;
    private final String zze = "Phlogger.java";

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyb(String str, String str2, int i, String str3, byte[] bArr) {
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof zzyb) {
            zzyb zzybVar = (zzyb) obj;
            if (this.zzc.equals(zzybVar.zzc)) {
                int i2 = zzybVar.zzd;
                String str = this.zzb;
                String str2 = zzybVar.zzb;
                if (str != str2) {
                    if (str.length() == str2.length()) {
                        for (i = 0; i < str.length(); i = i + 1) {
                            char charAt = str.charAt(i);
                            char charAt2 = str2.charAt(i);
                            i = (charAt == charAt2 || ((charAt & 65534) == 46 && (charAt ^ charAt2) == 1)) ? i + 1 : 0;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i == 0) {
            int hashCode = ((this.zzc.hashCode() + 4867) * 31) + 44;
            this.zzf = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc
    public final String zza() {
        return this.zzb.replace('/', '.');
    }

    @Override // com.google.android.gms.internal.measurement.zzyc
    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc
    public final int zzc() {
        return 44;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc
    public final String zzd() {
        String str = this.zze;
        return str.substring(str.lastIndexOf(File.separatorChar) + 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc
    public final String zze() {
        return this.zze;
    }
}
