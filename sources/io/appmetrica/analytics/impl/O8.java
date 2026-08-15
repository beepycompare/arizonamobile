package io.appmetrica.analytics.impl;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class O8 implements InterfaceC0703x2 {

    /* renamed from: a  reason: collision with root package name */
    public final int f700a = 5;
    public final int b = 100;
    public final int c = 255;
    public final int d = 2;
    public final int e = 63;
    public final int f = 1;
    public final int g = 2;
    public final int h = 1;
    public final int i = 64;
    public final Regex j = new Regex("^[a-zA-Z0-9'!#$%&*+-/=?^_`{|}~]+$");
    public final Regex k = new Regex("(?:^|\\.)(?:(ya\\.ru)|(?:yandex)\\.(\\w+|com?\\.\\w+))$");
    public final List l = CollectionsKt.listOf((Object[]) new String[]{"ru", "by", "kz", "az", "kg", "lv", "md", "tj", "tm", "uz", "ee", "fr", "lt", "com", "co.il", "com.ge", "com.am", "com.tr", "com.ru"});
    public final String m = "yandex.ru";
    public final String n = "gmail.com";
    public final String o = "googlemail.com";

    @Override // io.appmetrica.analytics.impl.InterfaceC0703x2
    public final String a(String str) {
        Character lastOrNull;
        String lowerCase = new Regex("^\\++").replace(StringsKt.trim((CharSequence) str).toString(), "").toLowerCase(Locale.ROOT);
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) lowerCase, '@', 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return null;
        }
        String substring = lowerCase.substring(0, lastIndexOf$default);
        String substring2 = lowerCase.substring(lastIndexOf$default + 1);
        int length = substring.length();
        if (length >= this.h && length <= this.i) {
            List split$default = StringsKt.split$default((CharSequence) substring, new char[]{'.'}, false, 0, 6, (Object) null);
            if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
                Iterator it = split$default.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    int length2 = str2.length();
                    if (length2 < this.h) {
                        break;
                    }
                    Character firstOrNull = StringsKt.firstOrNull(str2);
                    if (firstOrNull != null && firstOrNull.charValue() == '\"' && (lastOrNull = StringsKt.lastOrNull(str2)) != null && lastOrNull.charValue() == '\"' && length2 > 2) {
                        int i = 1;
                        while (true) {
                            int i2 = i + 2;
                            if (i2 >= str2.length()) {
                                break;
                            }
                            char charAt = str2.charAt(i);
                            if (charAt < ' ' || charAt == '\"' || charAt > '~') {
                                break;
                            }
                            if (charAt == '\\') {
                                if (i2 == str2.length()) {
                                    break;
                                }
                                i++;
                                if (str2.charAt(i) < ' ') {
                                    break;
                                }
                            }
                            i++;
                        }
                    } else if (!this.j.matches(str2)) {
                        break;
                    }
                }
            }
            if (substring2.length() <= this.c) {
                List split$default2 = StringsKt.split$default((CharSequence) substring2, new String[]{"."}, false, 0, 6, (Object) null);
                if (split$default2.size() >= this.d) {
                    List<String> dropLast = CollectionsKt.dropLast(split$default2, 1);
                    if (!(dropLast instanceof Collection) || !dropLast.isEmpty()) {
                        for (String str3 : dropLast) {
                            if (!b(str3)) {
                                break;
                            }
                        }
                    }
                    String str4 = (String) CollectionsKt.last((List<? extends Object>) split$default2);
                    if (str4.length() >= this.g && b(str4)) {
                        for (int i3 = 0; i3 < str4.length(); i3++) {
                            if (!Character.isDigit(str4.charAt(i3))) {
                                String replace$default = StringsKt.replace$default(substring2, this.o, this.n, false, 4, (Object) null);
                                MatchResult find$default = Regex.find$default(this.k, replace$default, 0, 2, null);
                                if (find$default != null) {
                                    List<String> groupValues = find$default.getGroupValues();
                                    String str5 = groupValues.get(1);
                                    String str6 = groupValues.get(2);
                                    if (str6.length() <= 0 ? str5.length() > 0 : this.l.contains(str6)) {
                                        replace$default = this.m;
                                    }
                                }
                                if (Intrinsics.areEqual(replace$default, this.m)) {
                                    substring = StringsKt.replace$default(substring, ".", Constants.FILENAME_SEQUENCE_SEPARATOR, false, 4, (Object) null);
                                } else if (Intrinsics.areEqual(replace$default, this.n)) {
                                    substring = StringsKt.replace$default(substring, ".", "", false, 4, (Object) null);
                                }
                                int length3 = substring.length();
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length3) {
                                        break;
                                    }
                                    if (substring.charAt(i4) == '+') {
                                        substring = substring.substring(0, i4);
                                        break;
                                    }
                                    i4++;
                                }
                                String str7 = substring + '@' + replace$default;
                                if (str7.length() < this.f700a || str7.length() > this.b) {
                                    return null;
                                }
                                return str7;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final boolean b(String str) {
        if (str.length() > this.e || str.length() < this.f || !Character.isLetterOrDigit(StringsKt.first(str)) || !Character.isLetterOrDigit(StringsKt.last(str))) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '-') {
                return false;
            }
        }
        return true;
    }
}
