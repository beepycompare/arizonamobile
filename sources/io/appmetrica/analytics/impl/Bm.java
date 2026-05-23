package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Bm extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f481a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Bm(Y3 y3) {
        this(y3.a().c(), y3.a().d(), y3.a().a(), y3.a().h(), y3.a().b());
    }

    public final boolean a(Bm bm) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final Bm mergeFrom(Bm bm) {
        return new Bm((String) WrapUtils.getOrDefaultNullable(this.f481a, bm.f481a), (String) WrapUtils.getOrDefaultNullable(this.b, bm.b), (Map) WrapUtils.getOrDefaultNullable(this.c, bm.c), this.d || bm.d, bm.d ? bm.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        Bm bm = (Bm) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f481a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public Bm(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f481a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Bm() {
        this(null, null, null, false, null);
    }
}
