package com.arkivanov.decompose.errorhandler;

import com.arkivanov.decompose.DecomposeSettings;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorHandlers.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\"J\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u0016\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"value", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "onDecomposeError", "getOnDecomposeError$annotations", "()V", "getOnDecomposeError", "()Lkotlin/jvm/functions/Function1;", "setOnDecomposeError", "(Lkotlin/jvm/functions/Function1;)V", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ErrorHandlersKt {
    @Deprecated(message = "Please use DecomposeSettings#onDecomposeError")
    public static /* synthetic */ void getOnDecomposeError$annotations() {
    }

    public static final Function1<Exception, Unit> getOnDecomposeError() {
        return DecomposeSettings.Companion.getSettings().getOnDecomposeError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DecomposeSettings _set_onDecomposeError_$lambda$0(Function1 function1, DecomposeSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DecomposeSettings.copy$default(it, false, false, function1, 3, null);
    }

    public static final void setOnDecomposeError(final Function1<? super Exception, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        DecomposeSettings.Companion.update(new Function1() { // from class: com.arkivanov.decompose.errorhandler.ErrorHandlersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ErrorHandlersKt._set_onDecomposeError_$lambda$0(Function1.this, (DecomposeSettings) obj);
            }
        });
    }
}
