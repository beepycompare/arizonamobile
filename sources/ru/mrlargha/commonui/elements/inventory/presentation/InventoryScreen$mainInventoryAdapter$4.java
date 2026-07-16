package ru.mrlargha.commonui.elements.inventory.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InventoryScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class InventoryScreen$mainInventoryAdapter$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InventoryScreen$mainInventoryAdapter$4(Object obj) {
        super(1, obj, InventoryScreen.class, "handleMainInventoryDragPageEdge", "handleMainInventoryDragPageEdge(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((InventoryScreen) this.receiver).handleMainInventoryDragPageEdge(i);
    }
}
