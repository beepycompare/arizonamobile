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
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0281gh extends AbstractC0358jh {
    public C0281gh(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        String value = c0399l6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                zo zoVar = this.f925a.t;
                synchronized (zoVar) {
                    zoVar.c(zoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0399l6.n = Boolean.TRUE;
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
        zo zoVar = this.f925a.t;
        synchronized (zoVar) {
            zoVar.a(zoVar.a() + 1);
        }
        this.f925a.y();
        C0299h9 c0299h9 = this.f925a.l;
        if (c0299h9.c == null) {
            c0299h9.a();
        }
        C0350j9 c0350j9 = c0299h9.c;
        c0350j9.getClass();
        c0350j9.b = new HashSet();
        c0350j9.d = 0;
        C0350j9 c0350j92 = c0299h9.c;
        c0350j92.f920a = true;
        C0427m9 c0427m9 = c0299h9.b;
        IBinaryDataHelper iBinaryDataHelper = c0427m9.c;
        C0402l9 c0402l9 = c0427m9.b;
        c0427m9.f966a.getClass();
        R9 a2 = C0376k9.a(c0350j92);
        c0402l9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0544r2 c0544r2 = this.f925a.s().z;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0544r2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0544r2 c0544r2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0544r2 != null) {
            for (Pair pair : c0544r2.f1036a) {
                if (no.a(pair.first, str) && ((obj = pair.second) == null || ((C0520q2) obj).f1020a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
