package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import kotlin.Metadata;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
/* compiled from: UpgradesInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveArizonaVehicleEmptySlotIcon", "", "inventoryType", "isArizona", "", "(IZ)Ljava/lang/Integer;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UpgradesInventoryViewHolderKt {
    public static final Integer resolveArizonaVehicleEmptySlotIcon(int i, boolean z) {
        if (z) {
            if (i == ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                return Integer.valueOf(R.drawable.inventory_vehicle_number_frame_ic);
            }
            if (i == ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                return Integer.valueOf(R.drawable.inventory_vehicle_modification_ic);
            }
            if (i == ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId()) {
                return Integer.valueOf(R.drawable.inventory_vehicle_number_ic);
            }
            return null;
        }
        return null;
    }
}
