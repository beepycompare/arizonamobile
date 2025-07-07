package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0543qh extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f1006a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final Map<String, String> i;
    public final int j;

    public C0543qh(J4 j4) {
        this(j4.f485a, j4.b, j4.d, j4.e, j4.f, j4.g, j4.h, j4.i, j4.j, j4.k);
    }

    public static C0543qh a() {
        return new C0543qh(null, null, null, null, null, null, null, null, null, null);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0543qh mergeFrom(J4 j4) {
        return new C0543qh((String) WrapUtils.getOrDefaultNullable(j4.f485a, this.f1006a), (Boolean) WrapUtils.getOrDefaultNullable(j4.b, Boolean.valueOf(this.b)), (Boolean) WrapUtils.getOrDefaultNullable(j4.d, Boolean.valueOf(this.c)), (Integer) WrapUtils.getOrDefaultNullable(j4.e, Integer.valueOf(this.d)), (Integer) WrapUtils.getOrDefaultNullable(j4.f, Integer.valueOf(this.e)), (Integer) WrapUtils.getOrDefaultNullable(j4.g, Integer.valueOf(this.f)), (Boolean) WrapUtils.getOrDefaultNullable(j4.h, Boolean.valueOf(this.g)), (Boolean) WrapUtils.getOrDefaultNullable(j4.i, Boolean.valueOf(this.h)), (Map) WrapUtils.getOrDefaultNullable(j4.j, this.i), (Integer) WrapUtils.getOrDefaultNullable(j4.k, Integer.valueOf(this.j)));
    }

    public C0543qh(String str, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4) {
        this.f1006a = str;
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
    public final boolean compareWithOtherArguments(J4 j4) {
        Map<String, String> map;
        String str;
        Boolean bool = j4.b;
        if (bool == null || this.b == bool.booleanValue()) {
            Boolean bool2 = j4.d;
            if (bool2 == null || this.c == bool2.booleanValue()) {
                Integer num = j4.e;
                if (num == null || this.d == num.intValue()) {
                    Integer num2 = j4.f;
                    if (num2 == null || this.e == num2.intValue()) {
                        Integer num3 = j4.g;
                        if (num3 == null || this.f == num3.intValue()) {
                            Boolean bool3 = j4.h;
                            if (bool3 == null || this.g == bool3.booleanValue()) {
                                Boolean bool4 = j4.i;
                                if (bool4 == null || this.h == bool4.booleanValue()) {
                                    String str2 = j4.f485a;
                                    if (str2 == null || ((str = this.f1006a) != null && str.equals(str2))) {
                                        Map<String, String> map2 = j4.j;
                                        if (map2 == null || ((map = this.i) != null && map.equals(map2))) {
                                            Integer num4 = j4.k;
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
