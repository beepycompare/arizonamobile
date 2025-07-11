package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzg {
    public final zzg zza;
    final zzaw zzb;
    final Map zzc = new HashMap();
    final Map zzd = new HashMap();

    public zzg(zzg zzgVar, zzaw zzawVar) {
        this.zza = zzgVar;
        this.zzb = zzawVar;
    }

    public final zzao zza(zzao zzaoVar) {
        return this.zzb.zzb(this, zzaoVar);
    }

    public final zzao zzb(zzae zzaeVar) {
        zzao zzaoVar = zzao.zzf;
        Iterator zzg = zzaeVar.zzg();
        while (zzg.hasNext()) {
            zzaoVar = this.zzb.zzb(this, zzaeVar.zzl(((Integer) zzg.next()).intValue()));
            if (zzaoVar instanceof zzag) {
                break;
            }
        }
        return zzaoVar;
    }

    public final zzg zzc() {
        return new zzg(this, this.zzb);
    }

    public final boolean zzd(String str) {
        if (this.zzc.containsKey(str)) {
            return true;
        }
        zzg zzgVar = this.zza;
        if (zzgVar != null) {
            return zzgVar.zzd(str);
        }
        return false;
    }

    public final void zze(String str, zzao zzaoVar) {
        zzg zzgVar;
        Map map = this.zzc;
        if (map.containsKey(str) || (zzgVar = this.zza) == null || !zzgVar.zzd(str)) {
            if (this.zzd.containsKey(str)) {
                return;
            }
            if (zzaoVar == null) {
                map.remove(str);
                return;
            } else {
                map.put(str, zzaoVar);
                return;
            }
        }
        zzgVar.zze(str, zzaoVar);
    }

    public final void zzf(String str, zzao zzaoVar) {
        if (this.zzd.containsKey(str)) {
            return;
        }
        if (zzaoVar == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, zzaoVar);
        }
    }

    public final void zzg(String str, zzao zzaoVar) {
        zzf(str, zzaoVar);
        this.zzd.put(str, true);
    }

    public final zzao zzh(String str) {
        Map map = this.zzc;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        zzg zzgVar = this.zza;
        if (zzgVar == null) {
            throw new IllegalArgumentException(String.format("%s is not defined", str));
        }
        return zzgVar.zzh(str);
    }
}
