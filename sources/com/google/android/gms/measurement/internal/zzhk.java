package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhk extends zzpg {
    public zzhk(zzpv zzpvVar) {
        super(zzpvVar);
    }

    public final void zza(zzh zzhVar, Map map, zzhg zzhgVar) {
        zzhk zzhkVar;
        URL url;
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzhgVar);
        zzpi zzy = this.zzg.zzy();
        Uri.Builder builder = new Uri.Builder();
        String zzH = zzhVar.zzH();
        if (TextUtils.isEmpty(zzH)) {
            zzH = zzhVar.zzA();
        }
        Uri.Builder appendQueryParameter = builder.scheme((String) zzgi.zze.zza(null)).encodedAuthority((String) zzgi.zzf.zza(null)).path("config/app/".concat(String.valueOf(zzH))).appendQueryParameter("platform", ConstantDeviceInfo.APP_PLATFORM);
        zzy.zzu.zzf().zzj();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(119002L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            url = new URI(uri).toURL();
            zzhkVar = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzhkVar = this;
        }
        try {
            this.zzu.zzaX().zzp(new zzhi(zzhkVar, zzhVar.zzC(), url, null, map, zzhgVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzhkVar.zzu.zzaW().zze().zzc("Failed to parse config URL. Not fetching. appId", zzhe.zzn(zzhVar.zzC()), uri);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    public final void zzc(String str, zzph zzphVar, com.google.android.gms.internal.measurement.zzhv zzhvVar, zzhg zzhgVar) {
        zzhk zzhkVar;
        String str2;
        URL url;
        byte[] zzcd;
        zzg();
        zzav();
        try {
            url = new URI(zzphVar.zzc()).toURL();
            this.zzg.zzA();
            zzcd = zzhvVar.zzcd();
            zzhkVar = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzhkVar = this;
            str2 = str;
        }
        try {
            this.zzu.zzaX().zzp(new zzhi(zzhkVar, str2, url, zzcd, zzphVar.zzd(), zzhgVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzhkVar.zzu.zzaW().zze().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzhe.zzn(str2), zzphVar.zzc());
        }
    }

    public final boolean zzd() {
        zzav();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaT().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}
