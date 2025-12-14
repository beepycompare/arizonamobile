package ru.rustore.sdk.metrics.internal;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0810a extends Lambda implements Function1<Byte, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0810a f1591a = new C0810a();

    public C0810a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b.byteValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
}
