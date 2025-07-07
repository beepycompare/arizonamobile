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
    public final Vl f569a;
    public final C0553r3 b;

    public Ol() {
        this(new Vl(), new C0553r3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0146am handle(ResponseDataHolder responseDataHolder) {
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
                Vl vl = this.f569a;
                vl.getClass();
                C0146am c0146am = new C0146am();
                try {
                    vl.i.getClass();
                    C0736yb c0736yb = new C0736yb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = c0736yb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0146am.h = str2;
                    c0146am.i = str;
                    vl.a(c0146am, c0736yb);
                    c0146am.f757a = TextUtils.isEmpty(c0146am.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0146am = new C0146am();
                    c0146am.f757a = 1;
                }
                if (2 == c0146am.f757a) {
                    return c0146am;
                }
            }
        }
        return null;
    }

    public Ol(Vl vl, C0553r3 c0553r3) {
        this.f569a = vl;
        this.b = c0553r3;
    }
}
