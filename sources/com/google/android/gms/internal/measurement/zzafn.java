package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzafn implements zzaez {
    private final zzafc zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafn(zzafc zzafcVar, String str, Object[] objArr) {
        this.zza = zzafcVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 < 55296) {
                this.zzd = i | (charAt2 << i3);
                return;
            }
            i |= (charAt2 & 8191) << i3;
            i3 += 13;
            i2 = i4;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaez
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzaez
    public final zzafc zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaez
    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
