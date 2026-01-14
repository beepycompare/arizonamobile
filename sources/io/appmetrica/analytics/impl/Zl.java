package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Zl extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f892a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Zl(H3 h3) {
        this(h3.a().c(), h3.a().d(), h3.a().a(), h3.a().h(), h3.a().b());
    }

    public final boolean a(Zl zl) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final Zl mergeFrom(Zl zl) {
        return new Zl((String) WrapUtils.getOrDefaultNullable(this.f892a, zl.f892a), (String) WrapUtils.getOrDefaultNullable(this.b, zl.b), (Map) WrapUtils.getOrDefaultNullable(this.c, zl.c), this.d || zl.d, zl.d ? zl.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        Zl zl = (Zl) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f892a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public Zl(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f892a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Zl() {
        this(null, null, null, false, null);
    }
}
