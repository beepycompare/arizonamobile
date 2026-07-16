package com.arizonagames.feature.minigames.atm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.arizonagames.feature.minigames.atm.databinding.AtmScreenChickenBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.StrokeTextView;
/* compiled from: GameType.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0014\u0010\"\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0014\u0010$\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\tR\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\tR\u0014\u0010,\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\tR\u0014\u0010.\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\tR\u0014\u00100\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\tR\u0014\u00102\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\t¨\u00064"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/AtmMiniGameScreenViewsChicken;", "Lcom/arizonagames/feature/minigames/atm/MiniGameScreenViews;", "binding", "Lcom/arizonagames/feature/minigames/atm/databinding/AtmScreenChickenBinding;", "<init>", "(Lcom/arizonagames/feature/minigames/atm/databinding/AtmScreenChickenBinding;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "backgroundImage", "Landroid/widget/ImageView;", "getBackgroundImage", "()Landroid/widget/ImageView;", "bgResult", "getBgResult", "titleText", "Landroid/widget/TextView;", "getTitleText", "()Landroid/widget/TextView;", "infoText", "getInfoText", "statusPanel", "getStatusPanel", "statusText", "getStatusText", "progressBlock", "getProgressBlock", "progressIcon", "getProgressIcon", "progressTitleText", "getProgressTitleText", "progressText", "getProgressText", "sourceImage", "getSourceImage", "bagTouchArea", "getBagTouchArea", "dragLayer", "Landroid/widget/FrameLayout;", "getDragLayer", "()Landroid/widget/FrameLayout;", "close", "getClose", "slot1Container", "getSlot1Container", "slot10Container", "getSlot10Container", "slot50Container", "getSlot50Container", "slot100Container", "getSlot100Container", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AtmMiniGameScreenViewsChicken implements MiniGameScreenViews {
    private final AtmScreenChickenBinding binding;

    public AtmMiniGameScreenViewsChicken(AtmScreenChickenBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public /* bridge */ View getSlotExtraContainer() {
        return super.getSlotExtraContainer();
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getRoot() {
        FrameLayout root = this.binding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public ImageView getBackgroundImage() {
        ImageView backgroundImage = this.binding.backgroundImage;
        Intrinsics.checkNotNullExpressionValue(backgroundImage, "backgroundImage");
        return backgroundImage;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public ImageView getBgResult() {
        ImageView bgResult = this.binding.bgResult;
        Intrinsics.checkNotNullExpressionValue(bgResult, "bgResult");
        return bgResult;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public TextView getTitleText() {
        StrokeTextView titleText = this.binding.titleText;
        Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
        return titleText;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public TextView getInfoText() {
        TextView infoText = this.binding.infoText;
        Intrinsics.checkNotNullExpressionValue(infoText, "infoText");
        return infoText;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getStatusPanel() {
        CustomCardView statusPanel = this.binding.statusPanel;
        Intrinsics.checkNotNullExpressionValue(statusPanel, "statusPanel");
        return statusPanel;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public TextView getStatusText() {
        TextView statusText = this.binding.statusText;
        Intrinsics.checkNotNullExpressionValue(statusText, "statusText");
        return statusText;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getProgressBlock() {
        FrameLayout progressBlock = this.binding.progressBlock;
        Intrinsics.checkNotNullExpressionValue(progressBlock, "progressBlock");
        return progressBlock;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public ImageView getProgressIcon() {
        ImageView progressIcon = this.binding.progressIcon;
        Intrinsics.checkNotNullExpressionValue(progressIcon, "progressIcon");
        return progressIcon;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public TextView getProgressTitleText() {
        StrokeTextView progressTitleText = this.binding.progressTitleText;
        Intrinsics.checkNotNullExpressionValue(progressTitleText, "progressTitleText");
        return progressTitleText;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public TextView getProgressText() {
        StrokeTextView progressText = this.binding.progressText;
        Intrinsics.checkNotNullExpressionValue(progressText, "progressText");
        return progressText;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public ImageView getSourceImage() {
        ImageView bagImage = this.binding.bagImage;
        Intrinsics.checkNotNullExpressionValue(bagImage, "bagImage");
        return bagImage;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getBagTouchArea() {
        View bagTouchArea = this.binding.bagTouchArea;
        Intrinsics.checkNotNullExpressionValue(bagTouchArea, "bagTouchArea");
        return bagTouchArea;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public FrameLayout getDragLayer() {
        FrameLayout dragLayer = this.binding.dragLayer;
        Intrinsics.checkNotNullExpressionValue(dragLayer, "dragLayer");
        return dragLayer;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getClose() {
        View close = this.binding.close;
        Intrinsics.checkNotNullExpressionValue(close, "close");
        return close;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getSlot1Container() {
        FrameLayout slot1Container = this.binding.slot1Container;
        Intrinsics.checkNotNullExpressionValue(slot1Container, "slot1Container");
        return slot1Container;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getSlot10Container() {
        FrameLayout slot10Container = this.binding.slot10Container;
        Intrinsics.checkNotNullExpressionValue(slot10Container, "slot10Container");
        return slot10Container;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getSlot50Container() {
        FrameLayout slot50Container = this.binding.slot50Container;
        Intrinsics.checkNotNullExpressionValue(slot50Container, "slot50Container");
        return slot50Container;
    }

    @Override // com.arizonagames.feature.minigames.atm.MiniGameScreenViews
    public View getSlot100Container() {
        FrameLayout slot100Container = this.binding.slot100Container;
        Intrinsics.checkNotNullExpressionValue(slot100Container, "slot100Container");
        return slot100Container;
    }
}
