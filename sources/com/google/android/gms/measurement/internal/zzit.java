package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzair;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01a7 A[Catch: all -> 0x053b, TryCatch #3 {all -> 0x053b, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0457, B:105:0x0465, B:107:0x046d, B:108:0x0470, B:110:0x0478, B:113:0x0481, B:116:0x0496, B:117:0x0499, B:112:0x047e, B:95:0x0394, B:84:0x026e, B:125:0x051c), top: B:138:0x0057, inners: #0, #2 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzh zzhVar;
        String str;
        zzic zzicVar;
        Bundle bundle;
        Object obj;
        long j;
        zzbd zza;
        Pair pair;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzn = zzjdVar.zzL().zzn();
        zzn.zzg();
        zzic zzicVar2 = zzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbhVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzu = zzpgVar3.zzj().zzu(str2);
            if (zzu == null) {
                zzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str2);
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
                if (zzicVar2.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzaE.zzam(null);
                }
                zzaE.zzat(zzB.zzk());
                zzjk zzjkVar = zzjk.AD_STORAGE;
                if (zzB.zzo(zzjkVar) && zzu.zzac()) {
                    zznn zzq = zzpgVar3.zzq();
                    if (zzB.zzo(zzjkVar) && zzu.zzac()) {
                        pair = zzq.zzd(zzu.zzc());
                        if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) pair.first)) {
                            try {
                                zzaE.zzQ(zzlp.zzc((String) pair.first, Long.toString(zzbhVar.zzd)));
                                if (pair.second != null) {
                                    zzaE.zzT(((Boolean) pair.second).booleanValue());
                                }
                            } catch (SecurityException e) {
                                zzn.zzu.zzaW().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                                bArr = new byte[0];
                                zzpgVar = zzn.zzg;
                                zzpgVar.zzj().zzd();
                                return bArr;
                            }
                        }
                    }
                    pair = new Pair("", false);
                    if (zzu.zzac()) {
                        zzaE.zzQ(zzlp.zzc((String) pair.first, Long.toString(zzbhVar.zzd)));
                        if (pair.second != null) {
                        }
                    }
                }
                zzic zzicVar3 = zzn.zzu;
                zzicVar3.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzicVar3.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzicVar3.zzu().zzb());
                zzaE.zzH(zzicVar3.zzu().zzc());
                try {
                    if (zzB.zzo(zzjk.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                        zzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbhVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzu.zzl())) {
                        zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                    }
                    String zzc = zzu.zzc();
                    zzpg zzpgVar4 = zzn.zzg;
                    List zzn2 = zzpgVar4.zzj().zzn(zzc);
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
                        zzpn zzpnVar2 = new zzpn(zzc, "auto", "_lte", zzn.zzu.zzba().currentTimeMillis(), 0L);
                        zzn2.add(zzpnVar2);
                        zzpgVar4.zzj().zzl(zzpnVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[zzn2.size()];
                    for (int i = 0; i < zzn2.size(); i++) {
                        com.google.android.gms.internal.measurement.zzit zzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzm.zzb(((zzpn) zzn2.get(i)).zzc);
                        zzm.zza(((zzpn) zzn2.get(i)).zzd);
                        zzpgVar4.zzp().zzc(zzm, ((zzpn) zzn2.get(i)).zze);
                        zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzm.zzbd();
                    }
                    zzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpg zzpgVar5 = zzn.zzg;
                    zzpgVar5.zzI(zzu, zzaE);
                    zzpgVar5.zzJ(zzu, zzaE);
                    zzgv zza2 = zzgv.zza(zzbhVar);
                    zzic zzicVar4 = zzn.zzu;
                    zzpp zzk = zzicVar4.zzk();
                    Bundle bundle2 = zza2.zze;
                    zzk.zzK(bundle2, zzpgVar4.zzj().zzV(str2));
                    zzicVar4.zzk().zzI(zza2, zzicVar4.zzc().zzd(str2));
                    com.google.android.gms.internal.measurement.zzic zzicVar5 = zzaE;
                    bundle2.putLong("_c", 1L);
                    zzicVar4.zzaW().zzj().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbhVar.zzc;
                    bundle2.putString("_o", str4);
                    if (zzicVar4.zzk().zzad(zzicVar5.zzK(), zzu.zzay())) {
                        zzicVar4.zzk().zzO(bundle2, "_dbg", 1L);
                        zzicVar4.zzk().zzO(bundle2, "_r", 1L);
                    }
                    zzaw zzj = zzpgVar4.zzj();
                    String str5 = zzbhVar.zza;
                    zzbd zzf2 = zzj.zzf(str2, str5);
                    if (zzf2 == null) {
                        zzicVar = zzicVar4;
                        zzhzVar = zzi;
                        zzhVar = zzu;
                        bundle = bundle2;
                        zzpgVar2 = zzpgVar4;
                        str = str4;
                        obj = null;
                        zza = new zzbd(str2, str5, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                        zzicVar5 = zzicVar5;
                        j = 0;
                    } else {
                        zzpgVar2 = zzpgVar4;
                        zzhzVar = zzi;
                        zzhVar = zzu;
                        str = str4;
                        zzicVar = zzicVar4;
                        bundle = bundle2;
                        obj = null;
                        j = zzf2.zzf;
                        zza = zzf2.zza(zzbhVar.zzd);
                    }
                    zzbd zzbdVar = zza;
                    zzpgVar2.zzj().zzh(zzbdVar);
                    com.google.android.gms.internal.measurement.zzic zzicVar6 = zzicVar5;
                    zzic zzicVar7 = zzn.zzu;
                    long j2 = zzbhVar.zzd;
                    com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                    zzh zzhVar2 = zzhVar;
                    zzbc zzbcVar = new zzbc(zzicVar7, str, str2, str5, j2, 0L, j, bundle);
                    com.google.android.gms.internal.measurement.zzhr zzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                    zzp.zzo(zzbcVar.zzd);
                    zzp.zzl(zzbcVar.zzb);
                    zzp.zzq(zzbcVar.zzf);
                    zzbf zzbfVar = zzbcVar.zzg;
                    zzbe zzbeVar = new zzbe(zzbfVar);
                    while (zzbeVar.hasNext()) {
                        String next = zzbeVar.next();
                        String str6 = next;
                        com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzn3.zzb(next);
                        Object zza3 = zzbfVar.zza(next);
                        if (zza3 != null) {
                            zzpgVar2.zzp().zzd(zzn3, zza3);
                            zzp.zzg(zzn3);
                        }
                    }
                    zzicVar6.zzg(zzp);
                    com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                    com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                    zza5.zzb(zzbdVar.zzc);
                    zza5.zza(str5);
                    zza4.zza(zza5);
                    zzicVar6.zzap(zza4);
                    zzicVar6.zzaf(zzpgVar2.zzm().zzb(zzhVar2.zzc(), Collections.emptyList(), zzicVar6.zzk(), Long.valueOf(zzp.zzn()), Long.valueOf(zzp.zzn()), false));
                    if (zzp.zzm()) {
                        zzicVar6.zzv(zzp.zzn());
                        zzicVar6.zzx(zzp.zzn());
                    }
                    long zzp2 = zzhVar2.zzp();
                    int i2 = (zzp2 > 0L ? 1 : (zzp2 == 0L ? 0 : -1));
                    if (i2 != 0) {
                        zzicVar6.zzA(zzp2);
                    }
                    long zzn4 = zzhVar2.zzn();
                    if (zzn4 != 0) {
                        zzicVar6.zzy(zzn4);
                    } else if (i2 != 0) {
                        zzicVar6.zzy(zzp2);
                    }
                    String zzh = zzhVar2.zzh();
                    zzair.zza();
                    if (zzicVar.zzc().zzp(str2, zzfy.zzaM) && zzh != null) {
                        zzicVar6.zzau(zzh);
                    }
                    zzhVar2.zzL();
                    zzicVar6.zzZ((int) zzhVar2.zzG());
                    zzicVar.zzc().zzi();
                    zzicVar6.zzO(161000L);
                    zzicVar6.zzs(zzicVar.zzba().currentTimeMillis());
                    zzicVar6.zzae(true);
                    zzpgVar5.zzS(zzicVar6.zzK(), zzicVar6);
                    zzhzVar2.zze(zzicVar6);
                    zzhVar2.zzo(zzicVar6.zzu());
                    zzhVar2.zzq(zzicVar6.zzw());
                    zzpgVar2.zzj().zzv(zzhVar2, false, false);
                    zzpgVar2.zzj().zzc();
                    zzpgVar2.zzj().zzd();
                    try {
                        return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                    } catch (IOException e2) {
                        zzn.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                        return obj;
                    }
                } catch (SecurityException e3) {
                    zzn.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzpgVar = zzn.zzg;
                    zzpgVar.zzj().zzd();
                    return bArr;
                }
            } else {
                zzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpgVar3.zzj().zzd();
            return bArr2;
        } catch (Throwable th) {
            zzn.zzg.zzj().zzd();
            throw th;
        }
    }
}
