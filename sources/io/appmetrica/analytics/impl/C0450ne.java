package io.appmetrica.analytics.impl;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0450ne {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1025a;

    public C0450ne() {
        HashMap hashMap = new HashMap();
        this.f1025a = hashMap;
        hashMap.put("google_aid", "g");
        hashMap.put("huawei_oaid", CmcdData.STREAMING_FORMAT_HLS);
        hashMap.put("sim_info", "si");
        hashMap.put("features_collecting", "fc");
        hashMap.put("permissions_collecting", "pc");
        hashMap.put("retry_policy", "rp");
        hashMap.put("cache_control", "cc");
        hashMap.put("attribution", "at");
        hashMap.put("startup_update", CmcdConfiguration.KEY_STARTUP);
        hashMap.put("ssl_pinning", "sp");
        hashMap.put("external_attribution", "exta");
    }

    public final String a(String str) {
        return this.f1025a.containsKey(str) ? (String) this.f1025a.get(str) : str;
    }
}
