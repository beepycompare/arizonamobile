package com.arizona.launcher;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateActivity.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class UpdateActivity$onCreate$root$1 extends FunctionReferenceImpl implements Function1<ComponentContext, DownloadScreenComponent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateActivity$onCreate$root$1(Object obj) {
        super(1, obj, DownloadScreenComponent.Factory.class, "invoke", "invoke(Lcom/arkivanov/decompose/ComponentContext;)Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DownloadScreenComponent invoke(ComponentContext p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DownloadScreenComponent.Factory) this.receiver).invoke(p0);
    }
}
