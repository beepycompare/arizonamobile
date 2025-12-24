package ru.mrlargha.commonui.elements.inventory.presentation;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.domain.db.inventory.InventoryEffectType;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEffectType;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"setInventoryItemEffect", "", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "id", "", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Ljava/lang/Integer;)V", "Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;", "(Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;Ljava/lang/Integer;)V", "getEffect", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectType;", "Lru/mrlargha/commonui/utils/ItemsInfo;", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InventoryEffectType.values().length];
            try {
                iArr[InventoryEffectType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InventoryEffectType.BACKGROUND_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InventoryEffectType.FOREGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void setInventoryItemEffect(ItemInventoryBinding itemInventoryBinding, Integer num) {
        Object obj;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(itemInventoryBinding, "<this>");
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
            int i = WhenMappings.$EnumSwitchMapping$0[effect.getEffectType().ordinal()];
            if (i == 1) {
                imageView = itemInventoryBinding.ivEffectBackground;
            } else if (i == 2) {
                imageView = itemInventoryBinding.ivEffectBackgroundTop;
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                imageView = itemInventoryBinding.ivEffectForeground;
            }
            Intrinsics.checkNotNull(imageView);
            ImageView ivEffectBackground = itemInventoryBinding.ivEffectBackground;
            Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
            ivEffectBackground.setVisibility(effect.getEffectType() == InventoryEffectType.BACKGROUND ? 0 : 8);
            ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
            Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
            ivEffectBackgroundTop.setVisibility(effect.getEffectType() == InventoryEffectType.BACKGROUND_TOP ? 0 : 8);
            ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
            Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
            ivEffectForeground.setVisibility(effect.getEffectType() == InventoryEffectType.FOREGROUND ? 0 : 8);
            Intrinsics.checkNotNull(Glide.with(itemInventoryBinding.ivEffectBackground.getContext()).load(effect.getResId()).into(imageView));
            return;
        }
        itemInventoryBinding.ivEffectBackground.setImageDrawable(null);
        ImageView ivEffectBackground2 = itemInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground2, "ivEffectBackground");
        ivEffectBackground2.setVisibility(8);
        itemInventoryBinding.ivEffectBackgroundTop.setImageDrawable(null);
        ImageView ivEffectBackgroundTop2 = itemInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop2, "ivEffectBackgroundTop");
        ivEffectBackgroundTop2.setVisibility(8);
        itemInventoryBinding.ivEffectForeground.setImageDrawable(null);
        ImageView ivEffectForeground2 = itemInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground2, "ivEffectForeground");
        ivEffectForeground2.setVisibility(8);
    }

    public static final void setInventoryItemEffect(ItemSubInventoryBinding itemSubInventoryBinding, Integer num) {
        Object obj;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(itemSubInventoryBinding, "<this>");
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
            int i = WhenMappings.$EnumSwitchMapping$0[effect.getEffectType().ordinal()];
            if (i == 1) {
                imageView = itemSubInventoryBinding.ivEffectBackground;
            } else if (i == 2) {
                imageView = itemSubInventoryBinding.ivEffectBackgroundTop;
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                imageView = itemSubInventoryBinding.ivEffectForeground;
            }
            Intrinsics.checkNotNull(imageView);
            ImageView ivEffectBackground = itemSubInventoryBinding.ivEffectBackground;
            Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
            ivEffectBackground.setVisibility(effect.getEffectType() == InventoryEffectType.BACKGROUND ? 0 : 8);
            ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
            Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
            ivEffectBackgroundTop.setVisibility(effect.getEffectType() == InventoryEffectType.BACKGROUND_TOP ? 0 : 8);
            ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
            Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
            ivEffectForeground.setVisibility(effect.getEffectType() == InventoryEffectType.FOREGROUND ? 0 : 8);
            Intrinsics.checkNotNull(Glide.with(itemSubInventoryBinding.ivEffectBackground.getContext()).load(effect.getResId()).into(imageView));
            return;
        }
        itemSubInventoryBinding.ivEffectBackground.setImageDrawable(null);
        ImageView ivEffectBackground2 = itemSubInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground2, "ivEffectBackground");
        ivEffectBackground2.setVisibility(8);
        itemSubInventoryBinding.ivEffectBackgroundTop.setImageDrawable(null);
        ImageView ivEffectBackgroundTop2 = itemSubInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop2, "ivEffectBackgroundTop");
        ivEffectBackgroundTop2.setVisibility(8);
        itemSubInventoryBinding.ivEffectForeground.setImageDrawable(null);
        ImageView ivEffectForeground2 = itemSubInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground2, "ivEffectForeground");
        ivEffectForeground2.setVisibility(8);
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
