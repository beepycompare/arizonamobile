package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzhh implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbq zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzhi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(zzhi zzhiVar, com.google.android.gms.internal.measurement.zzbq zzbqVar, ServiceConnection serviceConnection) {
        this.zza = zzbqVar;
        this.zzb = serviceConnection;
        Objects.requireNonNull(zzhiVar);
        this.zzc = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzhi zzhiVar = this.zzc;
        zzhj zzhjVar = zzhiVar.zza;
        zzib zzibVar = zzhjVar.zza;
        zzibVar.zzaW().zzg();
        Bundle bundle2 = new Bundle();
        String zza = zzhiVar.zza();
        bundle2.putString("package_name", zza);
        try {
            bundle = this.zza.zze(bundle2);
        } catch (Exception e) {
            zzhjVar.zza.zzaV().zzb().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        if (bundle == null) {
            zzibVar.zzaV().zzb().zza("Install Referrer Service returned a null response");
            bundle = null;
        }
        zzib zzibVar2 = zzhjVar.zza;
        zzibVar2.zzaW().zzg();
        zzib.zzL();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzibVar2.zzaV().zze().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString(Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzibVar2.zzaV().zzb().zza("No referrer defined in Install Referrer response");
                } else {
                    zzibVar2.zzaV().zzk().zzb("InstallReferrer API result", string);
                    Bundle zzi = zzibVar2.zzk().zzi(Uri.parse("?".concat(string)));
                    if (zzi == null) {
                        zzibVar2.zzaV().zzb().zza("No campaign params defined in Install Referrer result");
                    } else {
                        List asList = Arrays.asList(((String) zzfx.zzbh.zzb(null)).split(StringUtils.COMMA));
                        Iterator<String> it = zzi.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (asList.contains(it.next())) {
                                long j2 = bundle.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                                if (j2 > 0) {
                                    zzi.putLong("click_timestamp", j2);
                                }
                            }
                        }
                        if (j == zzibVar2.zzd().zzd.zza()) {
                            zzibVar2.zzaV().zzk().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzibVar2.zzB()) {
                            zzibVar2.zzd().zzd.zzb(j);
                            zzibVar2.zzaV().zzk().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzi.putString("_cis", "referrer API v2");
                            zzibVar2.zzj().zzI("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi, zza);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzibVar2.zzaY(), this.zzb);
    }
}
