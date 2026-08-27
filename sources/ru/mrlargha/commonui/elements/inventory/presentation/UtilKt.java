package ru.mrlargha.commonui.elements.inventory.presentation;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.domain.db.inventory.InventoryEffectType;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEffectModel;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\f2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\f\u001a\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006\u001a/\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0017\u001a(\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b\u001a(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a5\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010$\u001a+\u0010%\u001a\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010)\u001a!\u0010*\u001a\u00020\u00112\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060,\"\u00020\u0006H\u0002¢\u0006\u0002\u0010-\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"INVENTORY_EFFECT_MAX_SIZE_PX", "", "effectLoadLock", "", "activeEffectLoads", "Ljava/util/WeakHashMap;", "Landroid/widget/ImageView;", "Lkotlinx/coroutines/Job;", "setInventoryItemEffect", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;", "itemId", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Ljava/lang/Integer;)Lkotlinx/coroutines/Job;", "(Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;Ljava/lang/Integer;)Lkotlinx/coroutines/Job;", "clearInventoryItemEffect", "", "clearEffect", "ivEffectBackgroundTop", "ivEffectBackground", "ivEffectForeground", "setEffect", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Ljava/lang/Integer;)Lkotlinx/coroutines/Job;", "loadResolvedEffect", "effect", "Lru/mrlargha/commonui/elements/inventory/presentation/ResolvedInventoryEffect;", "loadEffectModel", "imageView", CommonUrlParts.MODEL, "resolveInventoryEffect", "instanceEffect", "", "instanceEffectType", "catalogEffect", "catalogEffectType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/inventory/presentation/ResolvedInventoryEffect;", "inventoryItemDisplayText", "fallback", "itemType", "enchant", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "clearEffectViews", "views", "", "([Landroid/widget/ImageView;)V", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {
    private static final int INVENTORY_EFFECT_MAX_SIZE_PX = 192;
    private static final Object effectLoadLock = new Object();
    private static final WeakHashMap<ImageView, Job> activeEffectLoads = new WeakHashMap<>();

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
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

    public static final Job setInventoryItemEffect(ItemInventoryBinding itemInventoryBinding, InventoryItem item) {
        Intrinsics.checkNotNullParameter(itemInventoryBinding, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        return setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, item);
    }

    public static final Job setInventoryItemEffect(ItemSubInventoryBinding itemSubInventoryBinding, InventoryItem item) {
        Intrinsics.checkNotNullParameter(itemSubInventoryBinding, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemSubInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        return setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, item);
    }

    public static final Job setInventoryItemEffect(ItemInventoryBinding itemInventoryBinding, Integer num) {
        Intrinsics.checkNotNullParameter(itemInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        return setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, num);
    }

    public static final Job setInventoryItemEffect(ItemSubInventoryBinding itemSubInventoryBinding, Integer num) {
        Intrinsics.checkNotNullParameter(itemSubInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemSubInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        return setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, num);
    }

    public static final void clearInventoryItemEffect(ItemInventoryBinding itemInventoryBinding) {
        Intrinsics.checkNotNullParameter(itemInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        clearEffectViews(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
    }

    public static final void clearInventoryItemEffect(ItemSubInventoryBinding itemSubInventoryBinding) {
        Intrinsics.checkNotNullParameter(itemSubInventoryBinding, "<this>");
        ImageView ivEffectBackgroundTop = itemSubInventoryBinding.ivEffectBackgroundTop;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        ImageView ivEffectBackground = itemSubInventoryBinding.ivEffectBackground;
        Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
        ImageView ivEffectForeground = itemSubInventoryBinding.ivEffectForeground;
        Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
        clearEffectViews(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
    }

    public static final void clearEffect(ImageView ivEffectBackgroundTop, ImageView ivEffectBackground, ImageView ivEffectForeground) {
        Intrinsics.checkNotNullParameter(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        Intrinsics.checkNotNullParameter(ivEffectBackground, "ivEffectBackground");
        Intrinsics.checkNotNullParameter(ivEffectForeground, "ivEffectForeground");
        clearEffectViews(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
    }

    public static final Job setEffect(ImageView ivEffectBackgroundTop, ImageView ivEffectBackground, ImageView ivEffectForeground, Integer num) {
        Intrinsics.checkNotNullParameter(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        Intrinsics.checkNotNullParameter(ivEffectBackground, "ivEffectBackground");
        Intrinsics.checkNotNullParameter(ivEffectForeground, "ivEffectForeground");
        clearEffectViews(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
        ItemsInfo itemInfo = UtilsKt.getItemInfo(num);
        ResolvedInventoryEffect resolveInventoryEffect = resolveInventoryEffect(null, null, itemInfo != null ? itemInfo.getEffect() : null, itemInfo != null ? itemInfo.getEffectType() : null);
        if (resolveInventoryEffect == null) {
            return null;
        }
        return loadResolvedEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, resolveInventoryEffect);
    }

    public static final Job setEffect(ImageView ivEffectBackgroundTop, ImageView ivEffectBackground, ImageView ivEffectForeground, InventoryItem item) {
        Intrinsics.checkNotNullParameter(ivEffectBackgroundTop, "ivEffectBackgroundTop");
        Intrinsics.checkNotNullParameter(ivEffectBackground, "ivEffectBackground");
        Intrinsics.checkNotNullParameter(ivEffectForeground, "ivEffectForeground");
        Intrinsics.checkNotNullParameter(item, "item");
        clearEffectViews(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
        ItemsInfo itemInfo = UtilsKt.getItemInfo(item.getItem());
        ResolvedInventoryEffect resolveInventoryEffect = resolveInventoryEffect(item.getEffect(), item.getEffectType(), itemInfo != null ? itemInfo.getEffect() : null, itemInfo != null ? itemInfo.getEffectType() : null);
        if (resolveInventoryEffect == null) {
            return null;
        }
        return loadResolvedEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, resolveInventoryEffect);
    }

    private static final Job loadResolvedEffect(final ImageView imageView, ImageView imageView2, ImageView imageView3, ResolvedInventoryEffect resolvedInventoryEffect) {
        final Job launch$default;
        int i = WhenMappings.$EnumSwitchMapping$0[new InventoryItemEffectModel(resolvedInventoryEffect.getEffectType()).getEffectType().ordinal()];
        if (i == 1) {
            imageView = imageView2;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            imageView = imageView3;
        }
        imageView.setVisibility(0);
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, CoroutineStart.LAZY, new UtilKt$loadResolvedEffect$job$1(imageView, resolvedInventoryEffect, null), 1, null);
        synchronized (effectLoadLock) {
            WeakHashMap<ImageView, Job> weakHashMap = activeEffectLoads;
            Job remove = weakHashMap.remove(imageView);
            if (remove != null) {
                Job.cancel$default(remove, (CancellationException) null, 1, (Object) null);
            }
            weakHashMap.put(imageView, launch$default);
            Unit unit = Unit.INSTANCE;
        }
        launch$default.invokeOnCompletion(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.UtilKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UtilKt.loadResolvedEffect$lambda$1(imageView, launch$default, (Throwable) obj);
            }
        });
        launch$default.start();
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit loadResolvedEffect$lambda$1(ImageView imageView, Job job, Throwable th) {
        synchronized (effectLoadLock) {
            WeakHashMap<ImageView, Job> weakHashMap = activeEffectLoads;
            if (weakHashMap.get(imageView) == job) {
                weakHashMap.remove(imageView);
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadEffectModel(ImageView imageView, Object obj) {
        Object m9919constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(Glide.with(imageView).asDrawable().load(obj).override(192, 192).disallowHardwareConfig().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9922exceptionOrNullimpl(m9919constructorimpl) != null) {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
    }

    public static final ResolvedInventoryEffect resolveInventoryEffect(String str, Integer num, String str2, Integer num2) {
        String obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() > 0) {
            if (num == null) {
                num = num2;
            }
            return new ResolvedInventoryEffect(obj, num);
        }
        String obj2 = str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null;
        String str3 = obj2 != null ? obj2 : "";
        if (str3.length() <= 0) {
            str3 = null;
        }
        if (str3 != null) {
            return new ResolvedInventoryEffect(str3, num2);
        }
        return null;
    }

    public static final String inventoryItemDisplayText(String str, Integer num, Integer num2) {
        int id = ItemTypes.ITEM_TYPE_IMPROV_GUN.getId();
        if (num == null || num.intValue() != id) {
            int id2 = ItemTypes.ITEM_TYPE_GUN_SKIN.getId();
            if (num == null || num.intValue() != id2) {
                int id3 = ItemTypes.ITEM_TYPE_STRIPE_WEAPON.getId();
                if (num == null || num.intValue() != id3) {
                    return str;
                }
            }
        }
        return (num2 == null || num2.intValue() <= 0) ? str : "+" + num2;
    }

    private static final void clearEffectViews(ImageView... imageViewArr) {
        for (ImageView imageView : imageViewArr) {
            synchronized (effectLoadLock) {
                Job remove = activeEffectLoads.remove(imageView);
                if (remove != null) {
                    Job.cancel$default(remove, (CancellationException) null, 1, (Object) null);
                    Unit unit = Unit.INSTANCE;
                }
            }
            try {
                Result.Companion companion = Result.Companion;
                Glide.with(imageView).clear(imageView);
                Result.m9919constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m9919constructorimpl(ResultKt.createFailure(th));
            }
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
    }
}
