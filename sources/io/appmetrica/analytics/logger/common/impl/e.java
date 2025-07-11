package io.appmetrica.analytics.logger.common.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Pattern f1207a = Pattern.compile("[\\p{Space},;]");

    public static int a(Matcher matcher, int i, int i2) {
        if (i2 >= i) {
            int i3 = ((i2 - i) / 2) + i;
            matcher.region(i3, i2);
            if (matcher.find()) {
                int start = matcher.start();
                int a2 = a(matcher, start + 1, i2);
                return a2 == -1 ? start : a2;
            }
            matcher.region(i, i3);
            if (matcher.find()) {
                int start2 = matcher.start();
                int a3 = a(matcher, start2 + 1, i3);
                return a3 == -1 ? start2 : a3;
            }
        }
        return -1;
    }
}
