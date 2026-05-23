package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzahn;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzac extends zzab {
    final /* synthetic */ zzad zza;
    private final com.google.android.gms.internal.measurement.zzfn zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzad zzadVar, String str, int i, com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        super(str, i);
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzh = zzfnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zziu zziuVar, boolean z) {
        zzahn.zza();
        zzic zzicVar = this.zza.zzu;
        boolean zzp = zzicVar.zzc().zzp(this.zzb, zzfy.zzaD);
        com.google.android.gms.internal.measurement.zzfn zzfnVar = this.zzh;
        boolean zze = zzfnVar.zze();
        boolean zzf = zzfnVar.zzf();
        boolean zzi = zzfnVar.zzi();
        Object[] objArr = (zze || zzf || zzi) ? 1 : null;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (!z || objArr != null) {
            com.google.android.gms.internal.measurement.zzfh zzd = zzfnVar.zzd();
            boolean zzf2 = zzd.zzf();
            if (zziuVar.zzf()) {
                if (!zzd.zzc()) {
                    zzicVar.zzaW().zze().zzb("No number filter for long property. property", zzicVar.zzl().zzc(zziuVar.zzc()));
                } else {
                    bool = zze(zzg(zziuVar.zzh(), zzd.zzd()), zzf2);
                }
            } else if (zziuVar.zzk()) {
                if (!zzd.zzc()) {
                    zzicVar.zzaW().zze().zzb("No number filter for double property. property", zzicVar.zzl().zzc(zziuVar.zzc()));
                } else {
                    bool = zze(zzh(zziuVar.zzl(), zzd.zzd()), zzf2);
                }
            } else if (zziuVar.zzd()) {
                if (!zzd.zza()) {
                    if (!zzd.zzc()) {
                        zzicVar.zzaW().zze().zzb("No string or number filter defined. property", zzicVar.zzl().zzc(zziuVar.zzc()));
                    } else if (zzpk.zzm(zziuVar.zze())) {
                        bool = zze(zzi(zziuVar.zze(), zzd.zzd()), zzf2);
                    } else {
                        zzicVar.zzaW().zze().zzc("Invalid user property value for Numeric number filter. property, value", zzicVar.zzl().zzc(zziuVar.zzc()), zziuVar.zze());
                    }
                } else {
                    bool = zze(zzf(zziuVar.zze(), zzd.zzb(), zzicVar.zzaW()), zzf2);
                }
            } else {
                zzicVar.zzaW().zze().zzb("User property has no value, property", zzicVar.zzl().zzc(zziuVar.zzc()));
            }
            zzicVar.zzaW().zzk().zzb("Property filter result", bool == null ? AbstractJsonLexerKt.NULL : bool);
            if (bool == null) {
                return false;
            }
            this.zzd = true;
            if (!zzi || bool.booleanValue()) {
                if (!z || zzfnVar.zze()) {
                    this.zze = bool;
                }
                if (bool.booleanValue() && objArr != null && zziuVar.zza()) {
                    long zzb = zziuVar.zzb();
                    if (l != null) {
                        zzb = l.longValue();
                    }
                    if (zzp && zzfnVar.zze() && !zzfnVar.zzf() && l2 != null) {
                        zzb = l2.longValue();
                    }
                    if (zzfnVar.zzf()) {
                        this.zzg = Long.valueOf(zzb);
                    } else {
                        this.zzf = Long.valueOf(zzb);
                    }
                }
                return true;
            }
            return true;
        }
        zzicVar.zzaW().zzk().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null);
        return true;
    }
}
