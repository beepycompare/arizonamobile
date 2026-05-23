package com.google.android.gms.internal.measurement;

import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzyy extends zzabm implements zzabi {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    protected zzyy(zzaaf zzaafVar, Object[] objArr, StringBuilder sb) {
        super(zzaafVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzzd zzzdVar, StringBuilder sb) {
        if (zzzdVar.zzh() != null) {
            zzyy zzyyVar = new zzyy(zzzdVar.zzh(), zzzdVar.zzi(), sb);
            StringBuilder sb2 = (StringBuilder) zzyyVar.zzl();
            if (zzzdVar.zzi().length > zzyyVar.zzj()) {
                sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
            }
            return sb2;
        }
        sb.append(zzzh.zza(zzzdVar.zzj()));
        return sb;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzzh.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final void zzb(int i, int i2, zzabh zzabhVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzabhVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if ((r7 instanceof java.math.BigDecimal) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
        if ((r7 instanceof java.math.BigInteger) == false) goto L14;
     */
    @Override // com.google.android.gms.internal.measurement.zzabi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(Object obj, zzyz zzyzVar, zzza zzzaVar) {
        boolean z;
        int ordinal = zzyzVar.zzc().ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                z = obj instanceof Boolean;
            } else if (ordinal == 2) {
                if (!(obj instanceof Character)) {
                    if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                        z = Character.isValidCodePoint(((Number) obj).intValue());
                    }
                    z = false;
                }
                z = true;
            } else if (ordinal == 3) {
                if (!(obj instanceof Integer)) {
                    if (!(obj instanceof Long)) {
                        if (!(obj instanceof Byte)) {
                            if (!(obj instanceof Short)) {
                            }
                        }
                    }
                }
                z = true;
            } else if (ordinal != 4) {
                throw null;
            } else {
                if (!(obj instanceof Double)) {
                    if (!(obj instanceof Float)) {
                    }
                }
                z = true;
            }
            if (!z) {
                zzm(this.zzb, obj, zzyzVar.zze());
                return;
            }
        }
        StringBuilder sb = this.zzb;
        int ordinal2 = zzyzVar.ordinal();
        if (ordinal2 != 0) {
            if (ordinal2 != 1) {
                if (ordinal2 != 2) {
                    if (ordinal2 != 3) {
                        if (ordinal2 == 5 && zzzaVar.zzd(128, false, false).equals(zzzaVar)) {
                            zzzh.zzc(sb, (Number) obj, zzzaVar);
                            return;
                        }
                    }
                } else if (zzzaVar.zze()) {
                    if (obj instanceof Character) {
                        sb.append(obj);
                        return;
                    }
                    int intValue = ((Number) obj).intValue();
                    if ((intValue >>> 16) == 0) {
                        sb.append((char) intValue);
                        return;
                    } else {
                        sb.append(Character.toChars(intValue));
                        return;
                    }
                }
            }
            if (zzzaVar.zze()) {
                sb.append(obj);
                return;
            }
        } else if (obj instanceof Formattable) {
            zzzh.zzb((Formattable) obj, sb, zzzaVar);
            return;
        } else if (zzzaVar.zze()) {
            sb.append(zzzh.zza(obj));
            return;
        }
        String zze = zzyzVar.zze();
        if (!zzzaVar.zze()) {
            int zzb = zzyzVar.zzb();
            if (zzzaVar.zzk()) {
                zzb &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            zzzaVar.zzl(sb2);
            sb2.append((char) zzb);
            zze = sb2.toString();
        }
        sb.append(String.format(zzzh.zza, zze, obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzd(Object obj, zzabf zzabfVar, zzza zzzaVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzzaVar.zzl(sb);
            sb.append(true != zzzaVar.zzk() ? 't' : 'T');
            sb.append(zzabfVar.zzb());
            this.zzb.append(String.format(zzzh.zza, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.zzb;
        char zzb = zzabfVar.zzb();
        StringBuilder sb3 = new StringBuilder(String.valueOf(zzb).length() + 2);
        sb3.append("%t");
        sb3.append(zzb);
        zzm(sb2, obj, sb3.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzf() {
        this.zzb.append(AbstractJsonLexerKt.NULL);
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final /* bridge */ /* synthetic */ Object zzg() {
        zzabn zzh = zzh();
        String zzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zzh.zzd(sb, zzi, i, length);
        return sb;
    }
}
