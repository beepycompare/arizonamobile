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
public final class C0159bh extends AbstractC0236eh {
    public C0159bh(C0574s5 c0574s5) {
        super(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        String value = c0401l6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                uo uoVar = this.f832a.t;
                synchronized (uoVar) {
                    uoVar.c(uoVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0401l6.n = Boolean.TRUE;
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
        uo uoVar = this.f832a.t;
        synchronized (uoVar) {
            uoVar.a(uoVar.a() + 1);
        }
        this.f832a.y();
        C0254f9 c0254f9 = this.f832a.l;
        if (c0254f9.c == null) {
            c0254f9.a();
        }
        C0305h9 c0305h9 = c0254f9.c;
        c0305h9.getClass();
        c0305h9.b = new HashSet();
        c0305h9.d = 0;
        C0305h9 c0305h92 = c0254f9.c;
        c0305h92.f881a = true;
        C0379k9 c0379k9 = c0254f9.b;
        IBinaryDataHelper iBinaryDataHelper = c0379k9.c;
        C0354j9 c0354j9 = c0379k9.b;
        c0379k9.f925a.getClass();
        P9 a2 = C0330i9.a(c0305h92);
        c0354j9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0546r2 c0546r2 = this.f832a.s().z;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0546r2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0546r2 c0546r2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0546r2 != null) {
            for (Pair pair : c0546r2.f1029a) {
                if (io.a(pair.first, str) && ((obj = pair.second) == null || ((C0522q2) obj).f1013a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
