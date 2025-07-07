package com.miami.game.feature.download.screen.ui.compose;

import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class DownloadScreenKt$DownloadScreenRoute$4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadScreenKt$DownloadScreenRoute$4$1(Object obj) {
        super(0, obj, DownloadScreenComponent.class, "onSoundClick", "onSoundClick()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((DownloadScreenComponent) this.receiver).onSoundClick();
    }
}
