package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqu;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzis implements Callable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzjc zzjcVar, zzbg zzbgVar, String str) {
        this.zza = zzbgVar;
        this.zzb = str;
        Objects.requireNonNull(zzjcVar);
        this.zzc = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlo zzloVar;
        byte[] bArr;
        zzpf zzpfVar;
        zzpm zzpmVar;
        zzpf zzpfVar2;
        zzh zzhVar;
        zzib zzibVar;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        Bundle bundle;
        String str;
        boolean z;
        Object obj;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzbc zza;
        long j;
        byte[] bArr2;
        zzjc zzjcVar = this.zzc;
        zzjcVar.zzL().zzY();
        zzlo zzn = zzjcVar.zzL().zzn();
        zzn.zzg();
        zzib zzibVar2 = zzn.zzu;
        zzib.zzL();
        zzbg zzbgVar = this.zza;
        Preconditions.checkNotNull(zzbgVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbgVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzn.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpf zzpfVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzh = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpfVar3.zzj().zzb();
        try {
            zzh zzu = zzpfVar3.zzj().zzu(str2);
            if (zzu == null) {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle not available. package_name", str2);
                bArr2 = new byte[0];
            } else if (zzu.zzD()) {
                com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                zzaE.zza(1);
                zzaE.zzC(ConstantDeviceInfo.APP_PLATFORM);
                if (!TextUtils.isEmpty(zzu.zzc())) {
                    zzaE.zzL(zzu.zzc());
                }
                if (!TextUtils.isEmpty(zzu.zzv())) {
                    zzaE.zzJ((String) Preconditions.checkNotNull(zzu.zzv()));
                }
                if (!TextUtils.isEmpty(zzu.zzr())) {
                    zzaE.zzM((String) Preconditions.checkNotNull(zzu.zzr()));
                }
                if (zzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask) {
                    zzaE.zzaj((int) zzu.zzt());
                }
                zzaE.zzN(zzu.zzx());
                zzaE.zzar(zzu.zzB());
                String zzf = zzu.zzf();
                if (!TextUtils.isEmpty(zzf)) {
                    zzaE.zzad(zzf);
                }
                zzaE.zzay(zzu.zzak());
                zzjk zzB = zzn.zzg.zzB(str2);
                zzaE.zzY(zzu.zzz());
                if (zzibVar2.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjj.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzaE.zzam(null);
                }
                zzaE.zzat(zzB.zzk());
                if (zzB.zzo(zzjj.AD_STORAGE) && zzu.zzac()) {
                    Pair zzc = zzpfVar3.zzq().zzc(zzu.zzc(), zzB);
                    if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) zzc.first)) {
                        try {
                            zzaE.zzQ(zzlo.zzc((String) zzc.first, Long.toString(zzbgVar.zzd)));
                            if (zzc.second != null) {
                                zzaE.zzT(((Boolean) zzc.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzn.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpfVar = zzn.zzg;
                            zzpfVar.zzj().zzd();
                            return bArr;
                        }
                    }
                }
                zzib zzibVar3 = zzn.zzu;
                zzibVar3.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzibVar3.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzibVar3.zzu().zzb());
                zzaE.zzH(zzibVar3.zzu().zzc());
                try {
                    if (zzB.zzo(zzjj.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                        zzaE.zzW(zzlo.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbgVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzu.zzl())) {
                        zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                    }
                    String zzc2 = zzu.zzc();
                    zzpf zzpfVar4 = zzn.zzg;
                    List zzn2 = zzpfVar4.zzj().zzn(zzc2);
                    Iterator it = zzn2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpmVar = null;
                            break;
                        }
                        zzpmVar = (zzpm) it.next();
                        if ("_lte".equals(zzpmVar.zzc)) {
                            break;
                        }
                    }
                    if (zzpmVar == null || zzpmVar.zze == null) {
                        zzpm zzpmVar2 = new zzpm(zzc2, "auto", "_lte", zzn.zzu.zzaZ().currentTimeMillis(), 0L);
                        zzn2.add(zzpmVar2);
                        zzpfVar4.zzj().zzl(zzpmVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[zzn2.size()];
                    for (int i = 0; i < zzn2.size(); i++) {
                        com.google.android.gms.internal.measurement.zzit zzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzm.zzb(((zzpm) zzn2.get(i)).zzc);
                        zzm.zza(((zzpm) zzn2.get(i)).zzd);
                        zzpfVar4.zzp().zzc(zzm, ((zzpm) zzn2.get(i)).zze);
                        zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzm.zzbc();
                    }
                    zzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpf zzpfVar5 = zzn.zzg;
                    zzpfVar5.zzI(zzu, zzaE);
                    zzpfVar5.zzJ(zzu, zzaE);
                    zzgu zza2 = zzgu.zza(zzbgVar);
                    zzib zzibVar4 = zzn.zzu;
                    zzpo zzk = zzibVar4.zzk();
                    Bundle bundle2 = zza2.zzd;
                    zzk.zzI(bundle2, zzpfVar4.zzj().zzW(str2));
                    zzibVar4.zzk().zzG(zza2, zzibVar4.zzc().zzd(str2));
                    bundle2.putLong("_c", 1L);
                    zzibVar4.zzaV().zzj().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbgVar.zzc;
                    bundle2.putString("_o", str4);
                    if (zzibVar4.zzk().zzaa(zzaE.zzK(), zzu.zzay())) {
                        zzibVar4.zzk().zzM(bundle2, "_dbg", 1L);
                        zzibVar4.zzk().zzM(bundle2, "_r", 1L);
                    }
                    zzav zzj = zzpfVar4.zzj();
                    String str5 = zzbgVar.zza;
                    zzbc zzf2 = zzj.zzf(str2, str5);
                    if (zzf2 == null) {
                        zzhVar = zzu;
                        zzibVar = zzibVar4;
                        zzicVar = zzaE;
                        zzpfVar2 = zzpfVar5;
                        obj = null;
                        bundle = bundle2;
                        str = str4;
                        zza = new zzbc(str2, str5, 0L, 0L, 0L, zzbgVar.zzd, 0L, null, null, null, null);
                        z = true;
                        j = 0;
                        zzhzVar = zzh;
                    } else {
                        zzpfVar2 = zzpfVar5;
                        zzhVar = zzu;
                        zzibVar = zzibVar4;
                        zzicVar = zzaE;
                        bundle = bundle2;
                        str = str4;
                        z = true;
                        obj = null;
                        zzhzVar = zzh;
                        long j2 = zzf2.zzf;
                        zza = zzf2.zza(zzbgVar.zzd);
                        j = j2;
                    }
                    zzbc zzbcVar = zza;
                    zzpfVar4.zzj().zzh(zzbcVar);
                    zzib zzibVar5 = zzn.zzu;
                    long j3 = zzbgVar.zzd;
                    boolean z2 = z;
                    zzh zzhVar2 = zzhVar;
                    com.google.android.gms.internal.measurement.zzic zzicVar2 = zzicVar;
                    zzpf zzpfVar6 = zzpfVar2;
                    try {
                        zzbb zzbbVar = new zzbb(zzibVar5, str, str2, str5, j3, j, bundle);
                        com.google.android.gms.internal.measurement.zzhr zzk2 = com.google.android.gms.internal.measurement.zzhs.zzk();
                        zzk2.zzo(zzbbVar.zzd);
                        zzk2.zzl(zzbbVar.zzb);
                        zzk2.zzq(zzbbVar.zze);
                        zzbe zzbeVar = zzbbVar.zzf;
                        zzbd zzbdVar = new zzbd(zzbeVar);
                        while (zzbdVar.hasNext()) {
                            String next = zzbdVar.next();
                            String str6 = next;
                            com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn3.zzb(next);
                            Object zza3 = zzbeVar.zza(next);
                            if (zza3 != null) {
                                zzpfVar4.zzp().zzd(zzn3, zza3);
                                zzk2.zzg(zzn3);
                            }
                        }
                        zzicVar2.zzg(zzk2);
                        com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                        com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                        zza5.zzb(zzbcVar.zzc);
                        zza5.zza(str5);
                        zza4.zza(zza5);
                        zzicVar2.zzap(zza4);
                        zzicVar2.zzaf(zzpfVar4.zzm().zzb(zzhVar2.zzc(), Collections.emptyList(), zzicVar2.zzk(), Long.valueOf(zzk2.zzn()), Long.valueOf(zzk2.zzn()), false));
                        if (zzk2.zzm()) {
                            zzicVar2.zzv(zzk2.zzn());
                            zzicVar2.zzx(zzk2.zzn());
                        }
                        long zzp = zzhVar2.zzp();
                        int i2 = (zzp > 0L ? 1 : (zzp == 0L ? 0 : -1));
                        if (i2 != 0) {
                            zzicVar2.zzA(zzp);
                        }
                        long zzn4 = zzhVar2.zzn();
                        if (zzn4 != 0) {
                            zzicVar2.zzy(zzn4);
                        } else if (i2 != 0) {
                            zzicVar2.zzy(zzp);
                        }
                        String zzh2 = zzhVar2.zzh();
                        zzqu.zza();
                        if (zzibVar.zzc().zzp(str2, zzfx.zzaM) && zzh2 != null) {
                            zzicVar2.zzau(zzh2);
                        }
                        zzhVar2.zzL();
                        zzicVar2.zzZ((int) zzhVar2.zzG());
                        zzibVar.zzc().zzi();
                        zzicVar2.zzO(130000L);
                        zzicVar2.zzs(zzibVar.zzaZ().currentTimeMillis());
                        zzicVar2.zzae(z2);
                        zzpfVar6.zzS(zzicVar2.zzK(), zzicVar2);
                        zzhzVar.zze(zzicVar2);
                        zzhVar2.zzo(zzicVar2.zzu());
                        zzhVar2.zzq(zzicVar2.zzw());
                        zzpfVar4.zzj().zzv(zzhVar2, false, false);
                        zzpfVar4.zzj().zzc();
                        zzpfVar4.zzj().zzd();
                        try {
                            return zzpfVar4.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc()).zzcc());
                        } catch (IOException e2) {
                            zzn.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgt.zzl(str2), e2);
                            return obj;
                        }
                    } catch (Throwable th) {
                        th = th;
                        zzloVar = zzn;
                        zzloVar.zzg.zzj().zzd();
                        throw th;
                    }
                } catch (SecurityException e3) {
                    zzloVar = zzn;
                    try {
                        zzloVar.zzu.zzaV().zzj().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzpfVar = zzloVar.zzg;
                        zzpfVar.zzj().zzd();
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        zzloVar.zzg.zzj().zzd();
                        throw th;
                    }
                }
            } else {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpfVar3.zzj().zzd();
            return bArr2;
        } catch (Throwable th3) {
            th = th3;
            zzloVar = zzn;
        }
    }
}
