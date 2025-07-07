package ru.mrlargha.commonui.elements.conveyor_game;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConveyorGameScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class ConveyorGameScreen$itemAdapter$2 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConveyorGameScreen$itemAdapter$2(Object obj) {
        super(0, obj, ConveyorGameScreen.class, "refreshItems", "refreshItems()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ConveyorGameScreen) this.receiver).refreshItems();
    }
}
