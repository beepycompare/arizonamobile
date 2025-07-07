package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Na implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int utf8BytesLength = StringUtils.getUtf8BytesLength((String) ((Map.Entry) obj).getValue());
        int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) ((Map.Entry) obj2).getValue());
        if (utf8BytesLength < utf8BytesLength2) {
            return -1;
        }
        return utf8BytesLength == utf8BytesLength2 ? 0 : 1;
    }
}
