package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.y6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0716y6 implements Hf {
    public static final C0691x6 b = new C0691x6();

    /* renamed from: a  reason: collision with root package name */
    public final Hf f1210a;

    public C0716y6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Hf
    public final String a() {
        return this.f1210a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f1210a.a();
            if (a2 != null && a2.length() > 0) {
                return !StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public C0716y6(Hf hf) {
        this.f1210a = hf;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f1210a.a();
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
    public /* synthetic */ C0716y6(Hf hf, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hf);
        if ((i & 1) != 0) {
            b.getClass();
            hf = C0691x6.a();
        }
    }
}
