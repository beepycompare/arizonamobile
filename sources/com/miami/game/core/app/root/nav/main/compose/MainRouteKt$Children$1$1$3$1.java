package com.miami.game.core.app.root.nav.main.compose;

import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainRoute.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class MainRouteKt$Children$1$1$3$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainRouteKt$Children$1$1$3$1(Object obj) {
        super(1, obj, MainComponent.class, "navigateToDownloadDialog", "navigateToDownloadDialog(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MainComponent) this.receiver).navigateToDownloadDialog(p0);
    }
}
