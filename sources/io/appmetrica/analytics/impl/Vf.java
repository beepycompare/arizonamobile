package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import kotlin.text.Charsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public abstract class Vf {
    public static final String a(C0395l9 c0395l9) {
        String str;
        StringBuilder sb = new StringBuilder("Event sent: ");
        int i = c0395l9.c;
        String str2 = c0395l9.d;
        byte[] bArr = c0395l9.e;
        if (i == 1) {
            str = "Attribution";
        } else if (i == 2) {
            str = "Session start";
        } else if (i == 4) {
            if (str2 == null) {
                str2 = AbstractJsonLexerKt.NULL;
            }
            StringBuilder sb2 = new StringBuilder(str2);
            if (bArr != null) {
                String str3 = new String(bArr, Charsets.UTF_8);
                if (!TextUtils.isEmpty(str3)) {
                    sb2.append(" with value ");
                    sb2.append(str3);
                }
            }
            str = sb2.toString();
        } else if (i == 5) {
            str = "Referrer";
        } else if (i == 7) {
            str = "Session heartbeat";
        } else if (i == 13) {
            str = "The very first event";
        } else if (i == 35) {
            str = "E-Commerce";
        } else if (i == 40) {
            str = "Ad revenue (ILRD)";
        } else if (i == 42) {
            str = "External attribution";
        } else if (i == 16) {
            str = "Open";
        } else if (i == 17) {
            str = "Update";
        } else if (i == 20) {
            str = "User profile update";
        } else if (i != 21) {
            switch (i) {
                case 25:
                    str = "ANR";
                    break;
                case 26:
                    str = "Crash: " + str2;
                    break;
                case 27:
                    str = "Error: " + str2;
                    break;
                default:
                    str = "type=" + i;
                    break;
            }
        } else {
            str = "Revenue";
        }
        return sb.append(str).toString();
    }

    public static final String a(String str, EnumC0320ib enumC0320ib, String str2, String str3) {
        if (D9.d.contains(EnumC0320ib.a(enumC0320ib.f931a))) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": ");
            sb.append(enumC0320ib.name());
            if (D9.f.contains(enumC0320ib) && !TextUtils.isEmpty(str2)) {
                sb.append(" with name ");
                sb.append(str2);
            }
            if (D9.e.contains(enumC0320ib) && !TextUtils.isEmpty(str3)) {
                sb.append(" with value ");
                sb.append(str3);
            }
            return sb.toString();
        }
        return null;
    }
}
