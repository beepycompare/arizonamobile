package com.arkivanov.decompose.router.pages;

import com.arkivanov.decompose.router.children.ChildNavState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildPagesFactory.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ChildPagesFactoryKt$childPages$5 extends FunctionReferenceImpl implements Function2<Integer, Pages<?>, ChildNavState.Status> {
    public static final ChildPagesFactoryKt$childPages$5 INSTANCE = new ChildPagesFactoryKt$childPages$5();

    ChildPagesFactoryKt$childPages$5() {
        super(2, ChildPagesFactoryKt.class, "getDefaultPageStatus", "getDefaultPageStatus(ILcom/arkivanov/decompose/router/pages/Pages;)Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", 1);
    }

    public final ChildNavState.Status invoke(int i, Pages<?> p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ChildPagesFactoryKt.getDefaultPageStatus(i, p1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ChildNavState.Status invoke(Integer num, Pages<?> pages) {
        return invoke(num.intValue(), pages);
    }
}
