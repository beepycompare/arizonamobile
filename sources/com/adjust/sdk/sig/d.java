package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;
import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.UnrecoverableKeyException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f185a = false;

    public static void a(Set set, Map map, Map map2) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (map.containsKey(str)) {
                map2.put(str, (String) map.get(str));
            }
        }
    }

    public static void a(Context context, c cVar, a aVar, Map map, String str, String str2) {
        byte[] bArr;
        if (f185a) {
            Log.e("SignerInstance", "sign: library received error. It has locked down");
        } else if (map != null && map.size() != 0 && str != null && str2 != null) {
            map.put("activity_kind", str);
            map.put("client_sdk", str2);
            int i = 2;
            while (true) {
                if (i <= 0) {
                    bArr = null;
                    break;
                }
                try {
                    cVar.b(context);
                    bArr = cVar.a(context, map.toString().getBytes("UTF-8"));
                    break;
                } catch (b e) {
                    Log.e("SignerInstance", "sign: Api is less than JellyBean-4-18");
                    f185a = true;
                    map.remove("activity_kind");
                    map.remove("client_sdk");
                    throw e;
                } catch (InvalidKeyException e2) {
                    e = e2;
                } catch (UnrecoverableKeyException e3) {
                    e = e3;
                } catch (Exception e4) {
                    Log.e("SignerInstance", "sign: Received an Exception: " + e4.getMessage(), e4);
                    map.remove("activity_kind");
                    map.remove("client_sdk");
                    throw e4;
                }
                Log.e("SignerInstance", "sign: Received a retriable exception: " + e.getMessage(), e);
                Log.e("SignerInstance", "sign: Attempting retry #" + i);
                i--;
                cVar.a(context);
            }
            if (i == 0) {
                f185a = true;
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            byte[] a2 = ((NativeLibHelper) aVar).a(context, map, bArr, cVar.f184a);
            if (a2 == null) {
                Log.e("SignerInstance", "sign: Returned an null signature. Exiting...");
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            int length = a2.length;
            char[] cArr = e.f186a;
            char[] cArr2 = new char[length * 2];
            for (int i2 = 0; i2 < length; i2++) {
                byte b = a2[i2];
                int i3 = i2 * 2;
                char[] cArr3 = e.f186a;
                cArr2[i3] = cArr3[(b & 255) >>> 4];
                cArr2[i3 + 1] = cArr3[b & Ascii.SI];
            }
            map.put("signature", new String(cArr2));
            map.remove("activity_kind");
            map.remove("client_sdk");
        } else {
            Log.e("SignerInstance", "sign: One or more parameters are null");
        }
    }
}
