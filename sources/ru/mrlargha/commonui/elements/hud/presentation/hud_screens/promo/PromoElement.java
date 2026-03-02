package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo;

import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementPromoBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: Promo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementPromoBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementPromoBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementPromoBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "setVisible", "", "setInfo", "data", "", "close", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PromoElement {
    private final HudElementPromoBinding binding;
    private final SAMPUIElement notifier;

    public PromoElement(HudElementPromoBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
    }

    public final HudElementPromoBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final void setVisible() {
        this.binding.getRoot().setVisibility(0);
        this.binding.main.setTranslationY(-300.0f);
        this.binding.main.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            setVisible();
            PromoInfo promoInfo = (PromoInfo) MapperKt.toModel(data, PromoInfo.class);
            this.binding.title.setText(promoInfo.getTitle());
            String text = promoInfo.getText();
            if (text != null) {
                this.binding.title.setText(text);
            }
            TextView textView = this.binding.progress;
            int currentProgress = promoInfo.getCurrentProgress();
            textView.setText(currentProgress + "/" + promoInfo.getMaxProgress());
            boolean isArizonaType = UtilsKt.isArizonaType();
            HudElementPromoBinding hudElementPromoBinding = this.binding;
            if (isArizonaType) {
                hudElementPromoBinding.title.setText(promoInfo.getText());
                this.binding.topText.setText(promoInfo.getTitle());
                this.binding.promoText.setText(promoInfo.getPromo());
                this.binding.labelContainer.setVisibility(0);
                if (promoInfo.getCurrentProgress() < promoInfo.getMaxProgress() && promoInfo.getMaxProgress() != 0) {
                    this.binding.progress.setVisibility(0);
                    this.binding.ic2.setVisibility(8);
                    this.binding.card.setBackground(Color.parseColor("#1AFFFFFF"));
                }
                this.binding.progress.setVisibility(8);
                this.binding.ic.setVisibility(0);
                this.binding.ic2.setVisibility(0);
                CustomCardView card = this.binding.card;
                Intrinsics.checkNotNullExpressionValue(card, "card");
                CustomCardView.setBackground$default(card, Color.parseColor("#FCD80F"), Color.parseColor("#FF9112"), null, null, 12, null);
            } else {
                hudElementPromoBinding.labelContainer.setVisibility(8);
                int currentProgress2 = promoInfo.getCurrentProgress();
                int maxProgress = promoInfo.getMaxProgress();
                HudElementPromoBinding hudElementPromoBinding2 = this.binding;
                if (currentProgress2 >= maxProgress) {
                    hudElementPromoBinding2.progress.setVisibility(8);
                    this.binding.ic.setVisibility(0);
                    this.binding.ic2.setVisibility(0);
                    CustomCardView card2 = this.binding.card;
                    Intrinsics.checkNotNullExpressionValue(card2, "card");
                    CustomCardView.setBackground$default(card2, Color.parseColor("#FCD80F"), Color.parseColor("#FF9112"), null, null, 12, null);
                } else {
                    hudElementPromoBinding2.progress.setVisibility(0);
                    this.binding.ic.setVisibility(4);
                    this.binding.ic2.setVisibility(8);
                    this.binding.card.setBackground(Color.parseColor("#1AFFFFFF"));
                }
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo.PromoElement$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SAMPUIElement.notifyClick$default(PromoElement.this.notifier, 67, 67, null, 4, null);
                }
            });
        } catch (Exception unused) {
            this.binding.getRoot().setVisibility(8);
        }
    }

    public final void close() {
        this.binding.getRoot().setVisibility(8);
    }
}
