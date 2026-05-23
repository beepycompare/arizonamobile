package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzza {
    private static final long zza;
    private static final zzza zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    static {
        long j = 0;
        for (int i = 0; i < 7; i++) {
            j |= (i + 1) << ((int) ((" #(+,-0".charAt(i) - ' ') * 3));
        }
        zza = j;
        zzb = new zzza(0, -1, -1);
    }

    private zzza(int i, int i2, int i3) {
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public static zzza zza() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(String str, boolean z) {
        int i = true != z ? 0 : 128;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int zzm = zzm(str.charAt(i2));
            if (zzm < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i |= 1 << zzm;
        }
        return i;
    }

    private static int zzm(char c) {
        return ((int) ((zza >>> ((c - ' ') * 3)) & 7)) - 1;
    }

    private static int zzn(String str, int i, int i2) throws zzabo {
        if (i != i2) {
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                char charAt = (char) (str.charAt(i4) - '0');
                if (charAt >= '\n') {
                    throw zzabo.zzb("invalid precision character", str, i4);
                }
                i3 = (i3 * 10) + charAt;
                if (i3 > 999999) {
                    throw zzabo.zza("precision too large", str, i, i2);
                }
            }
            if (i3 == 0) {
                if (i2 == i + 1) {
                    return 0;
                }
                throw zzabo.zza("invalid precision", str, i, i2);
            }
            return i3;
        }
        throw zzabo.zzb("missing precision", str, i - 1);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzza) {
            zzza zzzaVar = (zzza) obj;
            if (zzzaVar.zzc == this.zzc && zzzaVar.zzd == this.zzd && zzzaVar.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.zzc * 31) + this.zzd) * 31) + this.zze;
    }

    public final zzza zzd(int i, boolean z, boolean z2) {
        if (!zze()) {
            int i2 = this.zzc;
            int i3 = i2 & 128;
            if (i3 == 0) {
                return zzb;
            }
            if (i3 != i2 || this.zzd != -1 || this.zze != -1) {
                return new zzza(i3, -1, -1);
            }
        }
        return this;
    }

    public final boolean zze() {
        return this == zzb;
    }

    public final int zzf() {
        return this.zzd;
    }

    public final int zzg() {
        return this.zze;
    }

    public final boolean zzh(int i, boolean z) {
        int i2;
        if (zze()) {
            return true;
        }
        int i3 = this.zzc;
        if (((~i) & i3) != 0) {
            return false;
        }
        if (z || this.zze == -1) {
            int i4 = this.zzd;
            if ((i3 & 9) == 9 || (i2 = i3 & 96) == 96) {
                return false;
            }
            return i2 == 0 || i4 != -1;
        }
        return false;
    }

    public final boolean zzi(zzyz zzyzVar) {
        return zzh(zzyzVar.zzd(), zzyzVar.zzc().zza());
    }

    public final int zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        return (this.zzc & 128) != 0;
    }

    public final StringBuilder zzl(StringBuilder sb) {
        if (!zze()) {
            int i = this.zzc;
            int i2 = 0;
            while (true) {
                int i3 = i & (-129);
                int i4 = 1 << i2;
                if (i4 > i3) {
                    break;
                }
                if ((i3 & i4) != 0) {
                    sb.append(" #(+,-0".charAt(i2));
                }
                i2++;
            }
            int i5 = this.zzd;
            if (i5 != -1) {
                sb.append(i5);
            }
            int i6 = this.zze;
            if (i6 != -1) {
                sb.append('.');
                sb.append(i6);
            }
        }
        return sb;
    }

    public static zzza zzb(String str, int i, int i2, boolean z) throws zzabo {
        if (i != i2 || z) {
            int i3 = true != z ? 0 : 128;
            while (i != i2) {
                int i4 = i + 1;
                char charAt = str.charAt(i);
                if (charAt < ' ' || charAt > '0') {
                    if (charAt <= '9') {
                        int i5 = charAt - '0';
                        while (i4 != i2) {
                            int i6 = i4 + 1;
                            char charAt2 = str.charAt(i4);
                            if (charAt2 == '.') {
                                return new zzza(i3, i5, zzn(str, i6, i2));
                            }
                            char c = (char) (charAt2 - '0');
                            if (c >= '\n') {
                                throw zzabo.zzb("invalid width character", str, i4);
                            }
                            i5 = (i5 * 10) + c;
                            if (i5 > 999999) {
                                throw zzabo.zza("width too large", str, i, i2);
                            }
                            i4 = i6;
                        }
                        return new zzza(i3, i5, -1);
                    }
                    throw zzabo.zzb("invalid flag", str, i);
                }
                int zzm = zzm(charAt);
                if (zzm < 0) {
                    if (charAt == '.') {
                        return new zzza(i3, -1, zzn(str, i4, i2));
                    }
                    throw zzabo.zzb("invalid flag", str, i);
                }
                int i7 = 1 << zzm;
                if ((i3 & i7) != 0) {
                    throw zzabo.zzb("repeated flag", str, i);
                }
                i3 |= i7;
                i = i4;
            }
            return new zzza(i3, -1, -1);
        }
        return zzb;
    }
}
