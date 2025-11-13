package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.pirates;

import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudElementPiratesBinding;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: Pirates.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/PiratesElement;", "", "<init>", "()V", "showInfo", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementPiratesBinding;", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidHpModel;", "setType", "type", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;", "hide", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PiratesElement {
    public static final PiratesElement INSTANCE = new PiratesElement();

    /* compiled from: Pirates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SquidType.values().length];
            try {
                iArr[SquidType.SHIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SquidType.FRANKLIN_STEIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PiratesElement() {
    }

    public final void showInfo(HudElementPiratesBinding binding, SquidHpModel model) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(model, "model");
        setType(model.getSquidType(), binding);
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        binding.progressBar.setPercentWidth(model.getCurrentHp() / model.getMaxHp());
        TextView textView = binding.progressText;
        int currentHp = model.getCurrentHp();
        textView.setText(currentHp + " / " + model.getMaxHp());
    }

    private final void setType(SquidType squidType, HudElementPiratesBinding hudElementPiratesBinding) {
        int i = WhenMappings.$EnumSwitchMapping$0[squidType.ordinal()];
        if (i == 1) {
            hudElementPiratesBinding.ivBg.setImageResource(R.drawable.hud_element_cyber_bg);
            hudElementPiratesBinding.ivImage.setImageResource(R.drawable.hud_element_cyber_image);
            hudElementPiratesBinding.tvTitle.setText("космический корабль");
            hudElementPiratesBinding.progressBarBg.setBackground(Color.parseColor("#4DFFFFFF"));
            CustomCardView progressBar = hudElementPiratesBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            CustomCardView.setBackground$default(progressBar, Color.parseColor("#008666"), Color.parseColor("#30FFE7"), null, null, 12, null);
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            hudElementPiratesBinding.ivBg.setImageResource(R.drawable.hud_element_franclin_stein_bg);
            hudElementPiratesBinding.ivImage.setImageResource(R.drawable.hud_element_franclin_stein);
            hudElementPiratesBinding.tvTitle.setText("Франкенштейн");
            hudElementPiratesBinding.progressBarBg.setBackground(Color.parseColor("#4DB21E2D"));
            CustomCardView progressBar2 = hudElementPiratesBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
            CustomCardView.setBackground$default(progressBar2, Color.parseColor("#B21E2D"), Color.parseColor("#E84C59"), null, null, 12, null);
        }
    }

    public final void hide(HudElementPiratesBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }
}
