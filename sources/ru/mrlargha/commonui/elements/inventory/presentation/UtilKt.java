package ru.mrlargha.commonui.elements.inventory.presentation;

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
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\r\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010¨\u0006\u0011"}, d2 = {"setInventoryItemEffect", "", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "id", "", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Ljava/lang/Integer;)V", "Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;", "(Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;Ljava/lang/Integer;)V", "setEffect", "ivEffectBackgroundTop", "Landroid/widget/ImageView;", "ivEffectBackground", "ivEffectForeground", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Ljava/lang/Integer;)V", "getEffect", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectModel;", "Lru/mrlargha/commonui/utils/ItemsInfo;", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
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
        Intrinsics.checkNotNullParameter(itemInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, num);
    }

    public static final void setInventoryItemEffect(ItemSubInventoryBinding itemSubInventoryBinding, Integer num) {
        Intrinsics.checkNotNullParameter(itemSubInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemSubInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, num);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e6, code lost:
        if (r0 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setEffect(ImageView ivEffectBackgroundTop, ImageView ivEffectBackground, ImageView ivEffectForeground, Integer num) {
        Object obj;
        Object obj2;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(ivEffectBackgroundTop, "ivEffectBackgroundTop");
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
        if (itemsInfo != null) {
            if (itemsInfo.getEffect() != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[getEffect(itemsInfo).getEffectType().ordinal()];
                if (i == 1) {
                    imageView = ivEffectBackground;
                } else if (i == 2) {
                    imageView = ivEffectBackgroundTop;
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    imageView = ivEffectForeground;
                }
                ivEffectBackground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND ? 0 : 8);
                ivEffectBackgroundTop.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.BACKGROUND_TOP ? 0 : 8);
                ivEffectForeground.setVisibility(getEffect(itemsInfo).getEffectType() == InventoryEffectType.FOREGROUND ? 0 : 8);
                obj2 = Glide.with(imageView.getContext()).load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "assets/images/inventory/effects/" + itemsInfo.getEffect()).into(imageView);
            }
            ivEffectBackground.setImageDrawable(null);
            ivEffectBackground.setVisibility(8);
            ivEffectBackgroundTop.setImageDrawable(null);
            ivEffectBackgroundTop.setVisibility(8);
            ivEffectForeground.setImageDrawable(null);
            ivEffectForeground.setVisibility(8);
            obj2 = Unit.INSTANCE;
            if (obj2 != null) {
                return;
            }
        }
        ivEffectBackground.setImageDrawable(null);
        ivEffectBackground.setVisibility(8);
        ivEffectBackgroundTop.setImageDrawable(null);
        ivEffectBackgroundTop.setVisibility(8);
        ivEffectForeground.setImageDrawable(null);
        ivEffectForeground.setVisibility(8);
        Unit unit = Unit.INSTANCE;
    }

    public static final InventoryItemEffectModel getEffect(ItemsInfo itemsInfo) {
        Intrinsics.checkNotNullParameter(itemsInfo, "<this>");
        return new InventoryItemEffectModel(itemsInfo.getEffectType());
    }
}
