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
public /* synthetic */ class MainComponent$stackDialog$1 extends FunctionReferenceImpl implements Function2<MainComponent.DialogConfig, ComponentContext, MainComponent.DialogChild> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainComponent$stackDialog$1(Object obj) {
        super(2, obj, MainComponent.class, "childDialog", "childDialog(Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;Lcom/arkivanov/decompose/ComponentContext;)Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final MainComponent.DialogChild invoke(MainComponent.DialogConfig p0, ComponentContext p1) {
        MainComponent.DialogChild childDialog;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        childDialog = ((MainComponent) this.receiver).childDialog(p0, p1);
        return childDialog;
    }
}
