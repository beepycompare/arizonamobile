package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzabp extends zzabn {
    private static final String zza;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (r0.matches("\\n|\\r(?:\\n)?") == false) goto L4;
     */
    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (SecurityException unused) {
        }
        str = "\n";
        zza = str;
    }

    static int zze(String str, int i) throws zzabo {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else if (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt != '%' && charAt != 'n') {
                    return i;
                }
                i += 2;
            } else {
                throw zzabo.zzc("trailing unquoted '%' character", str, i);
            }
        }
        return -1;
    }

    abstract int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4) throws zzabo;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r0 = r14;
        r4 = zze(r3, r0.zzb(r15, r2, r3, r4, r5, r6));
        r14 = r0;
        r1 = r2;
        r0 = r9;
     */
    @Override // com.google.android.gms.internal.measurement.zzabn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(zzabm zzabmVar) throws zzabo {
        int i;
        int i2;
        int i3;
        int i4;
        String zzi = zzabmVar.zzi();
        int zze = zze(zzi, 0);
        int i5 = 0;
        int i6 = -1;
        while (zze >= 0) {
            int i7 = zze + 1;
            int i8 = i7;
            int i9 = 0;
            while (i8 < zzi.length()) {
                int i10 = i8 + 1;
                char charAt = zzi.charAt(i8);
                char c = (char) (charAt - '0');
                if (c >= '\n') {
                    if (charAt == '$') {
                        if (i8 - i7 != 0) {
                            if (zzi.charAt(i7) != '0') {
                                int i11 = i9 - 1;
                                if (i10 != zzi.length()) {
                                    zzi.charAt(i10);
                                    i4 = i5;
                                    i3 = i8 + 2;
                                    i = i10;
                                    i2 = i11;
                                } else {
                                    throw zzabo.zzc("unterminated parameter", zzi, zze);
                                }
                            } else {
                                throw zzabo.zza("index has leading zero", zzi, zze, i10);
                            }
                        } else {
                            throw zzabo.zza("missing index", zzi, zze, i10);
                        }
                    } else if (charAt != '<') {
                        int i12 = i5 + 1;
                        i = i7;
                        i2 = i5;
                        i3 = i10;
                        i4 = i12;
                    } else if (i6 != -1) {
                        if (i10 != zzi.length()) {
                            zzi.charAt(i10);
                            i4 = i5;
                            i3 = i8 + 2;
                            i = i10;
                            i2 = i6;
                        } else {
                            throw zzabo.zzc("unterminated parameter", zzi, zze);
                        }
                    } else {
                        throw zzabo.zza("invalid relative parameter", zzi, zze, i10);
                    }
                    int i13 = i3 - 1;
                    while (i13 < zzi.length()) {
                        if (((char) ((zzi.charAt(i13) & 65503) - 65)) < 26) {
                            break;
                        }
                        i13++;
                    }
                    throw zzabo.zzc("unterminated parameter", zzi, zze);
                }
                i9 = (i9 * 10) + c;
                if (i9 >= 1000000) {
                    throw zzabo.zza("index too large", zzi, zze, i10);
                }
                i8 = i10;
            }
            throw zzabo.zzc("unterminated parameter", zzi, zze);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzabn
    public final void zzd(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char charAt = str.charAt(i4);
                if (charAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (charAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(zza);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
