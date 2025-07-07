package coil3.util;

import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: mimeTypes.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcoil3/util/MimeTypeMap;", "", "<init>", "()V", "getMimeTypeFromUrl", "", "url", "getMimeTypeFromExtension", "extension", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MimeTypeMap {
    public static final MimeTypeMap INSTANCE = new MimeTypeMap();

    private MimeTypeMap() {
    }

    public final String getMimeTypeFromUrl(String str) {
        if (StringsKt.isBlank(str)) {
            return null;
        }
        return getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '.', ""));
    }

    public final String getMimeTypeFromExtension(String str) {
        Map map;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        map = MimeTypesKt.mimeTypeData;
        String str2 = (String) map.get(lowerCase);
        return str2 == null ? MimeTypes_androidKt.extensionFromMimeTypeMap(lowerCase) : str2;
    }
}
