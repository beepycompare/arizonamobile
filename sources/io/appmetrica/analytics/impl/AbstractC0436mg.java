package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import kotlin.text.Charsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0436mg {
    public static final String a(E9 e9) {
        String str;
        StringBuilder sb = new StringBuilder("Event sent: ");
        int i = e9.c;
        String str2 = e9.d;
        byte[] bArr = e9.e;
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

    public static final String a(String str, Bb bb, String str2, String str3) {
        if (W9.d.contains(Bb.a(bb.f369a))) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": ");
            sb.append(bb.name());
            if (W9.f.contains(bb) && !TextUtils.isEmpty(str2)) {
                sb.append(" with name ");
                sb.append(str2);
            }
            if (W9.e.contains(bb) && !TextUtils.isEmpty(str3)) {
                sb.append(" with value ");
                sb.append(str3);
            }
            return sb.toString();
        }
        return null;
    }
}
