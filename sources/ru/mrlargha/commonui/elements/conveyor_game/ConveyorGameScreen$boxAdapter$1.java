package ru.mrlargha.commonui.elements.conveyor_game;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConveyorGameScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class ConveyorGameScreen$boxAdapter$1 extends FunctionReferenceImpl implements Function1<ConveyorGameItemModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConveyorGameScreen$boxAdapter$1(Object obj) {
        super(1, obj, ConveyorGameScreen.class, "onBoxClick", "onBoxClick(Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConveyorGameItemModel conveyorGameItemModel) {
        invoke2(conveyorGameItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConveyorGameItemModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ConveyorGameScreen) this.receiver).onBoxClick(p0);
    }
}
