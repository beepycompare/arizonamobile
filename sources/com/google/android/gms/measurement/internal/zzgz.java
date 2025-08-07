package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgz extends zzos {
    public zzgz(zzpg zzpgVar) {
        super(zzpgVar);
    }

    public final boolean zzb() {
        zzaw();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaY().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc(String str, zzot zzotVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgw zzgwVar) {
        zzgz zzgzVar;
        String str2;
        URL url;
        byte[] zzcc;
        zzg();
        zzaw();
        try {
            url = new URI(zzotVar.zza()).toURL();
            this.zzg.zzp();
            zzcc = zzibVar.zzcc();
            zzgzVar = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
            str2 = str;
        }
        try {
            this.zzu.zzaW().zzm(new zzgy(zzgzVar, str2, url, zzcc, zzotVar.zzb(), zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.zzu.zzaV().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgu.zzl(str2), zzotVar.zza());
        }
    }

    public final void zzd(zzh zzhVar, Map map, zzgw zzgwVar) {
        zzgz zzgzVar;
        URL url;
        zzg();
        zzaw();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzgwVar);
        zzou zzf = this.zzg.zzf();
        Uri.Builder builder = new Uri.Builder();
        String zzf2 = zzhVar.zzf();
        Uri.Builder encodedAuthority = builder.scheme((String) zzfy.zze.zzb(null)).encodedAuthority((String) zzfy.zzf.zzb(null));
        String.valueOf(zzf2);
        Uri.Builder appendQueryParameter = encodedAuthority.path("config/app/".concat(String.valueOf(zzf2))).appendQueryParameter("platform", ConstantDeviceInfo.APP_PLATFORM);
        zzf.zzu.zzc().zzi();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            url = new URI(uri).toURL();
            zzgzVar = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
        }
        try {
            this.zzu.zzaW().zzm(new zzgy(zzgzVar, zzhVar.zzc(), url, null, map, zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.zzu.zzaV().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgu.zzl(zzhVar.zzc()), uri);
        }
    }
}
