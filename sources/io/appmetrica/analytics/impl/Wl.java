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
/* loaded from: classes4.dex */
public final class Wl implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final C0209dm f714a;
    public final C0545r3 b;

    public Wl() {
        this(new C0209dm(), new C0545r3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0337im handle(ResponseDataHolder responseDataHolder) {
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
                C0209dm c0209dm = this.f714a;
                c0209dm.getClass();
                C0337im c0337im = new C0337im();
                try {
                    c0209dm.i.getClass();
                    Cb cb = new Cb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = cb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0337im.h = str2;
                    c0337im.i = str;
                    c0209dm.a(c0337im, cb);
                    c0337im.f909a = TextUtils.isEmpty(c0337im.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0337im = new C0337im();
                    c0337im.f909a = 1;
                }
                if (2 == c0337im.f909a) {
                    return c0337im;
                }
            }
        }
        return null;
    }

    public Wl(C0209dm c0209dm, C0545r3 c0545r3) {
        this.f714a = c0209dm;
        this.b = c0545r3;
    }
}
