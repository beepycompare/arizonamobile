package com.arkivanov.decompose.extensions.compose.pages;

import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildPages.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ChildPagesKt$ChildPages$3$1 extends FunctionReferenceImpl implements Function1<Child<?, ?>, String> {
    public static final ChildPagesKt$ChildPages$3$1 INSTANCE = new ChildPagesKt$ChildPages$3$1();

    ChildPagesKt$ChildPages$3$1() {
        super(1, UtilsKt.class, "keyHashString", "keyHashString(Lcom/arkivanov/decompose/Child;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Child<?, ?> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return UtilsKt.keyHashString(p0);
    }
}
