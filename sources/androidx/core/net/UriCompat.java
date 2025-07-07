package androidx.core.net;

import android.net.Uri;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes2.dex */
public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(AbstractJsonLexerKt.COLON);
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char charAt = schemeSpecificPart.charAt(i);
                        if (charAt == '-' || charAt == '@' || charAt == '.') {
                            sb.append(charAt);
                        } else {
                            sb.append('x');
                        }
                    }
                }
                return sb.toString();
            } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase(Constants.SCHEME) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                schemeSpecificPart = "//" + (uri.getHost() != null ? uri.getHost() : "") + (uri.getPort() != -1 ? StringUtils.PROCESS_POSTFIX_DELIMITER + uri.getPort() : "") + "/...";
            }
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(AbstractJsonLexerKt.COLON);
        }
        if (schemeSpecificPart != null) {
            sb2.append(schemeSpecificPart);
        }
        return sb2.toString();
    }
}
