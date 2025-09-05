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
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0131am implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final C0312hm f794a;
    public final C0624u3 b;

    public C0131am() {
        this(new C0312hm(), new C0624u3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0441mm handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!ro.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                C0312hm c0312hm = this.f794a;
                c0312hm.getClass();
                C0441mm c0441mm = new C0441mm();
                try {
                    c0312hm.i.getClass();
                    Fb fb = new Fb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = fb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0441mm.h = str2;
                    c0441mm.i = str;
                    c0312hm.a(c0441mm, fb);
                    c0441mm.f991a = TextUtils.isEmpty(c0441mm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0441mm = new C0441mm();
                    c0441mm.f991a = 1;
                }
                if (2 == c0441mm.f991a) {
                    return c0441mm;
                }
            }
        }
        return null;
    }

    public C0131am(C0312hm c0312hm, C0624u3 c0624u3) {
        this.f794a = c0312hm;
        this.b = c0624u3;
    }
}
