package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
/* loaded from: classes5.dex */
public enum I18nConversionCategory {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});
    
    private static final I18nConversionCategory[] conversionCategoriesForIntersect;
    private static final I18nConversionCategory[] namedCategories;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        I18nConversionCategory i18nConversionCategory = DATE;
        I18nConversionCategory i18nConversionCategory2 = NUMBER;
        namedCategories = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
        conversionCategoriesForIntersect = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    I18nConversionCategory(Class[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        I18nConversionCategory[] i18nConversionCategoryArr;
        String lowerCase = str.toLowerCase();
        for (I18nConversionCategory i18nConversionCategory : namedCategories) {
            for (String str2 : i18nConversionCategory.strings) {
                if (str2.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory[] i18nConversionCategoryArr;
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory != i18nConversionCategory3) {
            if (i18nConversionCategory2 != i18nConversionCategory3) {
                I18nConversionCategory i18nConversionCategory4 = GENERAL;
                if (i18nConversionCategory != i18nConversionCategory4) {
                    if (i18nConversionCategory2 != i18nConversionCategory4) {
                        Set arrayToSet = arrayToSet(i18nConversionCategory.types);
                        arrayToSet.retainAll(arrayToSet(i18nConversionCategory2.types));
                        for (I18nConversionCategory i18nConversionCategory5 : conversionCategoriesForIntersect) {
                            if (arrayToSet(i18nConversionCategory5.types).equals(arrayToSet)) {
                                return i18nConversionCategory5;
                            }
                        }
                        throw new RuntimeException();
                    }
                }
            }
            return i18nConversionCategory;
        }
        return i18nConversionCategory2;
    }

    public static I18nConversionCategory union(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        return (i18nConversionCategory == i18nConversionCategory3 || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = GENERAL) || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = DATE) || i18nConversionCategory2 == i18nConversionCategory3) ? i18nConversionCategory3 : NUMBER;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        if (this.types == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> cls2 : this.types) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(" conversion category (all types)");
        } else {
            StringJoiner stringJoiner = new StringJoiner(", ", " conversion category (one of: ", ")");
            for (Class<?> cls : this.types) {
                stringJoiner.add(cls.getCanonicalName());
            }
            sb.append(stringJoiner);
        }
        return sb.toString();
    }
}
