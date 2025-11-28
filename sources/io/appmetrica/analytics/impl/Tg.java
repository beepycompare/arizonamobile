package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Tg extends Wg {
    public Tg(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        String value = w5.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                zo zoVar = this.f744a.t;
                synchronized (zoVar) {
                    zoVar.c(zoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    w5.n = Boolean.TRUE;
                    b();
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void b() {
        zo zoVar = this.f744a.t;
        synchronized (zoVar) {
            zoVar.a(zoVar.a() + 1);
        }
        this.f744a.z();
        R8 r8 = this.f744a.l;
        if (r8.c == null) {
            r8.a();
        }
        T8 t8 = r8.c;
        t8.getClass();
        t8.b = new HashSet();
        t8.d = 0;
        T8 t82 = r8.c;
        t82.f701a = true;
        W8 w8 = r8.b;
        IBinaryDataHelper iBinaryDataHelper = w8.c;
        V8 v8 = w8.b;
        w8.f742a.getClass();
        iBinaryDataHelper.insert("event_hashes", v8.toByteArray((V8) U8.a(t82)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0612u2 c0612u2 = this.f744a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0612u2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0612u2 c0612u2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0612u2 != null) {
            for (Pair pair : c0612u2.f1142a) {
                if (no.a(pair.first, str) && ((obj = pair.second) == null || ((C0587t2) obj).f1123a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
