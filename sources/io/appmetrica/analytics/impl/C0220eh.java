package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.eh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0220eh extends AbstractC0298hh {
    public C0220eh(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        String value = c0235f6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY))) {
                ap apVar = this.f1022a.t;
                synchronized (apVar) {
                    apVar.c(apVar.b() + 1);
                }
                if (a(jSONObject.optString("link"))) {
                    c0235f6.n = Boolean.TRUE;
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
        ap apVar = this.f1022a.t;
        synchronized (apVar) {
            apVar.a(apVar.a() + 1);
        }
        this.f1022a.z();
        C0264g9 c0264g9 = this.f1022a.l;
        if (c0264g9.c == null) {
            c0264g9.a();
        }
        C0316i9 c0316i9 = c0264g9.c;
        c0316i9.getClass();
        c0316i9.b = new HashSet();
        c0316i9.d = 0;
        C0316i9 c0316i92 = c0264g9.c;
        c0316i92.f1035a = true;
        C0393l9 c0393l9 = c0264g9.b;
        IBinaryDataHelper iBinaryDataHelper = c0393l9.c;
        C0367k9 c0367k9 = c0393l9.b;
        c0393l9.f1082a.getClass();
        iBinaryDataHelper.insert("event_hashes", c0367k9.toByteArray((C0367k9) C0341j9.a(c0316i92)));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C0749z2 c0749z2 = this.f1022a.t().y;
                    for (String str2 : Uri.decode(queryParameter).split("&")) {
                        String decode = Uri.decode(str2);
                        int indexOf = decode.indexOf("=");
                        if (indexOf >= 0 && a(Uri.decode(decode.substring(0, indexOf)), Uri.decode(decode.substring(indexOf + 1)), c0749z2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C0749z2 c0749z2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c0749z2 != null) {
            for (Pair pair : c0749z2.f1310a) {
                if (Oo.a(pair.first, str) && ((obj = pair.second) == null || ((C0723y2) obj).f1290a.equals(str2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
