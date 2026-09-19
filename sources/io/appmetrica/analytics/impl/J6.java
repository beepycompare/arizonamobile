package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class J6 implements InterfaceC0199dg {
    public static final I6 b = new I6();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0199dg f609a;

    public J6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0199dg
    public final String a() {
        return this.f609a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f609a.a();
            if (a2 != null && a2.length() > 0) {
                if (!StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public J6(InterfaceC0199dg interfaceC0199dg) {
        this.f609a = interfaceC0199dg;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f609a.a();
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
    public /* synthetic */ J6(InterfaceC0199dg interfaceC0199dg, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0199dg);
        if ((i & 1) != 0) {
            b.getClass();
            interfaceC0199dg = I6.a();
        }
    }
}
