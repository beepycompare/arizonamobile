package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.s6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0566s6 implements Df {
    public static final C0541r6 b = new C0541r6();

    /* renamed from: a  reason: collision with root package name */
    public final Df f1114a;

    public C0566s6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Df
    public final String a() {
        return this.f1114a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f1114a.a();
            if (a2 != null && a2.length() > 0) {
                return !StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public C0566s6(Df df) {
        this.f1114a = df;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f1114a.a();
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
    public /* synthetic */ C0566s6(Df df, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(df);
        if ((i & 1) != 0) {
            b.getClass();
            df = C0541r6.a();
        }
    }
}
