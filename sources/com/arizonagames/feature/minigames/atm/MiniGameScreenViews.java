package com.arizonagames.feature.minigames.atm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
/* compiled from: GameType.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0012\u0010\u001a\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0012\u0010\u001c\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0012\u0010\u001e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0012\u0010*\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0012\u0010,\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0012\u0010.\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0005¨\u00060À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/MiniGameScreenViews;", "", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "backgroundImage", "Landroid/widget/ImageView;", "getBackgroundImage", "()Landroid/widget/ImageView;", "bgResult", "getBgResult", "titleText", "Landroid/widget/TextView;", "getTitleText", "()Landroid/widget/TextView;", "infoText", "getInfoText", "statusPanel", "getStatusPanel", "statusText", "getStatusText", "progressBlock", "getProgressBlock", "progressIcon", "getProgressIcon", "progressTitleText", "getProgressTitleText", "progressText", "getProgressText", "sourceImage", "getSourceImage", "bagTouchArea", "getBagTouchArea", "dragLayer", "Landroid/widget/FrameLayout;", "getDragLayer", "()Landroid/widget/FrameLayout;", "close", "getClose", "slot1Container", "getSlot1Container", "slot10Container", "getSlot10Container", "slot50Container", "getSlot50Container", "slot100Container", "getSlot100Container", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MiniGameScreenViews {
    ImageView getBackgroundImage();

    View getBagTouchArea();

    ImageView getBgResult();

    View getClose();

    FrameLayout getDragLayer();

    TextView getInfoText();

    View getProgressBlock();

    ImageView getProgressIcon();

    TextView getProgressText();

    TextView getProgressTitleText();

    View getRoot();

    View getSlot100Container();

    View getSlot10Container();

    View getSlot1Container();

    View getSlot50Container();

    ImageView getSourceImage();

    View getStatusPanel();

    TextView getStatusText();

    TextView getTitleText();
}
