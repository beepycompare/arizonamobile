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
public final class C0227eh extends AbstractC0305hh {
    public C0227eh(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        String value = c0242f6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                ap apVar = this.f1017a.t;
                synchronized (apVar) {
                    apVar.c(apVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0242f6.n = Boolean.TRUE;
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
        ap apVar = this.f1017a.t;
        synchronized (apVar) {
            apVar.a(apVar.a() + 1);
        }
        this.f1017a.z();
        C0271g9 c0271g9 = this.f1017a.l;
        if (c0271g9.c == null) {
            c0271g9.a();
        }
        C0323i9 c0323i9 = c0271g9.c;
        c0323i9.getClass();
        c0323i9.b = new HashSet();
        c0323i9.d = 0;
        C0323i9 c0323i92 = c0271g9.c;
        c0323i92.f1030a = true;
        C0400l9 c0400l9 = c0271g9.b;
        IBinaryDataHelper iBinaryDataHelper = c0400l9.c;
        C0374k9 c0374k9 = c0400l9.b;
        c0400l9.f1077a.getClass();
        iBinaryDataHelper.insert("event_hashes", c0374k9.toByteArray((C0374k9) C0348j9.a(c0323i92)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0756z2 c0756z2 = this.f1017a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0756z2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0756z2 c0756z2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0756z2 != null) {
            for (Pair pair : c0756z2.f1305a) {
                if (Oo.a(pair.first, str) && ((obj = pair.second) == null || ((C0730y2) obj).f1285a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
