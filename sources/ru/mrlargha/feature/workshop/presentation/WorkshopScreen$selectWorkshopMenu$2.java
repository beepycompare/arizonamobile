package ru.mrlargha.feature.workshop.presentation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkshopScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class WorkshopScreen$selectWorkshopMenu$2 extends FunctionReferenceImpl implements Function1<InventoryItem, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkshopScreen$selectWorkshopMenu$2(Object obj) {
        super(1, obj, WorkshopScreen.class, "isItemEligibleForCurrentMenu", "isItemEligibleForCurrentMenu(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(InventoryItem p0) {
        boolean isItemEligibleForCurrentMenu;
        Intrinsics.checkNotNullParameter(p0, "p0");
        isItemEligibleForCurrentMenu = ((WorkshopScreen) this.receiver).isItemEligibleForCurrentMenu(p0);
        return Boolean.valueOf(isItemEligibleForCurrentMenu);
    }
}
