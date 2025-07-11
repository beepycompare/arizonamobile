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
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgy extends zzor {
    public zzgy(zzpf zzpfVar) {
        super(zzpfVar);
    }

    public final boolean zzb() {
        zzay();
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

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc(String str, zzos zzosVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgv zzgvVar) {
        zzgy zzgyVar;
        String str2;
        URL url;
        byte[] zzcc;
        zzg();
        zzay();
        try {
            url = new URI(zzosVar.zza()).toURL();
            this.zzg.zzp();
            zzcc = zzibVar.zzcc();
            zzgyVar = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgyVar = this;
            str2 = str;
        }
        try {
            this.zzu.zzaW().zzm(new zzgx(zzgyVar, str2, url, zzcc, zzosVar.zzb(), zzgvVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgyVar.zzu.zzaV().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgt.zzl(str2), zzosVar.zza());
        }
    }

    public final void zzd(zzh zzhVar, Map map, zzgv zzgvVar) {
        zzgy zzgyVar;
        URL url;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzgvVar);
        zzot zzf = this.zzg.zzf();
        Uri.Builder builder = new Uri.Builder();
        String zzf2 = zzhVar.zzf();
        Uri.Builder encodedAuthority = builder.scheme((String) zzfx.zze.zzb(null)).encodedAuthority((String) zzfx.zzf.zzb(null));
        String.valueOf(zzf2);
        Uri.Builder appendQueryParameter = encodedAuthority.path("config/app/".concat(String.valueOf(zzf2))).appendQueryParameter("platform", ConstantDeviceInfo.APP_PLATFORM);
        zzf.zzu.zzc().zzi();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(130000L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            url = new URI(uri).toURL();
            zzgyVar = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgyVar = this;
        }
        try {
            this.zzu.zzaW().zzm(new zzgx(zzgyVar, zzhVar.zzc(), url, null, map, zzgvVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgyVar.zzu.zzaV().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgt.zzl(zzhVar.zzc()), uri);
        }
    }
}
