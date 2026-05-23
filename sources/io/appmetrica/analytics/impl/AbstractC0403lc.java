package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Locale;
/* renamed from: io.appmetrica.analytics.impl.lc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0403lc {
    public static final ArrayList a(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        if (locales != null) {
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                Locale locale = locales.get(i);
                if (locale != null) {
                    arrayList.add(AbstractC0303hf.a(locale));
                }
            }
        }
        return arrayList;
    }
}
