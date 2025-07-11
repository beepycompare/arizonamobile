package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.messaging.Constants;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzx {
    private final zzib zza;

    public zzx(zzib zzibVar) {
        this.zza = zzibVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzib zzibVar = this.zza;
        zzibVar.zzaW().zzg();
        if (zze()) {
            if (zzd()) {
                zzibVar.zzd().zzr.zzb(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                zzibVar.zzj().zzF("auto", "_cmpx", bundle);
            } else {
                String zza = zzibVar.zzd().zzr.zza();
                if (TextUtils.isEmpty(zza)) {
                    zzibVar.zzaV().zzc().zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = zzibVar.zzd().zzs.zza() / 3600000;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (zza2 - 1) * 3600000);
                    zzibVar.zzj().zzF(pair.first == null ? "app" : (String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                zzibVar.zzd().zzr.zzb(null);
            }
            zzibVar.zzd().zzs.zzb(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(String str, Bundle bundle) {
        String uri;
        zzib zzibVar = this.zza;
        zzibVar.zzaW().zzg();
        if (zzibVar.zzB()) {
            return;
        }
        if (bundle.isEmpty()) {
            uri = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            uri = builder.build().toString();
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        zzibVar.zzd().zzr.zzb(uri);
        zzibVar.zzd().zzs.zzb(zzibVar.zzaZ().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        if (zze() && zzd()) {
            this.zza.zzd().zzr.zzb(null);
        }
    }

    final boolean zzd() {
        if (zze()) {
            zzib zzibVar = this.zza;
            return zzibVar.zzaZ().currentTimeMillis() - zzibVar.zzd().zzs.zza() > zzibVar.zzc().zzl(null, zzfx.zzaj);
        }
        return false;
    }

    final boolean zze() {
        return this.zza.zzd().zzs.zza() > 0;
    }
}
