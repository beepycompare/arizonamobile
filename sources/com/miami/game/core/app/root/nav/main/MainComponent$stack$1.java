package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainComponent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class MainComponent$stack$1 extends FunctionReferenceImpl implements Function2<MainComponent.Config, ComponentContext, MainComponent.Child> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainComponent$stack$1(Object obj) {
        super(2, obj, MainComponent.class, "child", "child(Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;Lcom/arkivanov/decompose/ComponentContext;)Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final MainComponent.Child invoke(MainComponent.Config p0, ComponentContext p1) {
        MainComponent.Child child;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        child = ((MainComponent) this.receiver).child(p0, p1);
        return child;
    }
}
