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
public final class Zg extends AbstractC0193ch {
    public Zg(C0580s5 c0580s5) {
        super(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        String value = c0333i6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString("type"))) {
                ro roVar = this.f785a.t;
                synchronized (roVar) {
                    roVar.c(roVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0333i6.n = Boolean.TRUE;
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
        ro roVar = this.f785a.t;
        synchronized (roVar) {
            roVar.a(roVar.a() + 1);
        }
        this.f785a.y();
        C0185c9 c0185c9 = this.f785a.l;
        if (c0185c9.c == null) {
            c0185c9.a();
        }
        C0236e9 c0236e9 = c0185c9.c;
        c0236e9.getClass();
        c0236e9.b = new HashSet();
        c0236e9.d = 0;
        C0236e9 c0236e92 = c0185c9.c;
        c0236e92.f818a = true;
        C0311h9 c0311h9 = c0185c9.b;
        IBinaryDataHelper iBinaryDataHelper = c0311h9.c;
        C0286g9 c0286g9 = c0311h9.b;
        c0311h9.f865a.getClass();
        M9 a2 = C0261f9.a(c0236e92);
        c0286g9.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
    }

    public final boolean a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0552r2 c0552r2 = this.f785a.s().z;
                    for (String str2 : queryParameter.split("&")) {
                        int indexOf = str2.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(str2.substring(0, indexOf)), Uri.decode(str2.substring(indexOf + 1)), c0552r2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0552r2 c0552r2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0552r2 != null) {
            for (Pair pair : c0552r2.f1016a) {
                if (fo.a(pair.first, str) && ((obj = pair.second) == null || ((C0528q2) obj).f999a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
