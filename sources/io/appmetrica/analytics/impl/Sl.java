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
/* loaded from: classes5.dex */
public final class Sl implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Zl f780a;
    public final W2 b;

    public Sl() {
        this(new Zl(), new W2());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0226em handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!mo.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Zl zl = this.f780a;
                zl.getClass();
                C0226em c0226em = new C0226em();
                try {
                    zl.h.getClass();
                    C0267gb c0267gb = new C0267gb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = c0267gb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0226em.h = str2;
                    c0226em.i = str;
                    zl.a(c0226em, c0267gb);
                    c0226em.f973a = TextUtils.isEmpty(c0226em.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0226em = new C0226em();
                    c0226em.f973a = 1;
                }
                if (2 == c0226em.f973a) {
                    return c0226em;
                }
            }
        }
        return null;
    }

    public Sl(Zl zl, W2 w2) {
        this.f780a = zl;
        this.b = w2;
    }
}
