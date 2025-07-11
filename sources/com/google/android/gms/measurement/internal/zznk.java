package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznk extends zzg {
    private final zzne zza;
    private zzga zzb;
    private volatile Boolean zzc;
    private final zzay zzd;
    private ScheduledExecutorService zze;
    private final zzof zzf;
    private final List zzg;
    private final zzay zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zznk(zzib zzibVar) {
        super(zzibVar);
        this.zzg = new ArrayList();
        this.zzf = new zzof(zzibVar.zzaZ());
        this.zza = new zzne(this);
        this.zzd = new zzml(this, zzibVar);
        this.zzh = new zzmp(this, zzibVar);
    }

    private final boolean zzad() {
        this.zzu.zzaU();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzV() {
        zzg();
        this.zzf.zza();
        this.zzu.zzc();
        this.zzd.zzb(((Long) zzfx.zzY.zzb(null)).longValue());
    }

    private final void zzaf(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        zzib zzibVar = this.zzu;
        zzibVar.zzc();
        if (list.size() >= 1000) {
            zzibVar.zzaV().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzb(60000L);
        zzI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzag */
    public final void zzX() {
        zzg();
        zzgr zzk = this.zzu.zzaV().zzk();
        List<Runnable> list = this.zzg;
        zzk.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        for (Runnable runnable : list) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                this.zzu.zzaV().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    private final zzr zzah(boolean z) {
        Pair zzb;
        zzib zzibVar = this.zzu;
        zzibVar.zzaU();
        zzgh zzv = this.zzu.zzv();
        String str = null;
        if (z) {
            zzib zzibVar2 = zzibVar.zzaV().zzu;
            if (zzibVar2.zzd().zzb != null && (zzb = zzibVar2.zzd().zzb.zzb()) != null && zzb != zzhg.zza) {
                String valueOf = String.valueOf(zzb.second);
                String str2 = (String) zzb.first;
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
                sb.append(str2);
                str = sb.toString();
            }
        }
        return zzv.zzh(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA(zzpk zzpkVar) {
        zzg();
        zzb();
        zzad();
        zzaf(new zzmf(this, zzah(true), this.zzu.zzm().zzj(zzpkVar), zzpkVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB() {
        zzg();
        zzb();
        zzr zzah = zzah(false);
        zzad();
        this.zzu.zzm().zzh();
        zzaf(new zzmg(this, zzah));
    }

    public final void zzC(AtomicReference atomicReference) {
        zzg();
        zzb();
        zzaf(new zzmh(this, atomicReference, zzah(false)));
    }

    public final void zzD(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzg();
        zzb();
        zzaf(new zzmi(this, zzah(false), zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzE() {
        zzg();
        zzb();
        zzr zzah = zzah(true);
        zzad();
        this.zzu.zzc().zzp(null, zzfx.zzbc);
        this.zzu.zzm().zzn();
        zzaf(new zzmj(this, zzah, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF() {
        zzg();
        zzb();
        zzaf(new zzmk(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzG(zzlt zzltVar) {
        zzg();
        zzb();
        zzaf(new zzmm(this, zzltVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zzb();
        zzbe zzbeVar = new zzbe(bundle);
        zzad();
        zzaf(new zzmn(this, true, zzah(false), this.zzu.zzc().zzp(null, zzfx.zzbc) && this.zzu.zzm().zzl(zzbeVar), zzbeVar, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzb();
        if (zzh()) {
            return;
        }
        if (!zzK()) {
            zzib zzibVar = this.zzu;
            if (zzibVar.zzc().zzE()) {
                return;
            }
            zzibVar.zzaU();
            List<ResolveInfo> queryIntentServices = zzibVar.zzaY().getPackageManager().queryIntentServices(new Intent().setClassName(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                zzibVar.zzaV().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context zzaY = zzibVar.zzaY();
            zzibVar.zzaU();
            intent.setComponent(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        this.zza.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzJ() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzK() {
        zzg();
        zzb();
        if (this.zzc == null) {
            zzg();
            zzb();
            zzib zzibVar = this.zzu;
            zzhg zzd = zzibVar.zzd();
            zzd.zzg();
            boolean z = false;
            Boolean valueOf = !zzd.zzd().contains("use_service") ? null : Boolean.valueOf(zzd.zzd().getBoolean("use_service", false));
            if (valueOf == null || !valueOf.booleanValue()) {
                zzibVar.zzaU();
                if (this.zzu.zzv().zzo() != 1) {
                    zzibVar.zzaV().zzk().zza("Checking service availability");
                    int zzai = zzibVar.zzk().zzai(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zzai == 0) {
                        zzibVar.zzaV().zzk().zza("Service available");
                    } else {
                        if (zzai == 1) {
                            zzibVar.zzaV().zzk().zza("Service missing");
                        } else if (zzai != 2) {
                            if (zzai == 3) {
                                zzibVar.zzaV().zze().zza("Service disabled");
                            } else if (zzai == 9) {
                                zzibVar.zzaV().zze().zza("Service invalid");
                            } else if (zzai != 18) {
                                zzibVar.zzaV().zze().zzb("Unexpected service status", Integer.valueOf(zzai));
                            } else {
                                zzibVar.zzaV().zze().zza("Service updating");
                            }
                            r2 = false;
                        } else {
                            zzibVar.zzaV().zzj().zza("Service container out of date");
                            if (zzibVar.zzk().zzah() >= 17443) {
                                z = valueOf == null;
                                r2 = false;
                            }
                        }
                        if (z && zzibVar.zzc().zzE()) {
                            zzibVar.zzaV().zzb().zza("No way to upload. Consider using the full version of Analytics");
                        } else if (r2) {
                            zzhg zzd2 = zzibVar.zzd();
                            zzd2.zzg();
                            SharedPreferences.Editor edit = zzd2.zzd().edit();
                            edit.putBoolean("use_service", z);
                            edit.apply();
                        }
                        r2 = z;
                    }
                }
                z = true;
                if (z) {
                }
                if (r2) {
                }
                r2 = z;
            }
            this.zzc = Boolean.valueOf(r2);
        }
        return this.zzc.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzL(zzga zzgaVar) {
        zzg();
        Preconditions.checkNotNull(zzgaVar);
        this.zzb = zzgaVar;
        zzV();
        zzX();
    }

    public final void zzM() {
        zzg();
        zzb();
        zzne zzneVar = this.zza;
        zzneVar.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaY(), zzneVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzN(com.google.android.gms.internal.measurement.zzcu zzcuVar, zzbg zzbgVar, String str) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzk().zzai(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzibVar.zzaV().zze().zza("Not bundling data. Service unavailable or out of date");
            zzibVar.zzk().zzao(zzcuVar, new byte[0]);
            return;
        }
        zzaf(new zzmo(this, zzbgVar, str, zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzah() >= ((Integer) zzfx.zzaJ.zzb(null)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzP() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzah() >= 241200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ() {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgaVar.zzy(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgaVar.zzz(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzga zzgaVar;
        synchronized (atomicReference) {
            try {
                zzgaVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaV().zzb().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgaVar == null) {
                this.zzu.zzaV().zzb().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.zzD(zzrVar, bundle, new zzmd(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(AtomicReference atomicReference, zzr zzrVar, zzon zzonVar) {
        zzga zzgaVar;
        synchronized (atomicReference) {
            try {
                zzgaVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaV().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgaVar == null) {
                this.zzu.zzaV().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.zzB(zzrVar, zzonVar, new zzme(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzr zzrVar, zzaf zzafVar) {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzgaVar.zzC(zzrVar, zzafVar);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzafVar.zza), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(ComponentName componentName) {
        zzg();
        if (this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaV().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzg();
            zzI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzne zzY() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzga zzZ() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaa(zzga zzgaVar) {
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ScheduledExecutorService zzab() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzac(ScheduledExecutorService scheduledExecutorService) {
        this.zze = scheduledExecutorService;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi() {
        zzg();
        zzb();
        zzaf(new zzmq(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(boolean z) {
        zzg();
        zzb();
        if (zzO()) {
            zzaf(new zzmr(this, zzah(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzk(boolean z) {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl() {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzR();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzm(zzga zzgaVar, AbstractSafeParcelable abstractSafeParcelable, zzr zzrVar) {
        zzib zzibVar;
        int i;
        zzr zzrVar2;
        long j;
        long j2;
        AbstractSafeParcelable abstractSafeParcelable2 = abstractSafeParcelable;
        zzg();
        zzb();
        zzad();
        zzib zzibVar2 = this.zzu;
        zzibVar2.zzc();
        zzr zzrVar3 = zzrVar;
        int i2 = 100;
        int i3 = 0;
        for (int i4 = 100; i3 < 1001 && i2 == i4; i4 = 100) {
            zzib zzibVar3 = this.zzu;
            ArrayList arrayList = new ArrayList();
            List zzm = zzibVar3.zzm().zzm(i4);
            if (zzm != null) {
                arrayList.addAll(zzm);
                i2 = zzm.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable2 != null && i2 < i4) {
                arrayList.add(new zzgj(abstractSafeParcelable2, zzrVar3.zzc, zzrVar3.zzj));
            }
            String str = null;
            boolean zzp = zzibVar2.zzc().zzp(null, zzfx.zzaO);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                zzgj zzgjVar = (zzgj) arrayList.get(i5);
                AbstractSafeParcelable abstractSafeParcelable3 = zzgjVar.zza;
                if (zzibVar2.zzc().zzp(str, zzfx.zzbc)) {
                    String str2 = zzgjVar.zzb;
                    if (!TextUtils.isEmpty(str2)) {
                        i = i5;
                        zzibVar = zzibVar2;
                        zzrVar2 = new zzr(zzrVar3.zza, zzrVar3.zzb, str2, zzgjVar.zzc, zzrVar3.zzd, zzrVar3.zze, zzrVar3.zzf, zzrVar3.zzg, zzrVar3.zzh, zzrVar3.zzi, zzrVar3.zzk, zzrVar3.zzl, zzrVar3.zzm, zzrVar3.zzn, zzrVar3.zzo, zzrVar3.zzp, zzrVar3.zzq, zzrVar3.zzr, zzrVar3.zzs, zzrVar3.zzt, zzrVar3.zzu, zzrVar3.zzv, zzrVar3.zzw, zzrVar3.zzx, zzrVar3.zzy, zzrVar3.zzz, zzrVar3.zzA, zzrVar3.zzB, zzrVar3.zzC, zzrVar3.zzD, zzrVar3.zzE);
                        if (!(abstractSafeParcelable3 instanceof zzbg)) {
                            if (zzp) {
                                try {
                                    zzib zzibVar4 = this.zzu;
                                    long currentTimeMillis = zzibVar4.zzaZ().currentTimeMillis();
                                    try {
                                        j2 = currentTimeMillis;
                                        j = zzibVar4.zzaZ().elapsedRealtime();
                                    } catch (RemoteException e) {
                                        e = e;
                                        j2 = currentTimeMillis;
                                        j = 0;
                                        this.zzu.zzaV().zzb().zzb("Failed to send event to the service", e);
                                        if (zzp && j2 != 0) {
                                            zzib zzibVar5 = this.zzu;
                                            zzgp.zza(zzibVar5).zzb(36301, 13, j2, zzibVar5.zzaZ().currentTimeMillis(), (int) (zzibVar5.zzaZ().elapsedRealtime() - j));
                                        }
                                        str = null;
                                        i5 = i + 1;
                                        zzrVar3 = zzrVar2;
                                        zzibVar2 = zzibVar;
                                    }
                                } catch (RemoteException e2) {
                                    e = e2;
                                    j = 0;
                                    j2 = 0;
                                }
                            } else {
                                j = 0;
                                j2 = 0;
                            }
                            try {
                                zzgaVar.zze((zzbg) abstractSafeParcelable3, zzrVar2);
                                if (zzp) {
                                    zzibVar.zzaV().zzk().zza("Logging telemetry for logEvent from database");
                                    zzib zzibVar6 = this.zzu;
                                    zzgp.zza(zzibVar6).zzb(36301, 0, j2, zzibVar6.zzaZ().currentTimeMillis(), (int) (zzibVar6.zzaZ().elapsedRealtime() - j));
                                }
                            } catch (RemoteException e3) {
                                e = e3;
                                this.zzu.zzaV().zzb().zzb("Failed to send event to the service", e);
                                if (zzp) {
                                    zzib zzibVar52 = this.zzu;
                                    zzgp.zza(zzibVar52).zzb(36301, 13, j2, zzibVar52.zzaZ().currentTimeMillis(), (int) (zzibVar52.zzaZ().elapsedRealtime() - j));
                                }
                                str = null;
                                i5 = i + 1;
                                zzrVar3 = zzrVar2;
                                zzibVar2 = zzibVar;
                            }
                        } else if (abstractSafeParcelable3 instanceof zzpk) {
                            try {
                                zzgaVar.zzf((zzpk) abstractSafeParcelable3, zzrVar2);
                            } catch (RemoteException e4) {
                                this.zzu.zzaV().zzb().zzb("Failed to send user property to the service", e4);
                            }
                        } else if (abstractSafeParcelable3 instanceof zzah) {
                            try {
                                zzgaVar.zzn((zzah) abstractSafeParcelable3, zzrVar2);
                            } catch (RemoteException e5) {
                                this.zzu.zzaV().zzb().zzb("Failed to send conditional user property to the service", e5);
                            }
                        } else {
                            zzib zzibVar7 = this.zzu;
                            str = null;
                            if (!zzibVar7.zzc().zzp(null, zzfx.zzbc) || !(abstractSafeParcelable3 instanceof zzbe)) {
                                zzibVar7.zzaV().zzb().zza("Discarding data. Unrecognized parcel type.");
                            } else {
                                try {
                                    zzgaVar.zzu(((zzbe) abstractSafeParcelable3).zzf(), zzrVar2);
                                } catch (RemoteException e6) {
                                    this.zzu.zzaV().zzb().zzb("Failed to send default event parameters to the service", e6);
                                }
                            }
                            i5 = i + 1;
                            zzrVar3 = zzrVar2;
                            zzibVar2 = zzibVar;
                        }
                        str = null;
                        i5 = i + 1;
                        zzrVar3 = zzrVar2;
                        zzibVar2 = zzibVar;
                    }
                }
                zzibVar = zzibVar2;
                i = i5;
                zzrVar2 = zzrVar3;
                if (!(abstractSafeParcelable3 instanceof zzbg)) {
                }
                str = null;
                i5 = i + 1;
                zzrVar3 = zzrVar2;
                zzibVar2 = zzibVar;
            }
            i3++;
            abstractSafeParcelable2 = abstractSafeParcelable;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzn(zzbg zzbgVar, String str) {
        Preconditions.checkNotNull(zzbgVar);
        zzg();
        zzb();
        zzad();
        zzaf(new zzms(this, true, zzah(true), this.zzu.zzm().zzi(zzbgVar), zzbgVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzb();
        this.zzu.zzaU();
        zzaf(new zzmt(this, true, zzah(true), this.zzu.zzm().zzk(zzahVar), new zzah(zzahVar), zzahVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzaf(new zzmu(this, atomicReference, null, str2, str3, zzah(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzs(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2) {
        zzg();
        zzb();
        zzaf(new zzmv(this, str, str2, zzah(false), zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzt(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmw(this, atomicReference, null, str2, str3, zzah(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzu(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmb(this, str, str2, zzah(false), z, zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv(AtomicReference atomicReference, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmc(this, atomicReference, zzah(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzS(atomicReference, zzah, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzx(final AtomicReference atomicReference, final zzon zzonVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzT(atomicReference, zzah, zzonVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzy(final zzaf zzafVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(true);
        Preconditions.checkNotNull(zzah);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzni
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzU(zzah, zzafVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzao zzz() {
        zzg();
        zzb();
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            zzI();
            this.zzu.zzaV().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzah = zzah(false);
        Preconditions.checkNotNull(zzah);
        try {
            zzao zzw = zzgaVar.zzw(zzah);
            zzV();
            return zzw;
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }
}
