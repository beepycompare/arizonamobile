package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0124am extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f804a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0124am(I3 i3) {
        this(i3.a().c(), i3.a().d(), i3.a().a(), i3.a().h(), i3.a().b());
    }

    public final boolean a(C0124am c0124am) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0124am mergeFrom(C0124am c0124am) {
        return new C0124am((String) WrapUtils.getOrDefaultNullable(this.f804a, c0124am.f804a), (String) WrapUtils.getOrDefaultNullable(this.b, c0124am.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0124am.c), this.d || c0124am.d, c0124am.d ? c0124am.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0124am c0124am = (C0124am) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f804a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0124am(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f804a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0124am() {
        this(null, null, null, false, null);
    }
}
