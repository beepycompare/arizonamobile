package io.appmetrica.analytics.networktasks.internal;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DefaultResponseParser {

    /* loaded from: classes4.dex */
    public static class Response {
        public final String mStatus;

        public Response(String str) {
            this.mStatus = str;
        }

        public String toString() {
            return "Response{mStatus='" + this.mStatus + "'}";
        }
    }

    public Response parse(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new Response(new JSONObject(new String(bArr, "UTF-8")).optString(NotificationCompat.CATEGORY_STATUS));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
