package com.miami.game.feature.download.dialog.ui.error.compose;

import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: FailDownloadDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class FailDownloadDialogKt$FailDownloadErrorDialogRoot$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FailDownloadDialogKt$FailDownloadErrorDialogRoot$1$1(Object obj) {
        super(0, obj, ErrorDialogComponent.class, "onRetryFun", "onRetryFun()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ErrorDialogComponent) this.receiver).onRetryFun();
    }
}
