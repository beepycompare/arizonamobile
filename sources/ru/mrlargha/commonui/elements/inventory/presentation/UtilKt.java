package ru.mrlargha.commonui.elements.inventory.presentation;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEffectType;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"setInventoryItemEffect", "", "id", "", "ivEffectBackground", "Landroid/widget/ImageView;", "ivEffectForeground", "(Ljava/lang/Integer;Landroid/widget/ImageView;Landroid/widget/ImageView;)V", "getEffect", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectType;", "Lru/mrlargha/commonui/utils/ItemsInfo;", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {
    public static final void setInventoryItemEffect(Integer num, ImageView ivEffectBackground, ImageView ivEffectForeground) {
        Object obj;
        Intrinsics.checkNotNullParameter(ivEffectBackground, "ivEffectBackground");
        Intrinsics.checkNotNullParameter(ivEffectForeground, "ivEffectForeground");
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((ItemsInfo) obj).getId();
            if (num != null && id == num.intValue()) {
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        InventoryItemEffectType effect = itemsInfo != null ? getEffect(itemsInfo) : null;
        if ((effect != null ? effect.getResId() : null) != null) {
            if (effect == InventoryItemEffectType.FIRE || effect == InventoryItemEffectType.WHITE_FIRE) {
                Glide.with(ivEffectBackground.getContext()).load(effect.getResId()).into(ivEffectBackground);
                ivEffectBackground.setVisibility(0);
                ivEffectForeground.setVisibility(8);
                return;
            }
            Glide.with(ivEffectForeground.getContext()).load(effect.getResId()).into(ivEffectForeground);
            ivEffectBackground.setVisibility(8);
            ivEffectForeground.setVisibility(0);
            return;
        }
        ivEffectBackground.setImageDrawable(null);
        ivEffectBackground.setVisibility(8);
        ivEffectForeground.setImageDrawable(null);
        ivEffectForeground.setVisibility(8);
    }

    public static final InventoryItemEffectType getEffect(ItemsInfo itemsInfo) {
        Object obj;
        Intrinsics.checkNotNullParameter(itemsInfo, "<this>");
        Iterator<E> it = InventoryItemEffectType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((InventoryItemEffectType) obj).getEffectName(), itemsInfo.getEffect())) {
                break;
            }
        }
        InventoryItemEffectType inventoryItemEffectType = (InventoryItemEffectType) obj;
        return inventoryItemEffectType == null ? InventoryItemEffectType.NONE : inventoryItemEffectType;
    }
}
