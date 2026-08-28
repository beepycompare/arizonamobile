package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitorKt;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzkl;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzkr;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class zzbw implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final BillingClientStateListener zzb;
    private final com.google.android.gms.internal.play_billing.zzbl zzc;
    private final com.google.android.gms.internal.play_billing.zzbl zzd;
    private final int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbw(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, int i, zzch zzchVar) {
        com.google.android.gms.internal.play_billing.zzbo zzboVar;
        com.google.android.gms.internal.play_billing.zzbo zzboVar2;
        Objects.requireNonNull(billingClientImpl);
        this.zza = billingClientImpl;
        zzboVar = billingClientImpl.zzK;
        this.zzc = com.google.android.gms.internal.play_billing.zzbl.zzc(zzboVar);
        zzboVar2 = billingClientImpl.zzK;
        this.zzd = com.google.android.gms.internal.play_billing.zzbl.zzc(zzboVar2);
        this.zzb = billingClientStateListener;
        this.zze = i;
    }

    public static /* synthetic */ Object zza(zzbw zzbwVar) {
        Object obj;
        int i;
        int i2;
        Bundle bundle;
        Object obj2;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        Context context;
        zzjd zzjdVar;
        int i3;
        int i4;
        zzcz zzczVar;
        int zzc;
        int i5;
        String str;
        String str2;
        Long l;
        BillingClientImpl billingClientImpl = zzbwVar.zza;
        obj = billingClientImpl.zza;
        synchronized (obj) {
            i = billingClientImpl.zzb;
            if (i != 3) {
                i2 = billingClientImpl.zzb;
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                    str = billingClientImpl.zzc;
                    str2 = billingClientImpl.zzd;
                    l = billingClientImpl.zzJ;
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, l.longValue());
                }
                zzjd zzjdVar2 = zzjd.REASON_UNSPECIFIED;
                obj2 = billingClientImpl.zza;
                synchronized (obj2) {
                    zzapVar = billingClientImpl.zzi;
                }
                if (zzapVar == null) {
                    BillingClientImpl billingClientImpl2 = zzbwVar.zza;
                    billingClientImpl2.zzbg(0);
                    int i6 = zzbwVar.zze;
                    zzjd zzjdVar3 = zzjd.SERVICE_RESET_TO_NULL;
                    BillingResult billingResult = zzdc.zzj;
                    billingClientImpl2.zzbf(zzjdVar3, billingResult, i6);
                    zzbwVar.zzg(billingResult);
                } else {
                    BillingClientImpl billingClientImpl3 = zzbwVar.zza;
                    context = billingClientImpl3.zzg;
                    String packageName = context.getPackageName();
                    int i7 = 27;
                    int i8 = 3;
                    int i9 = 27;
                    while (true) {
                        if (i9 < 3) {
                            i9 = 0;
                            break;
                        }
                        try {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "trying subs apiVersion: " + i9);
                            if (bundle == null) {
                                i8 = zzapVar.zzb(i9, packageName, "subs");
                            } else {
                                i8 = zzapVar.zzc(i9, packageName, "subs", bundle);
                            }
                            if (i8 == 0) {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "highestLevelSupportedForSubs: " + i9);
                                break;
                            }
                            i9--;
                        } catch (Exception e) {
                            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                            if (e instanceof DeadObjectException) {
                                zzjdVar = zzjd.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION;
                            } else if (e instanceof RemoteException) {
                                zzjdVar = zzjd.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION;
                            } else {
                                zzjdVar = e instanceof SecurityException ? zzjd.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzjd.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
                            }
                            zzjd zzjdVar4 = zzjdVar;
                            String zza = zzjdVar4.equals(zzjd.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? zzcy.zza(e) : null;
                            zzbwVar.zza.zzbg(0);
                            zzbwVar.zzf(BillingClientImpl.zzm(e), zzjdVar4, zza, z, 0);
                            zzbwVar.zzg(BillingClientImpl.zzm(e));
                        }
                    }
                    billingClientImpl3.zzl = i9 >= 5;
                    billingClientImpl3.zzk = i9 >= 3;
                    if (i9 < 3) {
                        zzjdVar2 = zzjd.SUBSCRIPTIONS_NOT_SUPPORTED;
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "In-app billing API does not support subscription on this device.");
                    }
                    while (true) {
                        if (i7 < 3) {
                            break;
                        }
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "trying inapp apiVersion: " + i7);
                        if (bundle == null) {
                            zzc = zzapVar.zzb(i7, packageName, "inapp");
                        } else {
                            zzc = zzapVar.zzc(i7, packageName, "inapp", bundle);
                        }
                        i8 = zzc;
                        if (i8 == 0) {
                            billingClientImpl3.zzm = i7;
                            i5 = billingClientImpl3.zzm;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "mHighestLevelSupportedForInApp: " + i5);
                            break;
                        }
                        i7--;
                    }
                    i3 = billingClientImpl3.zzm;
                    BillingClientImpl.zzak(billingClientImpl3, i3);
                    i4 = billingClientImpl3.zzm;
                    if (i4 < 3) {
                        zzjdVar2 = zzjd.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    }
                    zzjd zzjdVar5 = zzjdVar2;
                    BillingClientImpl.zzam(billingClientImpl3, i8);
                    if (i8 == 0) {
                        try {
                            Long zze = zzbwVar.zze(z);
                            if (z) {
                                zziy zza2 = zzja.zza();
                                zza2.zze(6);
                                zzks zza3 = zzku.zza();
                                int i10 = zzbwVar.zze;
                                zza3.zza(i10 > 0);
                                zza3.zzb(i10);
                                zza3.zzd(0);
                                if (zze != null) {
                                    zza3.zzc(zze.longValue());
                                }
                                BillingClientImpl billingClientImpl4 = zzbwVar.zza;
                                zza2.zzd(zza3);
                                billingClientImpl4.zzbe((zzja) zza2.zzi());
                            } else {
                                zzkl zza4 = zzkn.zza();
                                zzjb zza5 = zzjf.zza();
                                zza5.zzp(0);
                                zza5.zzc(0);
                                zza4.zza(zza5);
                                if (zze != null) {
                                    zza4.zzb(zze.longValue());
                                }
                                zzczVar = zzbwVar.zza.zzh;
                                zzczVar.zzj((zzkn) zza4.zzi());
                            }
                        } catch (Throwable th) {
                            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
                        }
                        zzbwVar.zzg(zzdc.zzi);
                    } else {
                        BillingResult billingResult2 = zzdc.zzb;
                        zzbwVar.zzf(billingResult2, zzjdVar5, null, z, 0);
                        zzbwVar.zzg(billingResult2);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void zzb(zzbw zzbwVar) {
        BillingClientImpl billingClientImpl = zzbwVar.zza;
        billingClientImpl.zzbg(0);
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbf(zzjdVar, billingResult, zzbwVar.zze);
        zzbwVar.zzg(billingResult);
    }

    private final void zzf(BillingResult billingResult, zzjd zzjdVar, String str, boolean z, int i) {
        zzcz zzczVar;
        try {
            zzjb zza = zzjf.zza();
            zza.zzp(billingResult.getResponseCode());
            zza.zzb(billingResult.getDebugMessage());
            zza.zze(zzjdVar);
            zza.zzc(0);
            if (str != null) {
                zza.zza(str);
            }
            Long zze = zze(z);
            if (z) {
                zzks zza2 = zzku.zza();
                int i2 = this.zze;
                zza2.zza(i2 > 0);
                zza2.zzb(i2);
                zza2.zzd(0);
                if (zze != null) {
                    zza2.zzc(zze.longValue());
                }
                BillingClientImpl billingClientImpl = this.zza;
                zziu zza3 = zziw.zza();
                zza3.zzb(zza);
                zza3.zzp(6);
                zza3.zze(zza2);
                billingClientImpl.zzbc((zziw) zza3.zzi());
                return;
            }
            zzkl zza4 = zzkn.zza();
            zza4.zza(zza);
            if (zze != null) {
                zza4.zzb(zze.longValue());
            }
            zzczVar = this.zza.zzh;
            zzczVar.zzj((zzkn) zza4.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzg(BillingResult billingResult) {
        Object obj;
        int i;
        BillingClientImpl billingClientImpl = this.zza;
        obj = billingClientImpl.zza;
        synchronized (obj) {
            i = billingClientImpl.zzb;
            if (i == 3) {
                return;
            }
            try {
                this.zzb.onBillingSetupFinished(billingResult);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingSetupFinished.", th);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        Object obj;
        int i;
        int i2;
        zzcz zzczVar;
        zzcz zzczVar2;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing service died.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzaq(billingClientImpl)) {
                zzczVar2 = billingClientImpl.zzh;
                zziu zza = zziw.zza();
                zza.zzp(6);
                zzjb zza2 = zzjf.zza();
                zza2.zze(zzjd.BINDING_DIED);
                zza.zzb(zza2);
                zzks zza3 = zzku.zza();
                int i3 = this.zze;
                zza3.zza(i3 > 0);
                zza3.zzb(i3);
                zza.zze(zza3);
                zzczVar2.zza((zziw) zza.zzi());
            } else {
                zzczVar = billingClientImpl.zzh;
                zzczVar.zzi(zzji.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        obj = billingClientImpl2.zza;
        synchronized (obj) {
            i = billingClientImpl2.zzb;
            if (i != 3) {
                i2 = billingClientImpl2.zzb;
                if (i2 != 0) {
                    billingClientImpl2.zzbg(0);
                    billingClientImpl2.zzbj();
                    try {
                        this.zzb.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                    }
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        int i;
        Handler zzav;
        BillingResult zzay;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service connected.");
        BillingClientImpl billingClientImpl = this.zza;
        obj = billingClientImpl.zza;
        synchronized (obj) {
            i = billingClientImpl.zzb;
            if (i == 3) {
                return;
            }
            billingClientImpl.zzi = com.google.android.gms.internal.play_billing.zzao.zzt(iBinder);
            Callable callable = new Callable() { // from class: com.android.billingclient.api.zzbu
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzbw.zza(zzbw.this);
                    return null;
                }
            };
            Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.zzbv
                @Override // java.lang.Runnable
                public final void run() {
                    zzbw.zzb(zzbw.this);
                }
            };
            zzav = billingClientImpl.zzav();
            if (BillingClientImpl.zzK(callable, ArchiveNetworkMonitorKt.ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS, runnable, zzav, billingClientImpl.zzJ()) == null) {
                int i2 = this.zze;
                zzay = billingClientImpl.zzay();
                billingClientImpl.zzbf(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, zzay, i2);
                zzg(zzay);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        int i;
        zzcz zzczVar;
        zzcz zzczVar2;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing service disconnected.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzaq(billingClientImpl)) {
                zzczVar2 = billingClientImpl.zzh;
                zziu zza = zziw.zza();
                zza.zzp(6);
                zzjb zza2 = zzjf.zza();
                zza2.zze(zzjd.SERVICE_DISCONNECTED);
                zza.zzb(zza2);
                zzks zza3 = zzku.zza();
                int i2 = this.zze;
                zza3.zza(i2 > 0);
                zza3.zzb(i2);
                zza.zze(zza3);
                zzczVar2.zza((zziw) zza.zzi());
            } else {
                zzczVar = billingClientImpl.zzh;
                zzczVar.zzk(zzkr.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        obj = billingClientImpl2.zza;
        synchronized (obj) {
            com.google.android.gms.internal.play_billing.zzbl zzblVar = this.zzd;
            zzblVar.zzd();
            zzblVar.zze();
            i = billingClientImpl2.zzb;
            if (i == 3) {
                return;
            }
            billingClientImpl2.zzbg(0);
            try {
                this.zzb.onBillingServiceDisconnected();
            } catch (Throwable th2) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
            }
        }
    }

    public final void zzc() {
        Object obj;
        obj = this.zza.zza;
        synchronized (obj) {
            com.google.android.gms.internal.play_billing.zzbl zzblVar = this.zzc;
            zzblVar.zzd();
            zzblVar.zze();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zze > 0;
    }

    private final Long zze(boolean z) {
        Object obj;
        Object obj2;
        BillingClientImpl billingClientImpl = this.zza;
        try {
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception getting connection establishment duration.", th);
        }
        if (z) {
            obj2 = billingClientImpl.zza;
            synchronized (obj2) {
                com.google.android.gms.internal.play_billing.zzbl zzblVar = this.zzc;
                if (zzblVar.zzg()) {
                    zzblVar.zzf();
                    return Long.valueOf(zzblVar.zza(TimeUnit.MILLISECONDS));
                }
                return null;
            }
        }
        obj = billingClientImpl.zza;
        synchronized (obj) {
            com.google.android.gms.internal.play_billing.zzbl zzblVar2 = this.zzd;
            if (zzblVar2.zzg()) {
                zzblVar2.zzf();
                return Long.valueOf(zzblVar2.zza(TimeUnit.MILLISECONDS));
            }
            return null;
        }
    }
}
