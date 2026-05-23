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
/* renamed from: io.appmetrica.analytics.impl.tm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0620tm implements NetworkResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Am f1219a;
    public final C0317i3 b;

    public C0620tm() {
        this(new Am(), new C0317i3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a */
    public final Fm handle(ResponseDataHolder responseDataHolder) {
        String str;
        String str2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, HttpHeaders.CONTENT_ENCODING) : null;
            if (!Oo.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Am am = this.f1219a;
                am.getClass();
                Fm fm = new Fm();
                try {
                    am.h.getClass();
                    Hb hb = new Hb(new String(responseData, "UTF-8"));
                    JSONObject optJSONObject = hb.optJSONObject("device_id");
                    if (optJSONObject == null) {
                        str = "";
                        str2 = "";
                    } else {
                        str = optJSONObject.optString("hash");
                        str2 = optJSONObject.optString("value");
                    }
                    fm.h = str2;
                    fm.i = str;
                    am.a(fm, hb);
                    fm.f550a = TextUtils.isEmpty(fm.i) ? 1 : 2;
                } catch (Throwable unused) {
                    fm = new Fm();
                    fm.f550a = 1;
                }
                if (2 == fm.f550a) {
                    return fm;
                }
            }
        }
        return null;
    }

    public C0620tm(Am am, C0317i3 c0317i3) {
        this.f1219a = am;
        this.b = c0317i3;
    }
}
