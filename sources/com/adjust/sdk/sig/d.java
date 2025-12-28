package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;
import com.adjust.sdk.AdjustConfig;
import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f269a = false;

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
        if (f269a) {
            Log.e("SignerInstance", "sign: library received error. It has locked down");
        } else if (map == null || map.size() == 0 || str == null || str2 == null) {
            Log.e("SignerInstance", "sign: One or more parameters are null");
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppUpdateInfo.Factory.UPDATED_FORMAT);
            boolean equals = AdjustConfig.ENVIRONMENT_SANDBOX.equals(map.get("environment"));
            if (equals) {
                Log.v("SignerInstance", "Signing all the parameters begin: " + simpleDateFormat.format(new Date(System.currentTimeMillis())));
            }
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
                    f269a = true;
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
                f269a = true;
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            if (equals) {
                Log.v("SignerInstance", "Calling native begin: " + simpleDateFormat.format(new Date(System.currentTimeMillis())));
            }
            byte[] a2 = ((NativeLibHelper) aVar).a(context, map, bArr, cVar.f268a);
            if (equals) {
                Log.v("SignerInstance", "Calling native end  : " + simpleDateFormat.format(new Date(System.currentTimeMillis())));
            }
            if (a2 == null) {
                Log.e("SignerInstance", "sign: Returned an null signature. Exiting...");
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            int length = a2.length;
            char[] cArr = e.f270a;
            char[] cArr2 = new char[length * 2];
            for (int i2 = 0; i2 < length; i2++) {
                byte b = a2[i2];
                int i3 = i2 * 2;
                char[] cArr3 = e.f270a;
                cArr2[i3] = cArr3[(b & 255) >>> 4];
                cArr2[i3 + 1] = cArr3[b & Ascii.SI];
            }
            map.put("signature", new String(cArr2));
            map.remove("activity_kind");
            map.remove("client_sdk");
            if (equals) {
                Log.v("SignerInstance", "Signing all the parameters end  : " + simpleDateFormat.format(new Date(System.currentTimeMillis())));
            }
        }
    }
}
