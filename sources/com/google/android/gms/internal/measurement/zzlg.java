package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzlg implements Iterable, Serializable {
    public static final zzlg zzb = new zzlf(zzmo.zzb);
    private int zza = 0;

    static {
        int i = zzku.zza;
    }

    public static zzlg zzh(byte[] bArr, int i, int i2) {
        zzj(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzlf(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzc = zzc();
            i = zzg(zzc, 0, zzc);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkz(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzc()), zzc() <= 50 ? zzof.zza(this) : zzof.zza(zze(0, 47)).concat("..."));
    }

    public abstract byte zza(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract zzlg zze(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(zzky zzkyVar) throws IOException;

    protected abstract int zzg(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzi() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                sb.append("Beginning index: ");
                sb.append(i);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i);
                sb2.append(", ");
                sb2.append(i2);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
                sb3.append("End index: ");
                sb3.append(i2);
                sb3.append(" >= ");
                sb3.append(i3);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i4;
    }
}
