package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzrd;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzjl implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjl(zzjp zzjpVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzjpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        byte[] bArr;
        zzpv zzpvVar3;
        zzqd zzqdVar;
        zzpv zzpvVar4;
        zzpv zzpvVar5;
        zzh zzhVar;
        zzio zzioVar;
        String str;
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzhw zzhwVar;
        Object obj;
        com.google.android.gms.internal.measurement.zzht zzhtVar;
        zzbd zzc;
        long j;
        byte[] bArr2;
        zzjp zzjpVar = this.zzc;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzpvVar2 = zzjpVar.zza;
        zzmc zzv = zzpvVar2.zzv();
        zzv.zzg();
        zzio zzioVar2 = zzv.zzu;
        zzio.zzP();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbhVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzv.zzu.zzaW().zzd().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpv zzpvVar6 = zzv.zzg;
        com.google.android.gms.internal.measurement.zzht zzb = com.google.android.gms.internal.measurement.zzhv.zzb();
        zzpvVar6.zzj().zzH();
        try {
            zzh zzl = zzpvVar6.zzj().zzl(str2);
            if (zzl == null) {
                zzv.zzu.zzaW().zzd().zzb("Log and bundle not available. package_name", str2);
                bArr2 = new byte[0];
            } else if (zzl.zzaJ()) {
                com.google.android.gms.internal.measurement.zzhw zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                zzz.zzar(1);
                zzz.zzan(ConstantDeviceInfo.APP_PLATFORM);
                if (!TextUtils.isEmpty(zzl.zzC())) {
                    zzz.zzI(zzl.zzC());
                }
                if (!TextUtils.isEmpty(zzl.zzE())) {
                    zzz.zzK((String) Preconditions.checkNotNull(zzl.zzE()));
                }
                if (!TextUtils.isEmpty(zzl.zzF())) {
                    zzz.zzL((String) Preconditions.checkNotNull(zzl.zzF()));
                }
                if (zzl.zze() != SieveCacheKt.NodeMetaAndPreviousMask) {
                    zzz.zzM((int) zzl.zze());
                }
                zzz.zzai(zzl.zzq());
                zzz.zzZ(zzl.zzo());
                String zzH = zzl.zzH();
                String zzA = zzl.zzA();
                if (!TextUtils.isEmpty(zzH)) {
                    zzz.zzah(zzH);
                } else if (!TextUtils.isEmpty(zzA)) {
                    zzz.zzH(zzA);
                }
                zzz.zzay(zzl.zzw());
                zzjx zzu = zzv.zzg.zzu(str2);
                zzz.zzW(zzl.zzn());
                if (zzioVar2.zzJ() && zzv.zzu.zzf().zzy(zzz.zzaF()) && zzu.zzr(zzjw.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzz.zzY(null);
                }
                zzz.zzT(zzu.zzp());
                if (zzu.zzr(zzjw.AD_STORAGE) && zzl.zzaI()) {
                    Pair zzd = zzpvVar6.zzw().zzd(zzl.zzC(), zzu);
                    if (zzl.zzaI() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzz.zzas(zzmc.zza((String) zzd.first, Long.toString(zzbhVar.zzd)));
                            if (zzd.second != null) {
                                zzz.zzal(((Boolean) zzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzv.zzu.zzaW().zzd().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpvVar3 = zzv.zzg;
                            zzpvVar3.zzj().zzL();
                            return bArr;
                        }
                    }
                }
                zzio zzioVar3 = zzv.zzu;
                zzioVar3.zzg().zzv();
                zzz.zzX(Build.MODEL);
                zzioVar3.zzg().zzv();
                zzz.zzam(Build.VERSION.RELEASE);
                zzz.zzaz((int) zzioVar3.zzg().zza());
                zzz.zzaD(zzioVar3.zzg().zzb());
                try {
                    if (zzu.zzr(zzjw.ANALYTICS_STORAGE) && zzl.zzD() != null) {
                        zzz.zzJ(zzmc.zza((String) Preconditions.checkNotNull(zzl.zzD()), Long.toString(zzbhVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzl.zzG())) {
                        zzz.zzag((String) Preconditions.checkNotNull(zzl.zzG()));
                    }
                    String zzC = zzl.zzC();
                    zzpv zzpvVar7 = zzv.zzg;
                    List zzE = zzpvVar7.zzj().zzE(zzC);
                    Iterator it = zzE.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzqdVar = null;
                            break;
                        }
                        zzqdVar = (zzqd) it.next();
                        if ("_lte".equals(zzqdVar.zzc)) {
                            break;
                        }
                    }
                    if (zzqdVar == null || zzqdVar.zze == null) {
                        zzqd zzqdVar2 = new zzqd(zzC, "auto", "_lte", zzv.zzu.zzaU().currentTimeMillis(), 0L);
                        zzE.add(zzqdVar2);
                        zzpvVar7.zzj().zzai(zzqdVar2);
                    }
                    com.google.android.gms.internal.measurement.zzio[] zzioVarArr = new com.google.android.gms.internal.measurement.zzio[zzE.size()];
                    for (int i = 0; i < zzE.size(); i++) {
                        com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
                        zze.zzf(((zzqd) zzE.get(i)).zzc);
                        zze.zzg(((zzqd) zzE.get(i)).zzd);
                        zzpvVar7.zzA().zzx(zze, ((zzqd) zzE.get(i)).zze);
                        zzioVarArr[i] = (com.google.android.gms.internal.measurement.zzio) zze.zzba();
                    }
                    zzz.zzm(Arrays.asList(zzioVarArr));
                    zzpv zzpvVar8 = zzv.zzg;
                    zzpvVar8.zzQ(zzl, zzz);
                    zzpvVar8.zzaa(zzl, zzz);
                    zzhf zzb2 = zzhf.zzb(zzbhVar);
                    zzio zzioVar4 = zzv.zzu;
                    zzqf zzw = zzioVar4.zzw();
                    Bundle bundle2 = zzb2.zzd;
                    zzw.zzO(bundle2, zzpvVar7.zzj().zzk(str2));
                    zzioVar4.zzw().zzQ(zzb2, zzioVar4.zzf().zzf(str2));
                    bundle2.putLong("_c", 1L);
                    zzioVar4.zzaW().zzd().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbhVar.zzc;
                    bundle2.putString("_o", str4);
                    if (zzioVar4.zzw().zzak(zzz.zzaF(), zzl.zzM())) {
                        zzioVar4.zzw().zzS(bundle2, "_dbg", 1L);
                        zzioVar4.zzw().zzS(bundle2, "_r", 1L);
                    }
                    zzaw zzj = zzpvVar7.zzj();
                    String str5 = zzbhVar.zza;
                    zzbd zzs = zzj.zzs(str2, str5);
                    if (zzs == null) {
                        bundle = bundle2;
                        zzioVar = zzioVar4;
                        str = str4;
                        zzhVar = zzl;
                        obj = null;
                        zzpvVar5 = zzpvVar8;
                        zzpvVar4 = zzpvVar7;
                        zzhwVar = zzz;
                        zzc = new zzbd(str2, str5, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                        j = 0;
                        zzhtVar = zzb;
                    } else {
                        zzpvVar4 = zzpvVar7;
                        zzpvVar5 = zzpvVar8;
                        zzhVar = zzl;
                        zzioVar = zzioVar4;
                        str = str4;
                        bundle = bundle2;
                        zzhwVar = zzz;
                        obj = null;
                        zzhtVar = zzb;
                        long j2 = zzs.zzf;
                        zzc = zzs.zzc(zzbhVar.zzd);
                        j = j2;
                    }
                    zzpvVar4.zzj().zzV(zzc);
                    com.google.android.gms.internal.measurement.zzhw zzhwVar2 = zzhwVar;
                    zzh zzhVar2 = zzhVar;
                    zzbc zzbcVar = new zzbc(zzv.zzu, str, str2, str5, zzbhVar.zzd, j, bundle);
                    com.google.android.gms.internal.measurement.zzhl zze2 = com.google.android.gms.internal.measurement.zzhm.zze();
                    zze2.zzm(zzbcVar.zzd);
                    zze2.zzi(zzbcVar.zzb);
                    zze2.zzl(zzbcVar.zze);
                    zzbf zzbfVar = zzbcVar.zzf;
                    zzbe zzbeVar = new zzbe(zzbfVar);
                    while (zzbeVar.hasNext()) {
                        String next = zzbeVar.next();
                        String str6 = next;
                        com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                        zze3.zzj(next);
                        Object zzf = zzbfVar.zzf(next);
                        if (zzf != null) {
                            zzpvVar4.zzA().zzw(zze3, zzf);
                            zze2.zze(zze3);
                        }
                    }
                    zzhwVar2.zzn(zze2);
                    com.google.android.gms.internal.measurement.zzhy zza = com.google.android.gms.internal.measurement.zzia.zza();
                    com.google.android.gms.internal.measurement.zzhn zza2 = com.google.android.gms.internal.measurement.zzho.zza();
                    zza2.zza(zzc.zzc);
                    zza2.zzb(str5);
                    zza.zza(zza2);
                    zzhwVar2.zzao(zza);
                    zzhwVar2.zzi(zzpvVar4.zzh().zza(zzhVar2.zzC(), Collections.emptyList(), zzhwVar2.zzaN(), Long.valueOf(zze2.zzc()), Long.valueOf(zze2.zzc()), false));
                    if (zze2.zzq()) {
                        zzhwVar2.zzax(zze2.zzc());
                        zzhwVar2.zzab(zze2.zzc());
                    }
                    long zzs2 = zzhVar2.zzs();
                    int i2 = (zzs2 > 0L ? 1 : (zzs2 == 0L ? 0 : -1));
                    if (i2 != 0) {
                        zzhwVar2.zzap(zzs2);
                    }
                    long zzu2 = zzhVar2.zzu();
                    if (zzu2 != 0) {
                        zzhwVar2.zzaq(zzu2);
                    } else if (i2 != 0) {
                        zzhwVar2.zzaq(zzs2);
                    }
                    String zzL = zzhVar2.zzL();
                    zzrd.zzb();
                    if (zzioVar.zzf().zzx(str2, zzgi.zzaL) && zzL != null) {
                        zzhwVar2.zzav(zzL);
                    }
                    zzhVar2.zzP();
                    zzhwVar2.zzP((int) zzhVar2.zzt());
                    zzioVar.zzf().zzj();
                    zzhwVar2.zzaB(119002L);
                    zzhwVar2.zzaA(zzioVar.zzaU().currentTimeMillis());
                    zzhwVar2.zzau(Boolean.TRUE.booleanValue());
                    zzpvVar5.zzN(zzhwVar2.zzaF(), zzhwVar2);
                    zzhtVar.zzc(zzhwVar2);
                    zzhVar2.zzau(zzhwVar2.zzf());
                    zzhVar2.zzas(zzhwVar2.zze());
                    zzpvVar4.zzj().zzT(zzhVar2, false, false);
                    zzpvVar4.zzj().zzS();
                    zzpvVar4.zzj().zzL();
                    try {
                        return zzpvVar4.zzA().zzB(((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba()).zzcd());
                    } catch (IOException e2) {
                        zzv.zzu.zzaW().zze().zzc("Data loss. Failed to bundle and serialize. appId", zzhe.zzn(str2), e2);
                        return obj;
                    }
                } catch (SecurityException e3) {
                    zzv.zzu.zzaW().zzd().zzb("app instance id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzpvVar3 = zzv.zzg;
                    zzpvVar3.zzj().zzL();
                    return bArr;
                }
            } else {
                zzv.zzu.zzaW().zzd().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpvVar6.zzj().zzL();
            return bArr2;
        } catch (Throwable th) {
            zzv.zzg.zzj().zzL();
            throw th;
        }
    }
}
