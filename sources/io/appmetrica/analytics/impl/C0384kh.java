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
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0384kh extends AbstractC0462nh {
    public C0384kh(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        String value = c0477o6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                Do r0 = this.f1006a.t;
                synchronized (r0) {
                    r0.c(r0.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0477o6.n = Boolean.TRUE;
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
        Do r0 = this.f1006a.t;
        synchronized (r0) {
            r0.a(r0.a() + 1);
        }
        this.f1006a.z();
        C0376k9 c0376k9 = this.f1006a.l;
        if (c0376k9.c == null) {
            c0376k9.a();
        }
        C0428m9 c0428m9 = c0376k9.c;
        c0428m9.getClass();
        c0428m9.b = new HashSet();
        c0428m9.d = 0;
        C0428m9 c0428m92 = c0376k9.c;
        c0428m92.f990a = true;
        C0506p9 c0506p9 = c0376k9.b;
        IBinaryDataHelper iBinaryDataHelper = c0506p9.c;
        C0480o9 c0480o9 = c0506p9.b;
        c0506p9.f1034a.getClass();
        U9 a2 = C0454n9.a(c0428m92);
        c0480o9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0598t2 c0598t2 = this.f1006a.t().z;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0598t2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0598t2 c0598t2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0598t2 != null) {
            for (Pair pair : c0598t2.f1090a) {
                if (ro.a(pair.first, str) && ((obj = pair.second) == null || ((C0573s2) obj).f1076a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
