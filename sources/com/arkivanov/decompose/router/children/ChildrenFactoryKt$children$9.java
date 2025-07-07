package com.arkivanov.decompose.router.children;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ChildrenFactory.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ChildrenFactoryKt$children$9<E> extends FunctionReferenceImpl implements Function1<NavEvent<? extends E>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildrenFactoryKt$children$9(Object obj) {
        super(1, obj, EventProcessor.class, "process", "process(Lcom/arkivanov/decompose/router/children/NavEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((NavEvent) ((NavEvent) obj));
        return Unit.INSTANCE;
    }

    public final void invoke(NavEvent<? extends E> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((EventProcessor) this.receiver).process(p0);
    }
}
