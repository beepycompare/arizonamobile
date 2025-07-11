package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudTimerBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: HudTimer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudTimer;", "", "<init>", "()V", "showTimer", "", "binding", "Lru/mrlargha/commonui/databinding/HudTimerBinding;", "data", "", "DEFAULT_CONTAINER_COLOR", "", "DEFAULT_COLOR", "WARNING_CONTAINER_COLOR", "WARNING_COLOR", "DANGER_CONTAINER_COLOR", "DANGER_COLOR", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudTimer {
    private static final String DANGER_COLOR = "#FF5B5B";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final String WARNING_COLOR = "#FFC700";
    public static final HudTimer INSTANCE = new HudTimer();
    private static final int DEFAULT_CONTAINER_COLOR = R.drawable.hud_timer_time_grey_bg;
    private static final int WARNING_CONTAINER_COLOR = R.drawable.hud_timer_time_yellow_bg;
    private static final int DANGER_CONTAINER_COLOR = R.drawable.hud_timer_time_red_bg;

    /* compiled from: HudTimer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HudTimerType.values().length];
            try {
                iArr[HudTimerType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HudTimerType.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HudTimerType.DANGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HudTimer() {
    }

    public final void showTimer(HudTimerBinding binding, String data) {
        String str;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(data, "data");
        HudTimerModel hudTimerModel = (HudTimerModel) MapperKt.toModel(data, HudTimerModel.class);
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        binding.tvTitle.setText(hudTimerModel.getTitle());
        TextView tvTime = binding.tvTime;
        Intrinsics.checkNotNullExpressionValue(tvTime, "tvTime");
        UtilsKt.setTextTimeFormat(tvTime, hudTimerModel.getTime());
        int i = DEFAULT_CONTAINER_COLOR;
        int i2 = WhenMappings.$EnumSwitchMapping$0[hudTimerModel.m10633getType().ordinal()];
        if (i2 == 1) {
            str = DEFAULT_COLOR;
        } else if (i2 == 2) {
            i = WARNING_CONTAINER_COLOR;
            str = WARNING_COLOR;
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = DANGER_CONTAINER_COLOR;
            str = DANGER_COLOR;
        }
        binding.timerContainer.setBackgroundResource(i);
        binding.tvTime.setTextColor(Color.parseColor(str));
        binding.ivTimeIcon.setColorFilter(Color.parseColor(str));
    }
}
