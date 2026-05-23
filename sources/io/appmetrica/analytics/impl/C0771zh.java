package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.zh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0771zh extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f1316a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final Map<String, String> i;
    public final int j;

    public C0771zh(F4 f4) {
        this(f4.f537a, f4.b, f4.d, f4.e, f4.f, f4.g, f4.h, f4.i, f4.j, f4.k);
    }

    public static C0771zh a() {
        return new C0771zh(null, null, null, null, null, null, null, null, null, null);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0771zh mergeFrom(F4 f4) {
        return new C0771zh((String) WrapUtils.getOrDefaultNullable(f4.f537a, this.f1316a), (Boolean) WrapUtils.getOrDefaultNullable(f4.b, Boolean.valueOf(this.b)), (Boolean) WrapUtils.getOrDefaultNullable(f4.d, Boolean.valueOf(this.c)), (Integer) WrapUtils.getOrDefaultNullable(f4.e, Integer.valueOf(this.d)), (Integer) WrapUtils.getOrDefaultNullable(f4.f, Integer.valueOf(this.e)), (Integer) WrapUtils.getOrDefaultNullable(f4.g, Integer.valueOf(this.f)), (Boolean) WrapUtils.getOrDefaultNullable(f4.h, Boolean.valueOf(this.g)), (Boolean) WrapUtils.getOrDefaultNullable(f4.i, Boolean.valueOf(this.h)), (Map) WrapUtils.getOrDefaultNullable(f4.j, this.i), (Integer) WrapUtils.getOrDefaultNullable(f4.k, Integer.valueOf(this.j)));
    }

    public C0771zh(String str, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4) {
        this.f1316a = str;
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
    public final boolean compareWithOtherArguments(F4 f4) {
        Map<String, String> map;
        String str;
        Boolean bool = f4.b;
        if (bool == null || this.b == bool.booleanValue()) {
            Boolean bool2 = f4.d;
            if (bool2 == null || this.c == bool2.booleanValue()) {
                Integer num = f4.e;
                if (num == null || this.d == num.intValue()) {
                    Integer num2 = f4.f;
                    if (num2 == null || this.e == num2.intValue()) {
                        Integer num3 = f4.g;
                        if (num3 == null || this.f == num3.intValue()) {
                            Boolean bool3 = f4.h;
                            if (bool3 == null || this.g == bool3.booleanValue()) {
                                Boolean bool4 = f4.i;
                                if (bool4 == null || this.h == bool4.booleanValue()) {
                                    String str2 = f4.f537a;
                                    if (str2 == null || ((str = this.f1316a) != null && str.equals(str2))) {
                                        Map<String, String> map2 = f4.j;
                                        if (map2 == null || ((map = this.i) != null && map.equals(map2))) {
                                            Integer num4 = f4.k;
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
