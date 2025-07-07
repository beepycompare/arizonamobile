package coil3;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Path;
/* compiled from: Uri.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a:\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\"\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0018\u001a\u00020\u0019*\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Uri", "Lcoil3/Uri;", "scheme", "", "authority", "path", SearchIntents.EXTRA_QUERY, "fragment", "separator", "buildData", "pathSegments", "", "getPathSegments", "(Lcoil3/Uri;)Ljava/util/List;", "filePath", "getFilePath", "(Lcoil3/Uri;)Ljava/lang/String;", "toUri", "parseUri", "data", "original", "percentDecode", "bytes", "", "length", "", "getLength", "(Ljava/lang/String;)I", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UriKt {
    public static final Uri toUri(String str) {
        return toUri$default(str, null, 1, null);
    }

    public static /* synthetic */ Uri Uri$default(String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            str6 = Path.DIRECTORY_SEPARATOR;
        }
        return Uri(str, str2, str3, str4, str5, str6);
    }

    public static final Uri Uri(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str == null && str2 == null && str3 == null && str4 == null && str5 == null) {
            throw new IllegalArgumentException("At least one of scheme, authority, path, query, or fragment must be non-null.".toString());
        }
        return new Uri(buildData(str, str2, str3, str4, str5), str6, str, str2, str3, str4, str5);
    }

    private static final String buildData(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(AbstractJsonLexerKt.COLON);
        }
        if (str2 != null) {
            sb.append("//");
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return sb.toString();
    }

    public static final List<String> getPathSegments(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i = -1;
        while (i < path.length()) {
            int i2 = i + 1;
            i = StringsKt.indexOf$default((CharSequence) path, '/', i2, false, 4, (Object) null);
            if (i == -1) {
                i = path.length();
            }
            String substring = path.substring(i2, i);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (substring.length() > 0) {
                arrayList.add(substring);
            }
        }
        return arrayList;
    }

    public static final String getFilePath(Uri uri) {
        List<String> pathSegments = getPathSegments(uri);
        if (pathSegments.isEmpty()) {
            return null;
        }
        String path = uri.getPath();
        Intrinsics.checkNotNull(path);
        return CollectionsKt.joinToString$default(pathSegments, uri.getSeparator(), StringsKt.startsWith$default(path, uri.getSeparator(), false, 2, (Object) null) ? uri.getSeparator() : "", null, 0, null, null, 60, null);
    }

    public static /* synthetic */ Uri toUri$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = Path.DIRECTORY_SEPARATOR;
        }
        return toUri(str, str2);
    }

    public static final Uri toUri(String str, String str2) {
        String str3;
        String str4;
        if (Intrinsics.areEqual(str2, RemoteSettings.FORWARD_SLASH_STRING)) {
            str3 = str;
            str4 = str2;
        } else {
            str3 = str;
            str4 = str2;
            str = StringsKt.replace$default(str3, str4, RemoteSettings.FORWARD_SLASH_STRING, false, 4, (Object) null);
        }
        return parseUri(str, str3, str4);
    }

    private static final Uri parseUri(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z = true;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt != '#') {
                if (charAt != '/') {
                    if (charAt != ':') {
                        if (charAt == '?' && i3 == -1 && i == -1) {
                            i3 = i6 + 1;
                        }
                    } else if (z && i3 == -1 && i == -1) {
                        int i7 = i6 + 2;
                        if (i7 < str2.length() && str2.charAt(i6 + 1) == '/' && str2.charAt(i7) == '/') {
                            i4 = i6 + 3;
                            z = false;
                            i5 = i6;
                            i6 = i7;
                        } else if (Intrinsics.areEqual(str, str2)) {
                            i2 = i6 + 1;
                            i5 = i6;
                            i6 = i2;
                            i4 = i6;
                        }
                    }
                } else if (i2 == -1 && i3 == -1 && i == -1) {
                    i2 = i4 == -1 ? 0 : i6;
                    z = false;
                }
            } else if (i == -1) {
                i = i6 + 1;
            }
            i6++;
        }
        int min = Math.min(i == -1 ? Integer.MAX_VALUE : i - 1, str.length());
        int min2 = Math.min(i3 == -1 ? Integer.MAX_VALUE : i3 - 1, min);
        if (i4 != -1) {
            str5 = str.substring(0, i5);
            Intrinsics.checkNotNullExpressionValue(str5, "substring(...)");
            str4 = str.substring(i4, Math.min(i2 != -1 ? i2 : Integer.MAX_VALUE, min2));
            Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
        } else {
            str4 = null;
            str5 = null;
        }
        if (i2 != -1) {
            str6 = str.substring(i2, min2);
            Intrinsics.checkNotNullExpressionValue(str6, "substring(...)");
        } else {
            str6 = null;
        }
        if (i3 != -1) {
            str7 = str.substring(i3, min);
            Intrinsics.checkNotNullExpressionValue(str7, "substring(...)");
        } else {
            str7 = null;
        }
        if (i != -1) {
            str8 = str.substring(i, str.length());
            Intrinsics.checkNotNullExpressionValue(str8, "substring(...)");
        } else {
            str8 = null;
        }
        byte[] bArr = new byte[Math.max(0, Math.max(getLength(str5), Math.max(getLength(str4), Math.max(getLength(str6), Math.max(getLength(str7), getLength(str8))))) - 2)];
        return new Uri(str, str3, str5 != null ? percentDecode(str5, bArr) : null, str4 != null ? percentDecode(str4, bArr) : null, str6 != null ? percentDecode(str6, bArr) : null, str7 != null ? percentDecode(str7, bArr) : null, str8 != null ? percentDecode(str8, bArr) : null);
    }

    private static final String percentDecode(String str, byte[] bArr) {
        byte[] bArr2;
        int length = str.length();
        int i = 0;
        int max = Math.max(0, length - 2);
        int i2 = 0;
        while (true) {
            if (i < max) {
                bArr2 = bArr;
                if (str.charAt(i) == '%') {
                    int i3 = i + 3;
                    try {
                        String substring = str.substring(i + 1, i3);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        bArr2[i2] = (byte) Integer.parseInt(substring, CharsKt.checkRadix(16));
                        i2++;
                        bArr = bArr2;
                        i = i3;
                    } catch (NumberFormatException unused) {
                    }
                }
            } else if (i == i2) {
                return str;
            } else {
                if (i >= length) {
                    return StringsKt.decodeToString$default(bArr, 0, i2, false, 5, null);
                }
                bArr2 = bArr;
            }
            bArr2[i2] = (byte) str.charAt(i);
            i2++;
            i++;
            bArr = bArr2;
        }
    }

    private static final int getLength(String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }
}
