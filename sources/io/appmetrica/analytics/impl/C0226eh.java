package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.eh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0226eh extends AbstractC0304hh {
    public C0226eh(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        String value = c0241f6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                ap apVar = this.f1019a.t;
                synchronized (apVar) {
                    apVar.c(apVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0241f6.n = Boolean.TRUE;
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
        ap apVar = this.f1019a.t;
        synchronized (apVar) {
            apVar.a(apVar.a() + 1);
        }
        this.f1019a.z();
        C0270g9 c0270g9 = this.f1019a.l;
        if (c0270g9.c == null) {
            c0270g9.a();
        }
        C0322i9 c0322i9 = c0270g9.c;
        c0322i9.getClass();
        c0322i9.b = new HashSet();
        c0322i9.d = 0;
        C0322i9 c0322i92 = c0270g9.c;
        c0322i92.f1032a = true;
        C0399l9 c0399l9 = c0270g9.b;
        IBinaryDataHelper iBinaryDataHelper = c0399l9.c;
        C0373k9 c0373k9 = c0399l9.b;
        c0399l9.f1079a.getClass();
        iBinaryDataHelper.insert("event_hashes", c0373k9.toByteArray((C0373k9) C0347j9.a(c0322i92)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0755z2 c0755z2 = this.f1019a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0755z2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0755z2 c0755z2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0755z2 != null) {
            for (Pair pair : c0755z2.f1307a) {
                if (Oo.a(pair.first, str) && ((obj = pair.second) == null || ((C0729y2) obj).f1287a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
