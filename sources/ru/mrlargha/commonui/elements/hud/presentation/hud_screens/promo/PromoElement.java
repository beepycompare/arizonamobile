package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo;

import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.PromoElementBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.GradientCard.GradientCardKt;
/* compiled from: Promo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoElement;", "", "binding", "Lru/mrlargha/commonui/databinding/PromoElementBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/PromoElementBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/PromoElementBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "setVisible", "", "setInfo", "data", "", "close", "setDefaultType", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoElement {
    private final PromoElementBinding binding;
    private final SAMPUIElement notifier;

    public PromoElement(PromoElementBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
    }

    public final PromoElementBinding getBinding() {
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
            TextView textView = this.binding.progress;
            int currentProgress = promoInfo.getCurrentProgress();
            textView.setText(currentProgress + "/" + promoInfo.getMaxProgress());
            if (promoInfo.getCurrentProgress() >= promoInfo.getMaxProgress()) {
                this.binding.progress.setVisibility(8);
                this.binding.ic.setVisibility(0);
                this.binding.ic2.setVisibility(0);
                this.binding.card.setBackgroundColor(Color.parseColor("#1AFFFFFF"));
            } else {
                this.binding.progress.setVisibility(0);
                this.binding.ic.setVisibility(4);
                this.binding.ic2.setVisibility(8);
                MaterialCardView card = this.binding.card;
                Intrinsics.checkNotNullExpressionValue(card, "card");
                GradientCardKt.setGradient$default(card, Color.parseColor("#FCD80F"), Color.parseColor("#FF9112"), 0, 4, null);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo.PromoElement$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoElement.setInfo$lambda$0(PromoElement.this, view);
                }
            });
            String text = promoInfo.getText();
            if (text != null) {
                this.binding.topText.setText(text);
            }
        } catch (Exception unused) {
            this.binding.getRoot().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInfo$lambda$0(PromoElement promoElement, View view) {
        SAMPUIElement.notifyClick$default(promoElement.notifier, 67, 67, null, 4, null);
    }

    public final void close() {
        this.binding.getRoot().setVisibility(8);
    }

    private final void setDefaultType() {
        PromoElementBinding promoElementBinding = this.binding;
        promoElementBinding.getRoot().setBackgroundResource(R.drawable.banners_bg);
        TextView title = promoElementBinding.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        title.setVisibility(0);
    }
}
