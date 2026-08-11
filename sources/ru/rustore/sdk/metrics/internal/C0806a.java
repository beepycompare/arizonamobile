package ru.rustore.sdk.metrics.internal;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* renamed from: ru.rustore.sdk.metrics.internal.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0806a extends Lambda implements Function1<Byte, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0806a f1535a = new C0806a();

    public C0806a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b.byteValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
}
