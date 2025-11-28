package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0202dm extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f851a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0202dm(P3 p3) {
        this(p3.a().c(), p3.a().d(), p3.a().a(), p3.a().h(), p3.a().b());
    }

    public final boolean a(C0202dm c0202dm) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0202dm mergeFrom(C0202dm c0202dm) {
        return new C0202dm((String) WrapUtils.getOrDefaultNullable(this.f851a, c0202dm.f851a), (String) WrapUtils.getOrDefaultNullable(this.b, c0202dm.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0202dm.c), this.d || c0202dm.d, c0202dm.d ? c0202dm.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0202dm c0202dm = (C0202dm) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f851a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0202dm(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f851a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0202dm() {
        this(null, null, null, false, null);
    }
}
