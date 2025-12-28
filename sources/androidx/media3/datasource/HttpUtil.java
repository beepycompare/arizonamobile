package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.util.Log;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import java.net.CookieHandler;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte$$ExternalSyntheticBackport0;
/* loaded from: classes2.dex */
public final class HttpUtil {
    private static final String TAG = "HttpUtil";
    private static final Pattern CONTENT_RANGE_WITH_START_AND_END = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern CONTENT_RANGE_WITH_SIZE = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    private HttpUtil() {
    }

    public static String buildRangeRequestHeader(long j, long j2) {
        if (j == 0 && j2 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder("bytes=");
        sb.append(j);
        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
        if (j2 != -1) {
            sb.append((j + j2) - 1);
        }
        return sb.toString();
    }

    public static long getDocumentSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = CONTENT_RANGE_WITH_SIZE.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) Preconditions.checkNotNull(matcher.group(1)));
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getContentLength(String str, String str2) {
        long parseLong;
        if (!TextUtils.isEmpty(str)) {
            try {
                parseLong = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                Log.e(TAG, "Unexpected Content-Length [" + str + "]");
            }
            if (TextUtils.isEmpty(str2)) {
                Matcher matcher = CONTENT_RANGE_WITH_START_AND_END.matcher(str2);
                if (matcher.matches()) {
                    try {
                        long parseLong2 = (Long.parseLong((String) Preconditions.checkNotNull(matcher.group(2))) - Long.parseLong((String) Preconditions.checkNotNull(matcher.group(1)))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            Log.w(TAG, "Inconsistent headers [" + str + "] [" + str2 + "]");
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        Log.e(TAG, "Unexpected Content-Range [" + str2 + "]");
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        if (TextUtils.isEmpty(str2)) {
        }
    }

    public static void storeCookiesFromHeaders(String str, Map<String, List<String>> map, CookieHandler cookieHandler) {
        if (cookieHandler == null) {
            return;
        }
        try {
            cookieHandler.put(new URI(str), map);
        } catch (Exception e) {
            Log.w(TAG, "Failed to store cookies in CookieHandler", e);
        }
    }

    public static String getCookieHeader(String str, Map<String, List<String>> map, CookieHandler cookieHandler) {
        List<String> list;
        if (cookieHandler == null) {
            return "";
        }
        Map<String, List<String>> of = ImmutableMap.of();
        try {
            of = cookieHandler.get(new URI(str), map);
        } catch (Exception e) {
            Log.w(TAG, "Failed to read cookies from CookieHandler", e);
        }
        StringBuilder sb = new StringBuilder();
        if (of.containsKey(HttpHeaders.COOKIE) && (list = of.get(HttpHeaders.COOKIE)) != null) {
            for (String str2 : list) {
                sb.append(str2).append("; ");
            }
        }
        return UByte$$ExternalSyntheticBackport0.m(sb.toString());
    }
}
