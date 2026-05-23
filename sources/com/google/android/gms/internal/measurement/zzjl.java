package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzjl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjl> CREATOR = new zzjm();
    public static final byte[][] zza;
    public final String zzb;
    public final byte[] zzc;
    public final byte[][] zzd;
    public final byte[][] zze;
    public final byte[][] zzf;
    public final byte[][] zzg;
    public final int[] zzh;
    public final byte[][] zzi;
    public final int[] zzj;
    final byte[][] zzk;

    static {
        byte[][] bArr = new byte[0];
        zza = bArr;
        new zzjl("", null, bArr, bArr, bArr, bArr, null, null, null, null);
    }

    public zzjl(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6, int[] iArr2, byte[][] bArr7) {
        this.zzb = str;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzf = bArr4;
        this.zzg = bArr5;
        this.zzh = iArr;
        this.zzi = bArr6;
        this.zzj = iArr2;
        this.zzk = bArr7;
    }

    private static void zza(StringBuilder sb, String str, byte[][] bArr) {
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            sb.append(AbstractJsonLexerKt.NULL);
            return;
        }
        sb.append("(");
        boolean z = true;
        int i = 0;
        while (i < bArr.length) {
            byte[] bArr2 = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append("'");
            Preconditions.checkNotNull(bArr2);
            sb.append(Base64.encodeToString(bArr2, 3));
            sb.append("'");
            i++;
            z = false;
        }
        sb.append(")");
    }

    private final Set zzb() {
        ArrayList arrayList = new ArrayList();
        byte[][] bArr = this.zzi;
        if (bArr != null) {
            Collections.addAll(arrayList, bArr);
        }
        byte[] bArr2 = this.zzc;
        if (bArr2 != null) {
            arrayList.add(bArr2);
        }
        return zzc((byte[][]) arrayList.toArray(new byte[0]));
    }

    private static List zze(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length >> 1);
        for (int i = 0; i < iArr.length; i += 2) {
            arrayList.add(new zzju(iArr[i], iArr[i + 1]));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzjl) {
            zzjl zzjlVar = (zzjl) obj;
            if (zzkl.zza(this.zzb, zzjlVar.zzb) && zzkl.zza(zzb(), zzjlVar.zzb()) && zzkl.zza(zzc(this.zzd), zzc(zzjlVar.zzd)) && zzkl.zza(zzc(this.zze), zzc(zzjlVar.zze)) && zzkl.zza(zzc(this.zzf), zzc(zzjlVar.zzf)) && zzkl.zza(zzc(this.zzg), zzc(zzjlVar.zzg)) && zzkl.zza(zzd(this.zzh), zzd(zzjlVar.zzh)) && zzkl.zza(zze(this.zzj), zze(zzjlVar.zzj)) && zzkl.zza(zzc(this.zzk), zzc(zzjlVar.zzk))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder("ExperimentTokens");
        sb2.append("(");
        String str = this.zzb;
        if (str == null) {
            sb = AbstractJsonLexerKt.NULL;
        } else {
            StringBuilder sb3 = new StringBuilder(str.length() + 2);
            sb3.append("'");
            sb3.append(str);
            sb3.append("'");
            sb = sb3.toString();
        }
        sb2.append(sb);
        byte[] bArr = this.zzc;
        sb2.append(", direct==");
        if (bArr == null) {
            sb2.append(AbstractJsonLexerKt.NULL);
        } else {
            sb2.append("'");
            sb2.append(Base64.encodeToString(bArr, 3));
            sb2.append("'");
        }
        sb2.append(", ");
        zza(sb2, "GAIA=", this.zzd);
        sb2.append(", ");
        zza(sb2, "PSEUDO=", this.zze);
        sb2.append(", ");
        zza(sb2, "ALWAYS=", this.zzf);
        sb2.append(", ");
        zza(sb2, "OTHER=", this.zzg);
        sb2.append(", weak=");
        sb2.append(Arrays.toString(this.zzh));
        sb2.append(", ");
        zza(sb2, "directs=", this.zzi);
        sb2.append(", genDims=");
        sb2.append(Arrays.toString(zze(this.zzj).toArray()));
        sb2.append(", ");
        zza(sb2, "external=", this.zzk);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeIntArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeIntArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 11, this.zzk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private static Set zzc(byte[][] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return Collections.emptySet();
        }
        HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(length);
        for (byte[] bArr2 : bArr) {
            Preconditions.checkNotNull(bArr2);
            newHashSetWithExpectedSize.add(Base64.encodeToString(bArr2, 3));
        }
        return newHashSetWithExpectedSize;
    }

    private static Set zzd(int[] iArr) {
        int length;
        if (iArr == null || (length = iArr.length) == 0) {
            return Collections.emptySet();
        }
        HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(length);
        for (int i : iArr) {
            newHashSetWithExpectedSize.add(Integer.valueOf(i));
        }
        return newHashSetWithExpectedSize;
    }
}
