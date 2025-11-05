package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzrb;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes4.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zzjd zzjdVar, zzbg zzbgVar, String str) {
        this.zza = zzbgVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlp zzlpVar;
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        zzh zzhVar;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        Bundle bundle;
        String str;
        boolean z;
        Object obj;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzbc zza;
        long j;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzZ();
        zzlp zzn = zzjdVar.zzL().zzn();
        zzn.zzg();
        zzic zzicVar3 = zzn.zzu;
        zzic.zzL();
        zzbg zzbgVar = this.zza;
        Preconditions.checkNotNull(zzbgVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbgVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzn.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzh = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzu = zzpgVar3.zzj().zzu(str2);
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
                zzjl zzB = zzn.zzg.zzB(str2);
                zzaE.zzY(zzu.zzz());
                if (zzicVar3.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzaE.zzam(null);
                }
                zzaE.zzat(zzB.zzk());
                if (zzB.zzo(zzjk.AD_STORAGE) && zzu.zzac()) {
                    Pair zzc = zzpgVar3.zzq().zzc(zzu.zzc(), zzB);
                    if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) zzc.first)) {
                        try {
                            zzaE.zzQ(zzlp.zzc((String) zzc.first, Long.toString(zzbgVar.zzd)));
                            if (zzc.second != null) {
                                zzaE.zzT(((Boolean) zzc.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzn.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzn.zzg;
                            zzpgVar.zzj().zzd();
                            return bArr;
                        }
                    }
                }
                zzic zzicVar4 = zzn.zzu;
                zzicVar4.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzicVar4.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzicVar4.zzu().zzb());
                zzaE.zzH(zzicVar4.zzu().zzc());
                try {
                    if (zzB.zzo(zzjk.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                        zzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbgVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzu.zzl())) {
                        zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                    }
                    String zzc2 = zzu.zzc();
                    zzpg zzpgVar4 = zzn.zzg;
                    List zzn2 = zzpgVar4.zzj().zzn(zzc2);
                    Iterator it = zzn2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpnVar = null;
                            break;
                        }
                        zzpnVar = (zzpn) it.next();
                        if ("_lte".equals(zzpnVar.zzc)) {
                            break;
                        }
                    }
                    if (zzpnVar == null || zzpnVar.zze == null) {
                        zzpn zzpnVar2 = new zzpn(zzc2, "auto", "_lte", zzn.zzu.zzaZ().currentTimeMillis(), 0L);
                        zzn2.add(zzpnVar2);
                        zzpgVar4.zzj().zzl(zzpnVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[zzn2.size()];
                    for (int i = 0; i < zzn2.size(); i++) {
                        com.google.android.gms.internal.measurement.zzit zzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzm.zzb(((zzpn) zzn2.get(i)).zzc);
                        zzm.zza(((zzpn) zzn2.get(i)).zzd);
                        zzpgVar4.zzp().zzc(zzm, ((zzpn) zzn2.get(i)).zze);
                        zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzm.zzbc();
                    }
                    zzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpg zzpgVar5 = zzn.zzg;
                    zzpgVar5.zzI(zzu, zzaE);
                    zzpgVar5.zzJ(zzu, zzaE);
                    zzgv zza2 = zzgv.zza(zzbgVar);
                    zzic zzicVar5 = zzn.zzu;
                    zzpp zzk = zzicVar5.zzk();
                    Bundle bundle2 = zza2.zzd;
                    zzk.zzI(bundle2, zzpgVar4.zzj().zzU(str2));
                    zzicVar5.zzk().zzG(zza2, zzicVar5.zzc().zzd(str2));
                    bundle2.putLong("_c", 1L);
                    zzicVar5.zzaV().zzj().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbgVar.zzc;
                    bundle2.putString("_o", str4);
                    if (zzicVar5.zzk().zzaa(zzaE.zzK(), zzu.zzay())) {
                        zzicVar5.zzk().zzM(bundle2, "_dbg", 1L);
                        zzicVar5.zzk().zzM(bundle2, "_r", 1L);
                    }
                    zzav zzj = zzpgVar4.zzj();
                    String str5 = zzbgVar.zza;
                    zzbc zzf2 = zzj.zzf(str2, str5);
                    if (zzf2 == null) {
                        zzhVar = zzu;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzaE;
                        zzpgVar2 = zzpgVar5;
                        obj = null;
                        bundle = bundle2;
                        str = str4;
                        zza = new zzbc(str2, str5, 0L, 0L, 0L, zzbgVar.zzd, 0L, null, null, null, null);
                        z = true;
                        j = 0;
                        zzhzVar = zzh;
                    } else {
                        zzpgVar2 = zzpgVar5;
                        zzhVar = zzu;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzaE;
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
                    zzpgVar4.zzj().zzh(zzbcVar);
                    zzic zzicVar6 = zzn.zzu;
                    long j3 = zzbgVar.zzd;
                    boolean z2 = z;
                    zzh zzhVar2 = zzhVar;
                    com.google.android.gms.internal.measurement.zzic zzicVar7 = zzicVar2;
                    zzpg zzpgVar6 = zzpgVar2;
                    try {
                        zzbb zzbbVar = new zzbb(zzicVar6, str, str2, str5, j3, j, bundle);
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
                                zzpgVar4.zzp().zzd(zzn3, zza3);
                                zzk2.zzg(zzn3);
                            }
                        }
                        zzicVar7.zzg(zzk2);
                        com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                        com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                        zza5.zzb(zzbcVar.zzc);
                        zza5.zza(str5);
                        zza4.zza(zza5);
                        zzicVar7.zzap(zza4);
                        zzicVar7.zzaf(zzpgVar4.zzm().zzb(zzhVar2.zzc(), Collections.emptyList(), zzicVar7.zzk(), Long.valueOf(zzk2.zzn()), Long.valueOf(zzk2.zzn()), false));
                        if (zzk2.zzm()) {
                            zzicVar7.zzv(zzk2.zzn());
                            zzicVar7.zzx(zzk2.zzn());
                        }
                        long zzp = zzhVar2.zzp();
                        int i2 = (zzp > 0L ? 1 : (zzp == 0L ? 0 : -1));
                        if (i2 != 0) {
                            zzicVar7.zzA(zzp);
                        }
                        long zzn4 = zzhVar2.zzn();
                        if (zzn4 != 0) {
                            zzicVar7.zzy(zzn4);
                        } else if (i2 != 0) {
                            zzicVar7.zzy(zzp);
                        }
                        String zzh2 = zzhVar2.zzh();
                        zzrb.zza();
                        if (zzicVar.zzc().zzp(str2, zzfy.zzaM) && zzh2 != null) {
                            zzicVar7.zzau(zzh2);
                        }
                        zzhVar2.zzL();
                        zzicVar7.zzZ((int) zzhVar2.zzG());
                        zzicVar.zzc().zzi();
                        zzicVar7.zzO(133005L);
                        zzicVar7.zzs(zzicVar.zzaZ().currentTimeMillis());
                        zzicVar7.zzae(z2);
                        zzpgVar6.zzS(zzicVar7.zzK(), zzicVar7);
                        zzhzVar.zze(zzicVar7);
                        zzhVar2.zzo(zzicVar7.zzu());
                        zzhVar2.zzq(zzicVar7.zzw());
                        zzpgVar4.zzj().zzv(zzhVar2, false, false);
                        zzpgVar4.zzj().zzc();
                        zzpgVar4.zzj().zzd();
                        try {
                            return zzpgVar4.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc()).zzcc());
                        } catch (IOException e2) {
                            zzn.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                            return obj;
                        }
                    } catch (Throwable th) {
                        th = th;
                        zzlpVar = zzn;
                        zzlpVar.zzg.zzj().zzd();
                        throw th;
                    }
                } catch (SecurityException e3) {
                    zzlpVar = zzn;
                    try {
                        zzlpVar.zzu.zzaV().zzj().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzpgVar = zzlpVar.zzg;
                        zzpgVar.zzj().zzd();
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        zzlpVar.zzg.zzj().zzd();
                        throw th;
                    }
                }
            } else {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpgVar3.zzj().zzd();
            return bArr2;
        } catch (Throwable th3) {
            th = th3;
            zzlpVar = zzn;
        }
    }
}
