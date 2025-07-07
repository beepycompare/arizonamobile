package com.adjust.sdk.sig;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class Signer {

    /* renamed from: a  reason: collision with root package name */
    public boolean f183a = false;
    public d b;
    public a c;
    public c d;

    public static String getVersion() {
        return "3.35.2";
    }

    public final synchronized void a() {
        if (this.f183a) {
            return;
        }
        this.b = new d();
        this.d = new c(Build.VERSION.SDK_INT);
        this.c = new NativeLibHelper();
        this.f183a = true;
    }

    public synchronized void onResume() {
        a();
        d dVar = this.b;
        a aVar = this.c;
        dVar.getClass();
        if (!d.f185a) {
            ((NativeLibHelper) aVar).a();
        }
    }

    public synchronized void sign(Context context, Map<String, String> map, String str, String str2) {
        a();
        d dVar = this.b;
        c cVar = this.d;
        a aVar = this.c;
        dVar.getClass();
        d.a(context, cVar, aVar, map, str, str2);
    }

    public synchronized void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        a();
        d dVar = this.b;
        c cVar = this.d;
        a aVar = this.c;
        dVar.getClass();
        if (map != null && map.size() != 0 && map2 != null && map3 != null) {
            HashMap hashMap = new HashMap();
            d.a(map.keySet(), map, hashMap);
            String str = map2.get("activity_kind");
            String str2 = map2.get("client_sdk");
            if (!"b".equals(map2.get(CmcdData.OBJECT_TYPE_AUDIO_ONLY))) {
                d.a(context, cVar, aVar, hashMap, str, str2);
                if (hashMap.containsKey("signature") && hashMap.containsKey("adj_signing_id") && hashMap.containsKey("headers_id") && hashMap.containsKey("algorithm") && hashMap.containsKey("native_version")) {
                    Locale locale = Locale.US;
                    String str3 = "algorithm=\"" + ((String) hashMap.get("algorithm")) + "\"";
                    map3.put("authorization", "Signature " + ("signature=\"" + ((String) hashMap.get("signature")) + "\"") + StringUtils.COMMA + ("adj_signing_id=\"" + ((String) hashMap.get("adj_signing_id")) + "\"") + StringUtils.COMMA + str3 + StringUtils.COMMA + ("headers_id=\"" + ((String) hashMap.get("headers_id")) + "\"") + StringUtils.COMMA + ("native_version=\"" + ((String) hashMap.get("native_version")) + "\""));
                }
                Log.e("SignerInstance", "sign: Signature generation failed. Exiting...");
            }
            d.a(map.keySet(), map, map3);
            d.a(new HashSet(Arrays.asList("network_payload", "endpoint")), map2, map3);
        }
        Log.e("SignerInstance", "sign: One or more parameters are null");
    }
}
