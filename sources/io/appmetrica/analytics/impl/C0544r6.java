package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.r6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0544r6 implements Cf {
    public static final C0520q6 b = new C0520q6();

    /* renamed from: a  reason: collision with root package name */
    public final Cf f1202a;

    public C0544r6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Cf
    public final String a() {
        return this.f1202a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f1202a.a();
            if (a2 != null && a2.length() > 0) {
                return !StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public C0544r6(Cf cf) {
        this.f1202a = cf;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f1202a.a();
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
    public /* synthetic */ C0544r6(Cf cf, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cf);
        if ((i & 1) != 0) {
            b.getClass();
            cf = C0520q6.a();
        }
    }
}
