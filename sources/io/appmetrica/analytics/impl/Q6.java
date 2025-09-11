package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* loaded from: classes4.dex */
public final class Q6 implements Wf {
    public static final P6 b = new P6();

    /* renamed from: a  reason: collision with root package name */
    public final Wf f636a;

    public Q6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Wf
    public final String a() {
        return this.f636a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f636a.a();
            if (a2 != null && a2.length() > 0) {
                return !StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public Q6(Wf wf) {
        this.f636a = wf;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f636a.a();
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
    public /* synthetic */ Q6(Wf wf, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wf);
        if ((i & 1) != 0) {
            b.getClass();
            wf = P6.a();
        }
    }
}
