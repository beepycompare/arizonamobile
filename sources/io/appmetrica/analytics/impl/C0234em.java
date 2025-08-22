package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0234em extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f846a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0234em(C0191d4 c0191d4) {
        this(c0191d4.a().c(), c0191d4.a().d(), c0191d4.a().a(), c0191d4.a().h(), c0191d4.a().b());
    }

    public final boolean a(C0234em c0234em) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0234em mergeFrom(C0234em c0234em) {
        return new C0234em((String) WrapUtils.getOrDefaultNullable(this.f846a, c0234em.f846a), (String) WrapUtils.getOrDefaultNullable(this.b, c0234em.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0234em.c), this.d || c0234em.d, c0234em.d ? c0234em.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0234em c0234em = (C0234em) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f846a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0234em(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f846a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0234em() {
        this(null, null, null, false, null);
    }
}
