package io.appmetrica.analytics.impl;

import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0173cf implements InterfaceC0703x2 {

    /* renamed from: a  reason: collision with root package name */
    public final int f929a = 10;
    public final int b = 13;
    public final Regex c = new Regex("^[0-9()\\-+\\s]+$");

    @Override // io.appmetrica.analytics.impl.InterfaceC0703x2
    public final String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        int length2 = sb2.length();
        Character firstOrNull = StringsKt.firstOrNull(str);
        Character firstOrNull2 = StringsKt.firstOrNull(sb2);
        if (length2 < this.f929a || length2 > this.b || ((firstOrNull2 != null && firstOrNull2.charValue() == '0') || !this.c.matches(str))) {
            return null;
        }
        if (length2 == 10 && (firstOrNull == null || firstOrNull.charValue() != '+')) {
            return "7".concat(sb2);
        }
        if (length2 == 11) {
            if (firstOrNull != null && firstOrNull.charValue() == '+' && firstOrNull2 != null && firstOrNull2.charValue() == '8') {
                return null;
            }
            if (firstOrNull2 != null && firstOrNull2.charValue() == '8') {
                return "7" + sb2.substring(1);
            }
        }
        if (length2 < 12 || firstOrNull == null || firstOrNull.charValue() != '+' || firstOrNull2 == null || firstOrNull2.charValue() != '7') {
            return sb2;
        }
        return null;
    }
}
