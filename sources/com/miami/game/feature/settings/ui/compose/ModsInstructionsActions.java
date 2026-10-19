package com.miami.game.feature.settings.ui.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModsSettings.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/miami/game/feature/settings/ui/compose/ModsInstructionsActions;", "", "onConfigure", "Lkotlin/Function0;", "", "onDebugMode", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnConfigure", "()Lkotlin/jvm/functions/Function0;", "getOnDebugMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsInstructionsActions {
    public static final int $stable = 0;
    private final Function0<Unit> onConfigure;
    private final Function0<Unit> onDebugMode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModsInstructionsActions copy$default(ModsInstructionsActions modsInstructionsActions, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = modsInstructionsActions.onConfigure;
        }
        if ((i & 2) != 0) {
            function02 = modsInstructionsActions.onDebugMode;
        }
        return modsInstructionsActions.copy(function0, function02);
    }

    public final Function0<Unit> component1() {
        return this.onConfigure;
    }

    public final Function0<Unit> component2() {
        return this.onDebugMode;
    }

    public final ModsInstructionsActions copy(Function0<Unit> onConfigure, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(onConfigure, "onConfigure");
        return new ModsInstructionsActions(onConfigure, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModsInstructionsActions) {
            ModsInstructionsActions modsInstructionsActions = (ModsInstructionsActions) obj;
            return Intrinsics.areEqual(this.onConfigure, modsInstructionsActions.onConfigure) && Intrinsics.areEqual(this.onDebugMode, modsInstructionsActions.onDebugMode);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.onConfigure.hashCode() * 31;
        Function0<Unit> function0 = this.onDebugMode;
        return hashCode + (function0 == null ? 0 : function0.hashCode());
    }

    public String toString() {
        Function0<Unit> function0 = this.onConfigure;
        return "ModsInstructionsActions(onConfigure=" + function0 + ", onDebugMode=" + this.onDebugMode + ")";
    }

    public ModsInstructionsActions(Function0<Unit> onConfigure, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(onConfigure, "onConfigure");
        this.onConfigure = onConfigure;
        this.onDebugMode = function0;
    }

    public /* synthetic */ ModsInstructionsActions(Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : function02);
    }

    public final Function0<Unit> getOnConfigure() {
        return this.onConfigure;
    }

    public final Function0<Unit> getOnDebugMode() {
        return this.onDebugMode;
    }
}
