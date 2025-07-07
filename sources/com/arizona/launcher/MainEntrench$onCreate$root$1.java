package com.arizona.launcher;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainEntrench.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class MainEntrench$onCreate$root$1 extends FunctionReferenceImpl implements Function1<ComponentContext, MainComponent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainEntrench$onCreate$root$1(Object obj) {
        super(1, obj, MainComponent.Factory.class, "invoke", "invoke(Lcom/arkivanov/decompose/ComponentContext;)Lcom/miami/game/core/app/root/nav/main/MainComponent;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainComponent invoke(ComponentContext p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((MainComponent.Factory) this.receiver).invoke(p0);
    }
}
