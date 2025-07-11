package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Cg {
    public static C0124a8 a(String str) {
        HashMap hashMap;
        HashMap b = b(str);
        if (b.isEmpty()) {
            b = b(Uri.decode(str));
        }
        String decode = Uri.decode((String) b.get("appmetrica_deep_link"));
        if (TextUtils.isEmpty(decode)) {
            hashMap = null;
        } else {
            HashMap b2 = b(decode);
            hashMap = new HashMap(b2.size());
            for (Map.Entry entry : b2.entrySet()) {
                hashMap.put(Uri.decode((String) entry.getKey()), Uri.decode((String) entry.getValue()));
            }
        }
        return new C0124a8(decode, hashMap, str);
    }

    public static HashMap b(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (str != null) {
            int lastIndexOf = str.lastIndexOf(63);
            if (lastIndexOf >= 0) {
                str = str.substring(lastIndexOf + 1);
            }
            if (str.contains("=")) {
                for (String str2 : str.split("&")) {
                    int indexOf = str2.indexOf("=");
                    if (indexOf >= 0) {
                        hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                    } else {
                        hashMap.put(str2, "");
                    }
                }
            }
        }
        return hashMap;
    }
}
