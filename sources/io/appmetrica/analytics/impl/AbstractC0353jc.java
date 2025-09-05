package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Locale;
/* renamed from: io.appmetrica.analytics.impl.jc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0353jc {
    public static final ArrayList a(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        if (locales != null) {
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                Locale locale = locales.get(i);
                if (locale != null) {
                    arrayList.add(AbstractC0124af.a(locale));
                }
            }
        }
        return arrayList;
    }
}
