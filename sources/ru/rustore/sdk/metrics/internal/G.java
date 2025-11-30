package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class G extends Lambda implements Function1<J, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final G f1472a = new G();

    public G() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(J j) {
        J it = j;
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it.f1477a + '\'';
    }
}
