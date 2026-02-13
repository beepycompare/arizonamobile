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
public final class Og extends Rg {
    public Og(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        String value = p5.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                xo xoVar = this.f767a.t;
                synchronized (xoVar) {
                    xoVar.c(xoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    p5.n = Boolean.TRUE;
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
        xo xoVar = this.f767a.t;
        synchronized (xoVar) {
            xoVar.a(xoVar.a() + 1);
        }
        this.f767a.z();
        M8 m8 = this.f767a.l;
        if (m8.c == null) {
            m8.a();
        }
        O8 o8 = m8.c;
        o8.getClass();
        o8.b = new HashSet();
        o8.d = 0;
        O8 o82 = m8.c;
        o82.f721a = true;
        R8 r8 = m8.b;
        IBinaryDataHelper iBinaryDataHelper = r8.c;
        Q8 q8 = r8.b;
        r8.f763a.getClass();
        iBinaryDataHelper.insert("event_hashes", q8.toByteArray((Q8) P8.a(o82)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0416m2 c0416m2 = this.f767a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0416m2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0416m2 c0416m2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0416m2 != null) {
            for (Pair pair : c0416m2.f1107a) {
                if (lo.a(pair.first, str) && ((obj = pair.second) == null || ((C0391l2) obj).f1088a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
