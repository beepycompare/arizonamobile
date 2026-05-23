package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzhk {
    final zzic zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhk(zzpg zzpgVar) {
        this.zza = zzpgVar.zzah();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        try {
            zzic zzicVar = this.zza;
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzicVar.zzaZ());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            zzicVar.zzaW().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.zza.zzaW().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
