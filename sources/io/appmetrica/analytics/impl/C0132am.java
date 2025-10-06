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
public final class C0132am implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final C0313hm f799a;
    public final C0625u3 b;

    public C0132am() {
        this(new C0313hm(), new C0625u3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0442mm handle(ResponseDataHolder responseDataHolder) {
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
                C0313hm c0313hm = this.f799a;
                c0313hm.getClass();
                C0442mm c0442mm = new C0442mm();
                try {
                    c0313hm.i.getClass();
                    Fb fb = new Fb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = fb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0442mm.h = str2;
                    c0442mm.i = str;
                    c0313hm.a(c0442mm, fb);
                    c0442mm.f996a = TextUtils.isEmpty(c0442mm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0442mm = new C0442mm();
                    c0442mm.f996a = 1;
                }
                if (2 == c0442mm.f996a) {
                    return c0442mm;
                }
            }
        }
        return null;
    }

    public C0132am(C0313hm c0313hm, C0625u3 c0625u3) {
        this.f799a = c0313hm;
        this.b = c0625u3;
    }
}
