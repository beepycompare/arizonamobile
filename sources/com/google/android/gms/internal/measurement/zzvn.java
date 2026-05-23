package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzvn implements zzws {
    private final zzws zza;
    private final UUID zzb;
    private final String zzc;
    private final String zzd;
    private Thread zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvn(String str, zzws zzwsVar, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = zzwsVar;
        this.zzb = zzwsVar.zzc();
        this.zzc = zzwsVar.zzd();
        zzxb zzxbVar = zzwqVar.zzc;
        this.zze = Thread.currentThread();
    }

    public static String zzcL(UUID uuid) {
        String l = Long.toString(uuid.getLeastSignificantBits() >>> 1, 36);
        String.valueOf(l);
        return "tk-trace-id: ".concat(String.valueOf(l));
    }

    @Override // com.google.android.gms.internal.measurement.zzwt, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = zzvy.zzb;
        Preconditions.checkNotNull(this);
        zzwq zzd = zzvy.zzd();
        zzws zzwsVar = zzd.zzb;
        if (zzwsVar == null) {
            String zze = zze();
            StringBuilder sb = new StringBuilder(String.valueOf(zze).length() + 101);
            sb.append("Tried to end [");
            sb.append(zze);
            sb.append("], but no trace was active. This is caused by mismatched or missing calls to beginSpan.");
            throw new zzvv(sb.toString());
        } else if (this != zzwsVar) {
            String zze2 = zze();
            String zze3 = zzwsVar.zze();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zze2).length() + 79 + String.valueOf(zze3).length() + 1);
            sb2.append("Tried to end span ");
            sb2.append(zze2);
            sb2.append(", but that span is not the current span. The current span is ");
            sb2.append(zze3);
            sb2.append(".");
            throw new zzvw(sb2.toString());
        } else {
            zzvy.zzc(zzd, zzwsVar.zzb());
            this.zze = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.internal.measurement.zzvn] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.android.gms.internal.measurement.zzws] */
    public final String toString() {
        String str;
        int i = zzvy.zzb;
        zzws zzwsVar = this;
        int i2 = 0;
        int i3 = 0;
        while (zzwsVar != null) {
            i2++;
            i3 += zzwsVar.zze().length();
            zzwsVar = zzwsVar.zzb();
            if (zzwsVar != null) {
                i3 += 4;
            }
        }
        if (i2 > 250) {
            String[] strArr = new String[i2];
            zzws zzwsVar2 = this;
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                strArr[i4] = zzwsVar2.zze();
                zzwsVar2 = zzwsVar2.zzb();
            }
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ImmutableSet.copyOf(strArr).iterator();
            int i5 = 0;
            while (it.hasNext()) {
                builder.put(it.next(), Integer.valueOf(i5));
                i5++;
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            int i6 = i2 >> 2;
            zzwo zzwoVar = null;
            if (buildOrThrow.size() <= i6) {
                int[] iArr = new int[i2 + 1];
                for (int i7 = 0; i7 < i2; i7++) {
                    iArr[i7] = ((Integer) buildOrThrow.get(strArr[i7])).intValue();
                }
                iArr[i2] = buildOrThrow.size();
                zzwo zzd = zzwp.zza(iArr).zzd();
                if (zzd.zzc * (zzd.zzb - zzd.zza) >= i6) {
                    zzwoVar = zzd;
                }
            }
            String str2 = "";
            if (zzwoVar != null) {
                int i8 = zzwoVar.zza;
                if (i8 <= 0) {
                    str = "";
                } else {
                    String join = TextUtils.join(" -> ", Arrays.copyOf(strArr, i8));
                    String.valueOf(join);
                    str = String.valueOf(join).concat(" -> ");
                }
                int i9 = zzwoVar.zzb;
                int i10 = zzwoVar.zzc;
                int i11 = ((i9 - i8) * i10) + i8;
                if (i11 < i2) {
                    String join2 = TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i11, i2));
                    String.valueOf(join2);
                    str2 = " -> ".concat(String.valueOf(join2));
                }
                str2 = String.format(Locale.US, "%s{%s}x%d%s", str, TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i8, i9)), Integer.valueOf(i10), str2);
            }
            if (!str2.isEmpty()) {
                return str2;
            }
        }
        char[] cArr = new char[i3];
        while (this != 0) {
            String zze = this.zze();
            i3 -= zze.length();
            zze.getChars(0, zze.length(), cArr, i3);
            this = this.zzb();
            if (this != 0) {
                i3 -= 4;
                " -> ".getChars(0, 4, cArr, i3);
            }
        }
        return new String(cArr);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final Thread zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final UUID zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zze() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvn(String str, UUID uuid, String str2, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = null;
        this.zzb = uuid;
        this.zzc = str2;
        zzxb zzxbVar = zzwqVar.zzc;
        this.zze = Thread.currentThread();
    }
}
