package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0160bh extends AbstractC0237eh {
    public C0160bh(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        String value = c0402l6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                uo uoVar = this.f831a.t;
                synchronized (uoVar) {
                    uoVar.c(uoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0402l6.n = Boolean.TRUE;
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
        uo uoVar = this.f831a.t;
        synchronized (uoVar) {
            uoVar.a(uoVar.a() + 1);
        }
        this.f831a.y();
        C0255f9 c0255f9 = this.f831a.l;
        if (c0255f9.c == null) {
            c0255f9.a();
        }
        C0306h9 c0306h9 = c0255f9.c;
        c0306h9.getClass();
        c0306h9.b = new HashSet();
        c0306h9.d = 0;
        C0306h9 c0306h92 = c0255f9.c;
        c0306h92.f880a = true;
        C0380k9 c0380k9 = c0255f9.b;
        IBinaryDataHelper iBinaryDataHelper = c0380k9.c;
        C0355j9 c0355j9 = c0380k9.b;
        c0380k9.f924a.getClass();
        P9 a2 = C0331i9.a(c0306h92);
        c0355j9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0547r2 c0547r2 = this.f831a.s().z;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0547r2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0547r2 c0547r2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0547r2 != null) {
            for (Pair pair : c0547r2.f1028a) {
                if (io.a(pair.first, str) && ((obj = pair.second) == null || ((C0523q2) obj).f1012a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
