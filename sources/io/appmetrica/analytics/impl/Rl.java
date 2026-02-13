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
public final class Rl implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Yl f770a;
    public final V2 b;

    public Rl() {
        this(new Yl(), new V2());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0206dm handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!lo.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Yl yl = this.f770a;
                yl.getClass();
                C0206dm c0206dm = new C0206dm();
                try {
                    yl.h.getClass();
                    C0246fb c0246fb = new C0246fb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = c0246fb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0206dm.h = str2;
                    c0206dm.i = str;
                    yl.a(c0206dm, c0246fb);
                    c0206dm.f962a = TextUtils.isEmpty(c0206dm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0206dm = new C0206dm();
                    c0206dm.f962a = 1;
                }
                if (2 == c0206dm.f962a) {
                    return c0206dm;
                }
            }
        }
        return null;
    }

    public Rl(Yl yl, V2 v2) {
        this.f770a = yl;
        this.b = v2;
    }
}
