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
public final class Pg extends Sg {
    public Pg(Y4 y4) {
        super(y4);
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        String value = q5.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                yo yoVar = this.f776a.t;
                synchronized (yoVar) {
                    yoVar.c(yoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    q5.n = Boolean.TRUE;
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
        yo yoVar = this.f776a.t;
        synchronized (yoVar) {
            yoVar.a(yoVar.a() + 1);
        }
        this.f776a.z();
        N8 n8 = this.f776a.l;
        if (n8.c == null) {
            n8.a();
        }
        P8 p8 = n8.c;
        p8.getClass();
        p8.b = new HashSet();
        p8.d = 0;
        P8 p82 = n8.c;
        p82.f729a = true;
        S8 s8 = n8.b;
        IBinaryDataHelper iBinaryDataHelper = s8.c;
        R8 r8 = s8.b;
        s8.f772a.getClass();
        iBinaryDataHelper.insert("event_hashes", r8.toByteArray((R8) Q8.a(p82)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0437n2 c0437n2 = this.f776a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0437n2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0437n2 c0437n2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0437n2 != null) {
            for (Pair pair : c0437n2.f1117a) {
                if (mo.a(pair.first, str) && ((obj = pair.second) == null || ((C0412m2) obj).f1098a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
