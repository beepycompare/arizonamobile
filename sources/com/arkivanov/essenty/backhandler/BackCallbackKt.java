package com.arkivanov.essenty.backhandler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackCallback.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aj\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f¨\u0006\u000e"}, d2 = {"BackCallback", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "isEnabled", "", "priority", "", "onBackStarted", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "", "onBackProgressed", "onBackCancelled", "Lkotlin/Function0;", "onBack", "back-handler_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackCallbackKt {
    public static /* synthetic */ BackCallback BackCallback$default(boolean z, int i, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i2, Object obj) {
        Function0 function03;
        Function0 function04;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        if ((i2 & 16) != 0) {
            function03 = function02;
            function04 = null;
        } else {
            function03 = function02;
            function04 = function0;
        }
        Function1 function13 = function12;
        return BackCallback(z, i, function1, function13, function04, function03);
    }

    public static final BackCallback BackCallback(final boolean z, final int i, final Function1<? super BackEvent, Unit> function1, final Function1<? super BackEvent, Unit> function12, final Function0<Unit> function0, final Function0<Unit> onBack) {
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        return new BackCallback(z, i) { // from class: com.arkivanov.essenty.backhandler.BackCallbackKt$BackCallback$1
            @Override // com.arkivanov.essenty.backhandler.BackCallback
            public void onBackStarted(BackEvent backEvent) {
                Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                Function1<BackEvent, Unit> function13 = function1;
                if (function13 != null) {
                    function13.invoke(backEvent);
                }
            }

            @Override // com.arkivanov.essenty.backhandler.BackCallback
            public void onBackProgressed(BackEvent backEvent) {
                Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                Function1<BackEvent, Unit> function13 = function12;
                if (function13 != null) {
                    function13.invoke(backEvent);
                }
            }

            @Override // com.arkivanov.essenty.backhandler.BackCallback
            public void onBackCancelled() {
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }

            @Override // com.arkivanov.essenty.backhandler.BackCallback
            public void onBack() {
                onBack.invoke();
            }
        };
    }
}
