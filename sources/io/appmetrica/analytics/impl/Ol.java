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
public final class Ol implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Vl f570a;
    public final C0545r3 b;

    public Ol() {
        this(new Vl(), new C0545r3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0138am handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!fo.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Vl vl = this.f570a;
                vl.getClass();
                C0138am c0138am = new C0138am();
                try {
                    vl.i.getClass();
                    C0728yb c0728yb = new C0728yb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = c0728yb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0138am.h = str2;
                    c0138am.i = str;
                    vl.a(c0138am, c0728yb);
                    c0138am.f758a = TextUtils.isEmpty(c0138am.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0138am = new C0138am();
                    c0138am.f758a = 1;
                }
                if (2 == c0138am.f758a) {
                    return c0138am;
                }
            }
        }
        return null;
    }

    public Ol(Vl vl, C0545r3 c0545r3) {
        this.f570a = vl;
        this.b = c0545r3;
    }
}
