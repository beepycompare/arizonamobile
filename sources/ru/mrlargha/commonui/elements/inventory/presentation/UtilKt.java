package ru.mrlargha.commonui.elements.inventory.presentation;

import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.domain.db.inventory.InventoryEffectType;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEffectModel;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"setInventoryItemEffect", "", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "id", "", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Ljava/lang/Integer;)V", "Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;", "(Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;Ljava/lang/Integer;)V", "getEffect", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectModel;", "Lru/mrlargha/commonui/utils/ItemsInfo;", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
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
        if (itemsInfo != null) {
            if (itemsInfo.getEffect() != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[getEffect(itemsInfo).getEffectType().ordinal()];
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
                ivEffectBackground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND ? 0 : 8);
                ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
                ivEffectBackgroundTop.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND_TOP ? 0 : 8);
                ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
                ivEffectForeground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.FOREGROUND ? 0 : 8);
                String str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/assets/images/inventory/effects/" + itemsInfo.getEffect();
                Log.d("MainInventory", "bind: " + str);
                Log.e("MainInventory", "bind: " + getEffect(itemsInfo).getEffectType());
                if (Glide.with(imageView.getContext()).load(str).into(imageView) != null) {
                    return;
                }
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
            Unit unit = Unit.INSTANCE;
        }
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
        if (itemsInfo != null) {
            if (itemsInfo.getEffect() != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[getEffect(itemsInfo).getEffectType().ordinal()];
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
                ivEffectBackground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND ? 0 : 8);
                ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
                ivEffectBackgroundTop.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND_TOP ? 0 : 8);
                ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
                ivEffectForeground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.FOREGROUND ? 0 : 8);
                if (Glide.with(imageView.getContext()).load(FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/assets/images/inventory/effects/" + itemsInfo.getEffect()).into(imageView) != null) {
                    return;
                }
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
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final InventoryItemEffectModel getEffect(ItemsInfo itemsInfo) {
        Intrinsics.checkNotNullParameter(itemsInfo, "<this>");
        return new InventoryItemEffectModel(itemsInfo.getEffectType());
    }
}
