package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Bh extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f373a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final Map<String, String> i;
    public final int j;

    public Bh(M4 m4) {
        this(m4.f571a, m4.b, m4.d, m4.e, m4.f, m4.g, m4.h, m4.i, m4.j, m4.k);
    }

    public static Bh a() {
        return new Bh(null, null, null, null, null, null, null, null, null, null);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final Bh mergeFrom(M4 m4) {
        return new Bh((String) WrapUtils.getOrDefaultNullable(m4.f571a, this.f373a), (Boolean) WrapUtils.getOrDefaultNullable(m4.b, Boolean.valueOf(this.b)), (Boolean) WrapUtils.getOrDefaultNullable(m4.d, Boolean.valueOf(this.c)), (Integer) WrapUtils.getOrDefaultNullable(m4.e, Integer.valueOf(this.d)), (Integer) WrapUtils.getOrDefaultNullable(m4.f, Integer.valueOf(this.e)), (Integer) WrapUtils.getOrDefaultNullable(m4.g, Integer.valueOf(this.f)), (Boolean) WrapUtils.getOrDefaultNullable(m4.h, Boolean.valueOf(this.g)), (Boolean) WrapUtils.getOrDefaultNullable(m4.i, Boolean.valueOf(this.h)), (Map) WrapUtils.getOrDefaultNullable(m4.j, this.i), (Integer) WrapUtils.getOrDefaultNullable(m4.k, Integer.valueOf(this.j)));
    }

    public Bh(String str, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4) {
        this.f373a = str;
        Boolean bool5 = Boolean.FALSE;
        this.b = ((Boolean) WrapUtils.getOrDefault(bool, bool5)).booleanValue();
        this.c = ((Boolean) WrapUtils.getOrDefault(bool2, bool5)).booleanValue();
        this.d = Math.max(10, ((Integer) WrapUtils.getOrDefault(num, 10)).intValue());
        this.e = ((Integer) WrapUtils.getOrDefault(num2, 7)).intValue();
        this.f = ((Integer) WrapUtils.getOrDefault(num3, 90)).intValue();
        this.g = ((Boolean) WrapUtils.getOrDefault(bool3, bool5)).booleanValue();
        this.h = ((Boolean) WrapUtils.getOrDefault(bool4, Boolean.TRUE)).booleanValue();
        this.i = map;
        this.j = ((Integer) WrapUtils.getOrDefault(num4, 1000)).intValue();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: a */
    public final boolean compareWithOtherArguments(M4 m4) {
        Map<String, String> map;
        String str;
        Boolean bool = m4.b;
        if (bool == null || this.b == bool.booleanValue()) {
            Boolean bool2 = m4.d;
            if (bool2 == null || this.c == bool2.booleanValue()) {
                Integer num = m4.e;
                if (num == null || this.d == num.intValue()) {
                    Integer num2 = m4.f;
                    if (num2 == null || this.e == num2.intValue()) {
                        Integer num3 = m4.g;
                        if (num3 == null || this.f == num3.intValue()) {
                            Boolean bool3 = m4.h;
                            if (bool3 == null || this.g == bool3.booleanValue()) {
                                Boolean bool4 = m4.i;
                                if (bool4 == null || this.h == bool4.booleanValue()) {
                                    String str2 = m4.f571a;
                                    if (str2 == null || ((str = this.f373a) != null && str.equals(str2))) {
                                        Map<String, String> map2 = m4.j;
                                        if (map2 == null || ((map = this.i) != null && map.equals(map2))) {
                                            Integer num4 = m4.k;
                                            return num4 == null || this.j == num4.intValue();
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
