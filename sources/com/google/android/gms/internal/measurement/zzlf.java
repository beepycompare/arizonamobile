package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public class zzlf extends zzle {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlf(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzlg) && zzc() == ((zzlg) obj).zzc()) {
            if (zzc() == 0) {
                return true;
            }
            if (obj instanceof zzlf) {
                zzlf zzlfVar = (zzlf) obj;
                int zzi = zzi();
                int zzi2 = zzlfVar.zzi();
                if (zzi == 0 || zzi2 == 0 || zzi == zzi2) {
                    int zzc = zzc();
                    if (zzc > zzlfVar.zzc()) {
                        int zzc2 = zzc();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 18 + String.valueOf(zzc2).length());
                        sb.append("Length too large: ");
                        sb.append(zzc);
                        sb.append(zzc2);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (zzc <= zzlfVar.zzc()) {
                        if (zzlfVar instanceof zzlf) {
                            byte[] bArr = this.zza;
                            byte[] bArr2 = zzlfVar.zza;
                            zzlfVar.zzd();
                            int i = 0;
                            int i2 = 0;
                            while (i < zzc) {
                                if (bArr[i] != bArr2[i2]) {
                                    return false;
                                }
                                i++;
                                i2++;
                            }
                            return true;
                        }
                        return zzlfVar.zze(0, zzc).equals(zze(0, zzc));
                    } else {
                        int zzc3 = zzlfVar.zzc();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzc).length() + 27 + String.valueOf(zzc3).length());
                        sb2.append("Ran off end of other: 0, ");
                        sb2.append(zzc);
                        sb2.append(", ");
                        sb2.append(zzc3);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzlg zze(int i, int i2) {
        int zzj = zzj(0, i2, zzc());
        return zzj == 0 ? zzlg.zzb : new zzlb(this.zza, 0, zzj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlg
    public final void zzf(zzky zzkyVar) throws IOException {
        ((zzlj) zzkyVar).zzv(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    protected final int zzg(int i, int i2, int i3) {
        return zzmo.zzc(i, this.zza, 0, i3);
    }
}
