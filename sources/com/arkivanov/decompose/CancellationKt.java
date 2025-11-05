package com.arkivanov.decompose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Cancellation.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\u0005"}, d2 = {"doOnCancel", "Lcom/arkivanov/decompose/Cancellation;", "block", "Lkotlin/Function0;", "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancellationKt {
    public static final Cancellation doOnCancel(final Cancellation cancellation, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(cancellation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return new Cancellation() { // from class: com.arkivanov.decompose.CancellationKt$$ExternalSyntheticLambda0
            @Override // com.arkivanov.decompose.Cancellation
            public final void cancel() {
                CancellationKt.doOnCancel$lambda$0(Cancellation.this, block);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnCancel$lambda$0(Cancellation cancellation, Function0 function0) {
        cancellation.cancel();
        function0.invoke();
    }
}
