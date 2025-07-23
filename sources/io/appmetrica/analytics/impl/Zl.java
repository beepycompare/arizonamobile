package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Zl extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f754a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Zl(C0198d4 c0198d4) {
        this(c0198d4.a().c(), c0198d4.a().d(), c0198d4.a().a(), c0198d4.a().h(), c0198d4.a().b());
    }

    public final boolean a(Zl zl) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final Zl mergeFrom(Zl zl) {
        return new Zl((String) WrapUtils.getOrDefaultNullable(this.f754a, zl.f754a), (String) WrapUtils.getOrDefaultNullable(this.b, zl.b), (Map) WrapUtils.getOrDefaultNullable(this.c, zl.c), this.d || zl.d, zl.d ? zl.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        Zl zl = (Zl) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f754a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public Zl(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f754a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Zl() {
        this(null, null, null, false, null);
    }
}
