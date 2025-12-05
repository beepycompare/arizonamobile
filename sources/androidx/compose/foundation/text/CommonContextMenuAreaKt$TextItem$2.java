package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* compiled from: CommonContextMenuArea.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes.dex */
public final class CommonContextMenuAreaKt$TextItem$2 implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $operation;
    final /* synthetic */ ContextMenuState $state;

    public CommonContextMenuAreaKt$TextItem$2(Function0<Unit> function0, ContextMenuState contextMenuState) {
        this.$operation = function0;
        this.$state = contextMenuState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$operation.invoke();
        ContextMenuStateKt.close(this.$state);
    }
}
