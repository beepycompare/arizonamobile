package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Al {

    /* renamed from: a  reason: collision with root package name */
    public final String f341a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final Boolean f;

    public Al(String str, String str2, Integer num, Integer num2, String str3, Boolean bool) {
        this.f341a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = str3;
        this.f = bool;
    }

    public Al(StackTraceElement stackTraceElement) {
        this(stackTraceElement.getClassName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), null, stackTraceElement.getMethodName(), Boolean.valueOf(stackTraceElement.isNativeMethod()));
    }
}
