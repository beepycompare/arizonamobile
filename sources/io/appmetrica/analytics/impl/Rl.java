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
public final class Rl implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Yl f628a;
    public final C0547r3 b;

    public Rl() {
        this(new Yl(), new C0547r3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final C0216dm handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!io.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Yl yl = this.f628a;
                yl.getClass();
                C0216dm c0216dm = new C0216dm();
                try {
                    yl.i.getClass();
                    Ab ab = new Ab(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = ab.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    c0216dm.h = str2;
                    c0216dm.i = str;
                    yl.a(c0216dm, ab);
                    c0216dm.f820a = TextUtils.isEmpty(c0216dm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    c0216dm = new C0216dm();
                    c0216dm.f820a = 1;
                }
                if (2 == c0216dm.f820a) {
                    return c0216dm;
                }
            }
        }
        return null;
    }

    public Rl(Yl yl, C0547r3 c0547r3) {
        this.f628a = yl;
        this.b = c0547r3;
    }
}
