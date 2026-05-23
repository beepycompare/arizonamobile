package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class J6 implements InterfaceC0201dg {
    public static final I6 b = new I6();

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0201dg f606a;

    public J6() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0201dg
    public final String a() {
        return this.f606a.a();
    }

    public final boolean b() {
        try {
            String a2 = this.f606a.a();
            if (a2 != null && a2.length() > 0) {
                if (!StringsKt.contains$default((CharSequence) a2, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public J6(InterfaceC0201dg interfaceC0201dg) {
        this.f606a = interfaceC0201dg;
    }

    public final boolean a(String str) {
        try {
            String a2 = this.f606a.a();
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
    public /* synthetic */ J6(InterfaceC0201dg interfaceC0201dg, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0201dg);
        if ((i & 1) != 0) {
            b.getClass();
            interfaceC0201dg = I6.a();
        }
    }
}
