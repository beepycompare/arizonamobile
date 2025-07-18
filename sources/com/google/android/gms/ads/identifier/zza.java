package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-identifier@@18.2.0 */
/* loaded from: classes3.dex */
public final class zza extends Thread {
    final /* synthetic */ Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zza = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        Map map = this.zza;
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zze.zza(buildUpon.build().toString());
    }
}
