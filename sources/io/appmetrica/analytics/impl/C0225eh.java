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
public final class C0225eh extends AbstractC0303hh {
    public C0225eh(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        String value = c0240f6.getValue();
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
                    c0240f6.n = Boolean.TRUE;
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
        C0269g9 c0269g9 = this.f1019a.l;
        if (c0269g9.c == null) {
            c0269g9.a();
        }
        C0321i9 c0321i9 = c0269g9.c;
        c0321i9.getClass();
        c0321i9.b = new HashSet();
        c0321i9.d = 0;
        C0321i9 c0321i92 = c0269g9.c;
        c0321i92.f1032a = true;
        C0398l9 c0398l9 = c0269g9.b;
        IBinaryDataHelper iBinaryDataHelper = c0398l9.c;
        C0372k9 c0372k9 = c0398l9.b;
        c0398l9.f1079a.getClass();
        iBinaryDataHelper.insert("event_hashes", c0372k9.toByteArray((C0372k9) C0346j9.a(c0321i92)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0754z2 c0754z2 = this.f1019a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0754z2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0754z2 c0754z2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0754z2 != null) {
            for (Pair pair : c0754z2.f1307a) {
                if (Oo.a(pair.first, str) && ((obj = pair.second) == null || ((C0728y2) obj).f1287a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
