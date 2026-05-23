package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzjd extends zzga {
    private final zzpg zza;
    private Boolean zzb;
    private String zzc;

    public zzjd(zzpg zzpgVar, String str) {
        Preconditions.checkNotNull(zzpgVar);
        this.zza = zzpgVar;
        this.zzc = null;
    }

    private final void zzM(zzbh zzbhVar, zzr zzrVar) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        zzpgVar.zzF(zzbhVar, zzrVar);
    }

    private final void zzN(zzr zzrVar, boolean z) {
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzO(str, false);
        this.zza.zzt().zzC(zzrVar.zzb);
    }

    private final void zzO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        boolean z2 = true;
                        if (!"com.google.android.gms".equals(this.zzc)) {
                            zzpg zzpgVar = this.zza;
                            if (!UidVerifier.isGooglePlayServicesUid(zzpgVar.zzaZ(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(zzpgVar.zzaZ()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                            }
                        }
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzaW().zzb().zzb("Measurement Service called with invalid calling package. appId", zzgu.zzl(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaZ(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (str.equals(this.zzc)) {
                return;
            }
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
        this.zza.zzaW().zzb().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzA(zzr zzrVar) {
        zzN(zzrVar, false);
        zzd(new zzif(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzB(zzr zzrVar, final zzoo zzooVar, final zzgh zzghVar) {
        zzN(zzrVar, false);
        final String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        this.zza.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzI(str, zzooVar, zzghVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzC(final zzr zzrVar, final zzaf zzafVar) {
        zzN(zzrVar, false);
        zzd(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzja
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzJ(zzrVar, zzafVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzD(final zzr zzrVar, final Bundle bundle, final zzge zzgeVar) {
        zzN(zzrVar, false);
        final String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        this.zza.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzH(zzrVar, bundle, zzgeVar, str);
            }
        });
    }

    final void zzE(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpg zzpgVar = this.zza;
        if (zzpgVar.zzaX().zze()) {
            runnable.run();
        } else {
            zzpgVar.zzaX().zzl(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzF(zzr zzrVar) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        zzpgVar.zzv(zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(zzr zzrVar) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        zzpgVar.zzw(zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(zzr zzrVar, Bundle bundle, zzge zzgeVar, String str) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        try {
            zzgeVar.zze(zzpgVar.zzar(zzrVar, bundle));
        } catch (RemoteException e) {
            this.zza.zzaW().zzb().zzc("Failed to return trigger URIs for app", str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(String str, zzoo zzooVar, zzgh zzghVar) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        zzpgVar.zzaX().zzg();
        zzpgVar.zzu();
        List<zzpj> zzC = zzpgVar.zzj().zzC(str, zzooVar, ((Integer) zzfy.zzA.zzb(null)).intValue());
        ArrayList arrayList = new ArrayList();
        for (zzpj zzpjVar : zzC) {
            if (zzpgVar.zzO(str, zzpjVar.zze())) {
                int zzi = zzpjVar.zzi();
                if (zzi > 0) {
                    if (zzi <= ((Integer) zzfy.zzy.zzb(null)).intValue()) {
                        if (zzpgVar.zzba().currentTimeMillis() >= zzpjVar.zzh() + Math.min(((Long) zzfy.zzw.zzb(null)).longValue() * (1 << (zzi - 1)), ((Long) zzfy.zzx.zzb(null)).longValue())) {
                        }
                    }
                    zzpgVar.zzaW().zzk().zzd("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", str, Long.valueOf(zzpjVar.zzc()), Long.valueOf(zzpjVar.zzh()));
                }
                zzom zzb = zzpjVar.zzb();
                try {
                    com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.zzw(com.google.android.gms.internal.measurement.zzib.zzi(), zzb.zzb);
                    for (int i = 0; i < zzhzVar.zzb(); i++) {
                        com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzhzVar.zzc(i).zzco();
                        zzicVar.zzs(zzpgVar.zzba().currentTimeMillis());
                        zzhzVar.zzd(i, zzicVar);
                    }
                    zzb.zzb = ((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd()).zzcd();
                    if (Log.isLoggable(zzpgVar.zzaW().zzn(), 2)) {
                        zzb.zzg = zzpgVar.zzp().zzi((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd());
                    }
                    arrayList.add(zzb);
                } catch (zzaeh unused) {
                    zzpgVar.zzaW().zze().zzb("Failed to parse queued batch. appId", str);
                }
            } else {
                zzpgVar.zzaW().zzk().zzd("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", str, Long.valueOf(zzpjVar.zzc()), zzpjVar.zze());
            }
        }
        zzoq zzoqVar = new zzoq(arrayList);
        try {
            zzghVar.zze(zzoqVar);
            this.zza.zzaW().zzk().zzc("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(zzoqVar.zza.size()));
        } catch (RemoteException e) {
            this.zza.zzaW().zzb().zzc("[sgtm] Failed to return upload batches for app", str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(zzr zzrVar, zzaf zzafVar) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaa();
        zzpgVar.zzas((String) Preconditions.checkNotNull(zzrVar.zza), zzafVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(Bundle bundle, String str, zzr zzrVar) {
        boolean isEmpty = bundle.isEmpty();
        zzpg zzpgVar = this.zza;
        if (isEmpty) {
            zzaw zzj = zzpgVar.zzj();
            zzj.zzg();
            zzj.zzay();
            try {
                zzj.zze().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zzb().zzb("Error clearing default event params", e);
                return;
            }
        }
        zzaw zzj2 = zzpgVar.zzj();
        zzj2.zzg();
        zzj2.zzay();
        byte[] zzcd = zzj2.zzg.zzp().zzh(new zzbc(zzj2.zzu, "", str, "dep", 0L, 0L, 0L, bundle)).zzcd();
        zzic zzicVar = zzj2.zzu;
        zzicVar.zzaW().zzk().zzc("Saving default event parameters, appId, data size", str, Integer.valueOf(zzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzcd);
        try {
            if (zzj2.zze().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzicVar.zzaW().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzgu.zzl(str));
            }
        } catch (SQLiteException e2) {
            zzj2.zzu.zzaW().zzb().zzc("Error storing default event parameters. appId", zzgu.zzl(str), e2);
        }
        zzpg zzpgVar2 = this.zza;
        zzaw zzj3 = zzpgVar2.zzj();
        long j = zzrVar.zzD;
        if (zzj3.zzW(str, j)) {
            zzpgVar2.zzj().zzX(str, Long.valueOf(j), null, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzpg zzL() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzbh zzbhVar, zzr zzrVar) {
        zzpg zzpgVar = this.zza;
        zzht zzh = zzpgVar.zzh();
        String str = zzrVar.zza;
        com.google.android.gms.internal.measurement.zzc zzcVar = TextUtils.isEmpty(str) ? null : (com.google.android.gms.internal.measurement.zzc) zzh.zze.get(str);
        if (zzcVar != null) {
            try {
                Map zzz = zzpgVar.zzp().zzz(zzbhVar.zzb.zzf(), true);
                String str2 = zzbhVar.zza;
                String zza = zzjm.zza(str2);
                if (zza != null) {
                    str2 = zza;
                }
                if (zzcVar.zzb(new com.google.android.gms.internal.measurement.zzaa(str2, zzbhVar.zzd, zzz))) {
                    if (zzcVar.zzc()) {
                        zzpg zzpgVar2 = this.zza;
                        zzpgVar2.zzaW().zzk().zzb("EES edited event", zzbhVar.zza);
                        zzM(zzpgVar2.zzp().zzA(zzcVar.zze().zzc()), zzrVar);
                    } else {
                        zzM(zzbhVar, zzrVar);
                    }
                    if (zzcVar.zzd()) {
                        for (com.google.android.gms.internal.measurement.zzaa zzaaVar : zzcVar.zze().zzf()) {
                            zzpg zzpgVar3 = this.zza;
                            zzpgVar3.zzaW().zzk().zzb("EES logging created event", zzaaVar.zzb());
                            zzM(zzpgVar3.zzp().zzA(zzaaVar), zzrVar);
                        }
                        return;
                    }
                    return;
                }
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.zza.zzaW().zzb().zzc("EES error. appId, eventName", zzrVar.zzb, zzbhVar.zza);
            }
            this.zza.zzaW().zzk().zzb("EES was not applied to event", zzbhVar.zza);
            zzM(zzbhVar, zzrVar);
            return;
        }
        this.zza.zzaW().zzk().zzb("EES not loaded for", zzrVar.zza);
        zzM(zzbhVar, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbh zzc(zzbh zzbhVar, zzr zzrVar) {
        zzbf zzbfVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbhVar.zza) && (zzbfVar = zzbhVar.zzb) != null && zzbfVar.zze() != 0) {
            String zzd = zzbfVar.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                this.zza.zzaW().zzi().zzb("Event has been filtered ", zzbhVar.toString());
                return new zzbh("_cmpx", zzbfVar, zzbhVar.zzc, zzbhVar.zzd, zzbhVar.zze);
            }
        }
        return zzbhVar;
    }

    final void zzd(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpg zzpgVar = this.zza;
        if (zzpgVar.zzaX().zze()) {
            runnable.run();
        } else {
            zzpgVar.zzaX().zzj(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zze(zzbh zzbhVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbhVar);
        zzN(zzrVar, false);
        zzd(new zzir(this, zzbhVar, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzf(zzpl zzplVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzplVar);
        zzN(zzrVar, false);
        zzd(new zziu(this, zzplVar, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzg(zzr zzrVar) {
        zzN(zzrVar, false);
        zzd(new zzie(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzh(zzbh zzbhVar, String str, String str2) {
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotEmpty(str);
        zzO(str, true);
        zzd(new zzis(this, zzbhVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzi(zzr zzrVar) {
        zzN(zzrVar, false);
        zzd(new zzin(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzj(zzr zzrVar, boolean z) {
        zzN(zzrVar, false);
        String str = zzrVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzpn> list = (List) this.zza.zzaX().zzh(new zzid(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z || !zzpp.zzac(zzpnVar.zzc)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaW().zzb().zzc("Failed to get user properties. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final byte[] zzk(zzbh zzbhVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbhVar);
        zzO(str, true);
        zzpg zzpgVar = this.zza;
        zzgs zzj = zzpgVar.zzaW().zzj();
        zzgn zzs = zzpgVar.zzs();
        String str2 = zzbhVar.zza;
        zzj.zzb("Log and bundle. event", zzs.zza(str2));
        long nanoTime = zzpgVar.zzba().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) zzpgVar.zzaX().zzi(new zzit(this, zzbhVar, str)).get();
            if (bArr == null) {
                zzpgVar.zzaW().zzb().zzb("Log and bundle returned null. appId", zzgu.zzl(str));
                bArr = new byte[0];
            }
            zzpgVar.zzaW().zzj().zzd("Log and bundle processed. event, size, time_ms", zzpgVar.zzs().zza(str2), Integer.valueOf(bArr.length), Long.valueOf((zzpgVar.zzba().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            zzpg zzpgVar2 = this.zza;
            zzpgVar2.zzaW().zzb().zzd("Failed to log and bundle. appId, event, error", zzgu.zzl(str), zzpgVar2.zzs().zza(zzbhVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzl(long j, String str, String str2, String str3) {
        zzd(new zzig(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final String zzm(zzr zzrVar) {
        zzN(zzrVar, false);
        return this.zza.zzaq(zzrVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzn(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotNull(zzahVar.zzc);
        zzN(zzrVar, false);
        zzah zzahVar2 = new zzah(zzahVar);
        zzahVar2.zza = zzrVar.zza;
        zzd(new zzih(this, zzahVar2, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzo(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zza);
        zzO(zzahVar.zza, true);
        zzd(new zzii(this, new zzah(zzahVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzp(String str, String str2, boolean z, zzr zzrVar) {
        zzN(zzrVar, false);
        String str3 = zzrVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzpn> list = (List) this.zza.zzaX().zzh(new zzij(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z || !zzpp.zzac(zzpnVar.zzc)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaW().zzb().zzc("Failed to query user properties. appId", zzgu.zzl(zzrVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzq(String str, String str2, String str3, boolean z) {
        zzO(str, true);
        try {
            List<zzpn> list = (List) this.zza.zzaX().zzh(new zzik(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z || !zzpp.zzac(zzpnVar.zzc)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaW().zzb().zzc("Failed to get user properties as. appId", zzgu.zzl(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzr(String str, String str2, zzr zzrVar) {
        zzN(zzrVar, false);
        String str3 = zzrVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaX().zzh(new zzil(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaW().zzb().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzs(String str, String str2, String str3) {
        zzO(str, true);
        try {
            return (List) this.zza.zzaX().zzh(new zzim(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaW().zzb().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzt(zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzO(str, false);
        zzd(new zzio(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzu(final Bundle bundle, final zzr zzrVar) {
        zzN(zzrVar, false);
        final String str = zzrVar.zza;
        Preconditions.checkNotNull(str);
        zzd(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzK(bundle, str, zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzv(zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzs);
        zzE(new zzip(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final zzao zzw(zzr zzrVar) {
        zzN(zzrVar, false);
        Preconditions.checkNotEmpty(zzrVar.zza);
        try {
            return (zzao) this.zza.zzaX().zzi(new zziq(this, zzrVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzaW().zzb().zzc("Failed to get consent. appId", zzgu.zzl(zzrVar.zza), e);
            return new zzao(null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List zzx(zzr zzrVar, Bundle bundle) {
        zzN(zzrVar, false);
        Preconditions.checkNotNull(zzrVar.zza);
        zzpg zzpgVar = this.zza;
        if (zzpgVar.zzd().zzp(null, zzfy.zzaT)) {
            try {
                return (List) zzpgVar.zzaX().zzi(new zziv(this, zzrVar, bundle)).get(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                this.zza.zzaW().zzb().zzc("Failed to get trigger URIs. appId", zzgu.zzl(zzrVar.zza), e);
                return Collections.emptyList();
            }
        }
        try {
            return (List) this.zza.zzaX().zzh(new zziw(this, zzrVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaW().zzb().zzc("Failed to get trigger URIs. appId", zzgu.zzl(zzrVar.zza), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzy(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzs);
        zzE(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzF(zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void zzz(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzs);
        zzE(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzix
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzjd.this.zzG(zzrVar);
            }
        });
    }
}
