package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0273gh extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f990a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final Map<String, String> i;
    public final int j;

    public C0273gh(C0489p4 c0489p4) {
        this(c0489p4.f1142a, c0489p4.b, c0489p4.d, c0489p4.e, c0489p4.f, c0489p4.g, c0489p4.h, c0489p4.i, c0489p4.j, c0489p4.k);
    }

    public static C0273gh a() {
        return new C0273gh(null, null, null, null, null, null, null, null, null, null);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0273gh mergeFrom(C0489p4 c0489p4) {
        return new C0273gh((String) WrapUtils.getOrDefaultNullable(c0489p4.f1142a, this.f990a), (Boolean) WrapUtils.getOrDefaultNullable(c0489p4.b, Boolean.valueOf(this.b)), (Boolean) WrapUtils.getOrDefaultNullable(c0489p4.d, Boolean.valueOf(this.c)), (Integer) WrapUtils.getOrDefaultNullable(c0489p4.e, Integer.valueOf(this.d)), (Integer) WrapUtils.getOrDefaultNullable(c0489p4.f, Integer.valueOf(this.e)), (Integer) WrapUtils.getOrDefaultNullable(c0489p4.g, Integer.valueOf(this.f)), (Boolean) WrapUtils.getOrDefaultNullable(c0489p4.h, Boolean.valueOf(this.g)), (Boolean) WrapUtils.getOrDefaultNullable(c0489p4.i, Boolean.valueOf(this.h)), (Map) WrapUtils.getOrDefaultNullable(c0489p4.j, this.i), (Integer) WrapUtils.getOrDefaultNullable(c0489p4.k, Integer.valueOf(this.j)));
    }

    public C0273gh(String str, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4) {
        this.f990a = str;
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
    public final boolean compareWithOtherArguments(C0489p4 c0489p4) {
        Map<String, String> map;
        String str;
        Boolean bool = c0489p4.b;
        if (bool == null || this.b == bool.booleanValue()) {
            Boolean bool2 = c0489p4.d;
            if (bool2 == null || this.c == bool2.booleanValue()) {
                Integer num = c0489p4.e;
                if (num == null || this.d == num.intValue()) {
                    Integer num2 = c0489p4.f;
                    if (num2 == null || this.e == num2.intValue()) {
                        Integer num3 = c0489p4.g;
                        if (num3 == null || this.f == num3.intValue()) {
                            Boolean bool3 = c0489p4.h;
                            if (bool3 == null || this.g == bool3.booleanValue()) {
                                Boolean bool4 = c0489p4.i;
                                if (bool4 == null || this.h == bool4.booleanValue()) {
                                    String str2 = c0489p4.f1142a;
                                    if (str2 == null || ((str = this.f990a) != null && str.equals(str2))) {
                                        Map<String, String> map2 = c0489p4.j;
                                        if (map2 == null || ((map = this.i) != null && map.equals(map2))) {
                                            Integer num4 = c0489p4.k;
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
