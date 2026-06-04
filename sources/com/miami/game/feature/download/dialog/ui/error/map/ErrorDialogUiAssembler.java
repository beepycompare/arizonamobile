package com.miami.game.feature.download.dialog.ui.error.map;

import android.content.res.Resources;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogVmState;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorDialogUiAssembler.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000b"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/map/ErrorDialogUiAssembler;", "", "resources", "Landroid/content/res/Resources;", "<init>", "(Landroid/content/res/Resources;)V", "Ljavax/inject/Inject;", "assembleUiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "vmState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState;", "dialogs", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorDialogUiAssembler {
    public static final int $stable = 8;
    private final Resources resources;

    @Inject
    public ErrorDialogUiAssembler(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
    }

    public final ErrorDialogUiState assembleUiState(CommonDialogVmState vmState) {
        Intrinsics.checkNotNullParameter(vmState, "vmState");
        return new ErrorDialogUiState(vmState.isProgress());
    }
}
