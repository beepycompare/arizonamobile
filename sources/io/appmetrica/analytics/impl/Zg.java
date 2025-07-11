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
/* loaded from: classes4.dex */
public final class Zg extends AbstractC0185ch {
    public Zg(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        String value = c0325i6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                ro roVar = this.f786a.t;
                synchronized (roVar) {
                    roVar.c(roVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0325i6.n = Boolean.TRUE;
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
        ro roVar = this.f786a.t;
        synchronized (roVar) {
            roVar.a(roVar.a() + 1);
        }
        this.f786a.y();
        C0177c9 c0177c9 = this.f786a.l;
        if (c0177c9.c == null) {
            c0177c9.a();
        }
        C0228e9 c0228e9 = c0177c9.c;
        c0228e9.getClass();
        c0228e9.b = new HashSet();
        c0228e9.d = 0;
        C0228e9 c0228e92 = c0177c9.c;
        c0228e92.f819a = true;
        C0303h9 c0303h9 = c0177c9.b;
        IBinaryDataHelper iBinaryDataHelper = c0303h9.c;
        C0278g9 c0278g9 = c0303h9.b;
        c0303h9.f866a.getClass();
        M9 a2 = C0253f9.a(c0228e92);
        c0278g9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0544r2 c0544r2 = this.f786a.s().z;
                    for (String str2 : queryParameter.split("&")) {
                        int indexOf = str2.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(str2.substring(0, indexOf)), Uri.decode(str2.substring(indexOf + 1)), c0544r2)) {
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
            for (Pair pair : c0544r2.f1017a) {
                if (fo.a(pair.first, str) && ((obj = pair.second) == null || ((C0520q2) obj).f1000a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
