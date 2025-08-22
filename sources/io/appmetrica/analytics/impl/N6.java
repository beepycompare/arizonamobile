package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* loaded from: classes4.dex */
public final class N6 implements Sf {
    public static final M6 b = new M6();

    /* renamed from: a  reason: collision with root package name */
    public final Sf f574a;

    public N6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Sf
    public final String a() {
        return this.f574a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f574a.a();
            if (a2 != null && a2.length() > 0) {
                return !StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public N6(Sf sf) {
        this.f574a = sf;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f574a.a();
            if (a2 != null && a2.length() > 0) {
                if (StringsKt.endsWith$default(a2, StringUtils.PROCESS_POSTFIX_DELIMITER + str, false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ N6(Sf sf, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sf);
        if ((i & 1) != 0) {
            b.getClass();
            sf = M6.a();
        }
    }
}
