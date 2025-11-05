package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class Vl implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final C0176cm f737a;
    public final C0183d3 b;

    public Vl() {
        this(new C0176cm(), new C0183d3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0305hm handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!no.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                C0176cm c0176cm = this.f737a;
                c0176cm.getClass();
                C0305hm c0305hm = new C0305hm();
                try {
                    c0176cm.h.getClass();
                    C0422mb c0422mb = new C0422mb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = c0422mb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0305hm.h = str2;
                    c0305hm.i = str;
                    c0176cm.a(c0305hm, c0422mb);
                    c0305hm.f917a = TextUtils.isEmpty(c0305hm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0305hm = new C0305hm();
                    c0305hm.f917a = 1;
                }
                if (2 == c0305hm.f917a) {
                    return c0305hm;
                }
            }
        }
        return null;
    }

    public Vl(C0176cm c0176cm, C0183d3 c0183d3) {
        this.f737a = c0176cm;
        this.b = c0183d3;
    }
}
