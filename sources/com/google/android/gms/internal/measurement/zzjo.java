package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzjo extends AbstractSafeParcelable implements Comparable<zzjo> {
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjp();
    public final String zza;
    final long zzb;
    final boolean zzc;
    final double zzd;
    @Nullable
    final String zze;
    @Nullable
    final byte[] zzf;
    public final int zzg;
    public final int zzh;
    private final int zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(String str, long j, boolean z, double d, @Nullable String str2, @Nullable byte[] bArr, int i, int i2, int i3) {
        this.zza = str;
        this.zzb = j;
        this.zzc = z;
        this.zzd = d;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = i3;
    }

    private static int zzg(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i != i2 ? 1 : 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(zzjo zzjoVar) {
        zzjo zzjoVar2 = zzjoVar;
        int compareTo = this.zza.compareTo(zzjoVar2.zza);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = this.zzg;
        int zzg = zzg(i, zzjoVar2.zzg);
        if (zzg != 0) {
            return zzg;
        }
        int i2 = 0;
        if (i == 1) {
            int i3 = (this.zzb > zzjoVar2.zzb ? 1 : (this.zzb == zzjoVar2.zzb ? 0 : -1));
            if (i3 < 0) {
                return -1;
            }
            return i3 == 0 ? 0 : 1;
        } else if (i == 2) {
            boolean z = this.zzc;
            if (z == zzjoVar2.zzc) {
                return 0;
            }
            return z ? 1 : -1;
        } else if (i == 3) {
            return Double.compare(this.zzd, zzjoVar2.zzd);
        } else {
            if (i == 4) {
                String str = this.zze;
                String str2 = zzjoVar2.zze;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            } else if (i == 5) {
                byte[] bArr = this.zzf;
                byte[] bArr2 = zzjoVar2.zzf;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                while (true) {
                    int length = bArr2.length;
                    int length2 = bArr.length;
                    if (i2 >= Math.min(length2, length)) {
                        return zzg(length2, length);
                    }
                    int i4 = bArr[i2] - bArr2[i2];
                    if (i4 != 0) {
                        return i4;
                    }
                    i2++;
                }
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                sb.append("Invalid enum value: ");
                sb.append(i);
                throw new AssertionError(sb.toString());
            }
        }
    }

    public final boolean equals(@Nullable Object obj) {
        int i;
        if (obj instanceof zzjo) {
            zzjo zzjoVar = (zzjo) obj;
            if (zzkl.zza(this.zza, zzjoVar.zza) && (i = this.zzg) == zzjoVar.zzg && this.zzh == zzjoVar.zzh && this.zzi == zzjoVar.zzi) {
                if (i == 1) {
                    return this.zzb == zzjoVar.zzb;
                } else if (i == 2) {
                    return this.zzc == zzjoVar.zzc;
                } else if (i == 3) {
                    return this.zzd == zzjoVar.zzd;
                } else if (i != 4) {
                    if (i == 5) {
                        return Arrays.equals(this.zzf, zzjoVar.zzf);
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                    sb.append("Invalid enum value: ");
                    sb.append(i);
                    throw new AssertionError(sb.toString());
                } else {
                    return zzkl.zza(this.zze, zzjoVar.zze);
                }
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zzf(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        boolean zzb = zzjp.zzb(str);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zzb) {
            SafeParcelWriter.writeString(parcel, 2, str, false);
        }
        long j = this.zzb;
        if (j != 0) {
            SafeParcelWriter.writeLong(parcel, 3, j);
        }
        if (this.zzc) {
            SafeParcelWriter.writeBoolean(parcel, 4, true);
        }
        double d = this.zzd;
        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            SafeParcelWriter.writeDouble(parcel, 5, d);
        }
        String str2 = this.zze;
        if (!zzjp.zzb(str2)) {
            SafeParcelWriter.writeString(parcel, 6, str2, false);
        }
        byte[] bArr = this.zzf;
        if (!zzjp.zzb(bArr)) {
            SafeParcelWriter.writeByteArray(parcel, 7, bArr, false);
        }
        int i2 = this.zzg;
        if (!zzjp.zza(i2)) {
            SafeParcelWriter.writeInt(parcel, 8, i2);
        }
        int i3 = this.zzh;
        if (!zzjp.zza(i3)) {
            SafeParcelWriter.writeInt(parcel, 9, i3);
        }
        int i4 = this.zzi;
        if (!zzjp.zza(i4)) {
            SafeParcelWriter.writeInt(parcel, 10, i4);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zza() {
        if (this.zzg == 1) {
            return this.zzb;
        }
        throw new IllegalArgumentException("Not a long type");
    }

    public final boolean zzb() {
        if (this.zzg == 2) {
            return this.zzc;
        }
        throw new IllegalArgumentException("Not a boolean type");
    }

    public final double zzc() {
        if (this.zzg == 3) {
            return this.zzd;
        }
        throw new IllegalArgumentException("Not a double type");
    }

    public final String zzd() {
        if (this.zzg != 4) {
            throw new IllegalArgumentException("Not a String type");
        }
        return (String) Preconditions.checkNotNull(this.zze);
    }

    public final byte[] zze() {
        if (this.zzg != 5) {
            throw new IllegalArgumentException("Not a bytes type");
        }
        return (byte[]) Preconditions.checkNotNull(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(StringBuilder sb) {
        sb.append("Flag(");
        String str = this.zza;
        sb.append(str);
        sb.append(", ");
        int i = this.zzg;
        if (i == 1) {
            sb.append(this.zzb);
        } else if (i == 2) {
            sb.append(this.zzc);
        } else if (i == 3) {
            sb.append(this.zzd);
        } else if (i == 4) {
            sb.append("'");
            sb.append((String) Preconditions.checkNotNull(this.zze));
            sb.append("'");
        } else if (i == 5) {
            sb.append("'");
            sb.append(Base64.encodeToString((byte[]) Preconditions.checkNotNull(this.zzf), 3));
            sb.append("'");
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(i).length());
            sb2.append("Invalid type: ");
            sb2.append(str);
            sb2.append(", ");
            sb2.append(i);
            throw new AssertionError(sb2.toString());
        }
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(this.zzh);
        sb.append(", ");
        sb.append(this.zzi);
        sb.append(")");
    }
}
