package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.HudCounterBinding;
import ru.mrlargha.commonui.databinding.HudCounterItemBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterContainerBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterStopwatchBinding;
import ru.mrlargha.commonui.elements.hud.presentation.TypeTaximeter;
import ru.mrlargha.commonui.elements.hud.presentation.TypeTaximeterValue;
import ru.mrlargha.commonui.elements.hud.presentation.models.TaximeterModel;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: HudCounter.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\n \u0012*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\rJ\u0018\u0010\u001a\u001a\n \u0012*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 2\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003JY\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020\u00172\b\b\u0002\u0010,\u001a\u00020\r2\b\b\u0002\u0010-\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010.J<\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\rH\u0002J£\u0001\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\b\b\u0001\u0010(\u001a\u00020\u00032\n\b\u0003\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010;\u001a\u00020\u00032\b\b\u0003\u0010<\u001a\u00020\u00032\b\b\u0001\u0010-\u001a\u00020\u00032\b\b\u0003\u0010=\u001a\u00020\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010B\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010CJa\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002072\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u00103\u001a\u00020\u00032\b\b\u0001\u0010-\u001a\u00020\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0015H\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020L0 2\u0006\u0010E\u001a\u00020FH\u0002J\n\u0010M\u001a\u00020\u0003*\u00020\u0003J'\u0010N\u001a\u00020\u0015*\u00020O2\n\b\u0003\u0010P\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010Q\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010RR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounter;", "", "backendID", "", "binding", "Lru/mrlargha/commonui/databinding/HudTaximeterBinding;", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "<init>", "(ILru/mrlargha/commonui/databinding/HudTaximeterBinding;Lru/mrlargha/commonui/core/IBackendNotifier;)V", "taximeterTimer", "Landroid/os/CountDownTimer;", "isRunningTaxiTimer", "", "typeTaximeterValue", "Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeterValue;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isTimer", "setTaximeterVisibility", "", "data", "", "setTaximeterCounterType", "isCountDown", "startTaxiTimerCountdown", "seconds", "startTaxiTimerCountUp", "initialElapsedSeconds", "stopTaxiTimer", "setTaxiPrice", "", "text", "setTaximeterType", "Lru/mrlargha/commonui/databinding/HudTaximeterContainerBinding;", "type", "setTaximeterLayoutType", "sumBg", "timerBg", "bg", "timeTextColor", "sumTitleText", "sumTextColor", "isBigTextSize", TtmlNode.ATTR_TTS_FONT_FAMILY, "(IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "setDemorganType", "titleImage", "containerImage", "containerBg", "textColor", "isScaleBg", "setCounterType", "firstItemType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounterItemType;", "secondItemType", "mainItemBg", "secondItemBg", "mainTextColor", "secondTextColor", "secondFontFamily", "titleText", "secondTitleText", "iconText", "icon", "secondIcon", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounterItemType;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounterItemType;ILjava/lang/Integer;Ljava/lang/Integer;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCounterItemType", "itemBinding", "Lru/mrlargha/commonui/databinding/HudCounterItemBinding;", "itemType", "itemBg", "(Lru/mrlargha/commonui/databinding/HudCounterItemBinding;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounterItemType;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setDefaultCounterType", "getCounterTextList", "Landroid/widget/TextView;", "dpToPx", "updateViewSize", "Landroid/view/View;", "widthRes", "heightRes", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCounter {
    private final int backendID;
    private final IBackendNotifier backendNotifier;
    private final HudTaximeterBinding binding;
    private final Context context;
    private boolean isRunningTaxiTimer;
    private boolean isTimer;
    private CountDownTimer taximeterTimer;
    private TypeTaximeterValue typeTaximeterValue;

    /* compiled from: HudCounter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TypeTaximeterValue.values().length];
            try {
                iArr[TypeTaximeterValue.PRISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeTaximeterValue.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeTaximeter.values().length];
            try {
                iArr2[TypeTaximeter.TAXI.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TypeTaximeter.BUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeTaximeter.TRUCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeTaximeter.DELIVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TypeTaximeter.DRIFT_POINT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[TypeTaximeter.HALLOWEEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TypeTaximeter.DEMORGAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[TypeTaximeter.ARMY_SECOND.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[TypeTaximeter.EASTER_RELAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[TypeTaximeter.FARMER_HEALTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[TypeTaximeter.SOCCER_GOALS.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[TypeTaximeter.EASTER_CHICKEN.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[TypeTaximeter.AIRPLANE.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[TypeTaximeter.RECORDING.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[TypeTaximeter.INTERCEPTION_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[TypeTaximeter.KILLING_ALIENS.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[TypeTaximeter.SPACE_RACE_1.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[TypeTaximeter.SPACE_RACE_2.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[TypeTaximeter.HEIGHT.ordinal()] = 19;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[HudCounterItemType.values().length];
            try {
                iArr3[HudCounterItemType.SIMPLE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[HudCounterItemType.ICON_WITH_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[HudCounterItemType.TITLE_WITH_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public HudCounter(int i, HudTaximeterBinding binding, IBackendNotifier backendNotifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(backendNotifier, "backendNotifier");
        this.backendID = i;
        this.binding = binding;
        this.backendNotifier = backendNotifier;
        this.typeTaximeterValue = TypeTaximeterValue.PRISE;
        this.context = binding.getRoot().getContext();
        this.isTimer = true;
    }

    public final void setTaximeterVisibility(String data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        HudTaximeterBinding hudTaximeterBinding = this.binding;
        LinearLayout btnNext = hudTaximeterBinding.hudTaximeterLayoutContainer.btnNext;
        Intrinsics.checkNotNullExpressionValue(btnNext, "btnNext");
        btnNext.setVisibility(8);
        Context context = hudTaximeterBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (UtilsKt.getArizonaType(context)) {
            i = Integer.parseInt(data);
        } else {
            TaximeterModel taximeterModel = (TaximeterModel) MapperKt.toModel(data, TaximeterModel.class);
            int show = taximeterModel.getShow();
            if (taximeterModel.getButtonText().length() > 0) {
                LinearLayout btnNext2 = hudTaximeterBinding.hudTaximeterLayoutContainer.btnNext;
                Intrinsics.checkNotNullExpressionValue(btnNext2, "btnNext");
                btnNext2.setVisibility(0);
                hudTaximeterBinding.hudTaximeterLayoutContainer.tvType.setText(taximeterModel.getButtonText());
            }
            i = show;
        }
        if (i == 0) {
            hudTaximeterBinding.getRoot().setVisibility(8);
            CountDownTimer countDownTimer = this.taximeterTimer;
            if (countDownTimer != null) {
                if (countDownTimer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                    countDownTimer = null;
                }
                countDownTimer.cancel();
                return;
            }
            return;
        }
        hudTaximeterBinding.getRoot().setVisibility(0);
    }

    public final Object setTaximeterCounterType(String data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        HudTaximeterBinding hudTaximeterBinding = this.binding;
        Context context = hudTaximeterBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (UtilsKt.getArizonaType(context)) {
            if (this.isTimer) {
                if (z) {
                    return startTaxiTimerCountdown(Integer.parseInt(data));
                }
                return startTaxiTimerCountUp(Integer.parseInt(data));
            }
            String str = data;
            hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(str);
            hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(str);
            HudCounterItemBinding firstItem = this.binding.counter.firstItem;
            Intrinsics.checkNotNullExpressionValue(firstItem, "firstItem");
            List<TextView> counterTextList = getCounterTextList(firstItem);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(counterTextList, 10));
            for (TextView textView : counterTextList) {
                textView.setText(str);
                arrayList.add(Unit.INSTANCE);
            }
            return arrayList;
        }
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(UtilsKt.formatTime(Long.parseLong(data) * 1000));
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(UtilsKt.formatTime(Long.parseLong(data) * 1000));
        HudCounterItemBinding firstItem2 = this.binding.counter.firstItem;
        Intrinsics.checkNotNullExpressionValue(firstItem2, "firstItem");
        List<TextView> counterTextList2 = getCounterTextList(firstItem2);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(counterTextList2, 10));
        for (TextView textView2 : counterTextList2) {
            textView2.setText(UtilsKt.formatTime(Long.parseLong(data) * 1000));
            arrayList2.add(Unit.INSTANCE);
        }
        return arrayList2;
    }

    private final CountDownTimer startTaxiTimerCountdown(int i) {
        final HudTaximeterBinding hudTaximeterBinding = this.binding;
        CountDownTimer countDownTimer = null;
        if (this.isRunningTaxiTimer) {
            this.isRunningTaxiTimer = false;
            CountDownTimer countDownTimer2 = this.taximeterTimer;
            if (countDownTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                countDownTimer2 = null;
            }
            countDownTimer2.cancel();
        }
        final long j = i * 1000;
        this.taximeterTimer = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$startTaxiTimerCountdown$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                Log.d("taximeter", "onTickDownTick: " + UtilsKt.formatTime(j2));
                HudTaximeterBinding.this.hudTaximeterLayoutContainer.tvTaximeterTime.setText(UtilsKt.formatTime(j2));
                HudTaximeterBinding.this.hudTaximeterArmySecond.tvArmySecondTimer.setText(UtilsKt.formatTime(j2));
                HudTaximeterBinding.this.counter.firstItem.tvSimpleTime.setText(UtilsKt.formatTime(j2));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.isRunningTaxiTimer = false;
            }
        };
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(UtilsKt.formatTime(j));
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(UtilsKt.formatTime(j));
        hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(UtilsKt.formatTime(j));
        this.isRunningTaxiTimer = true;
        CountDownTimer countDownTimer3 = this.taximeterTimer;
        if (countDownTimer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
        } else {
            countDownTimer = countDownTimer3;
        }
        return countDownTimer.start();
    }

    private final CountDownTimer startTaxiTimerCountUp(int i) {
        final HudTaximeterBinding hudTaximeterBinding = this.binding;
        CountDownTimer countDownTimer = null;
        if (this.isRunningTaxiTimer) {
            this.isRunningTaxiTimer = false;
            CountDownTimer countDownTimer2 = this.taximeterTimer;
            if (countDownTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                countDownTimer2 = null;
            }
            countDownTimer2.cancel();
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = RangesKt.coerceAtMost(i, 3599);
        final long j = (3600 - intRef.element) * 1000;
        this.taximeterTimer = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$startTaxiTimerCountUp$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (Ref.IntRef.this.element >= r2) {
                    onFinish();
                    return;
                }
                String formatTime = UtilsKt.formatTime(Ref.IntRef.this.element * 1000);
                hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime);
                hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime);
                hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(formatTime);
                Ref.IntRef.this.element++;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.isRunningTaxiTimer = false;
                String formatTime = UtilsKt.formatTime(Ref.IntRef.this.element * 1000);
                hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime);
                hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime);
                hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(formatTime);
            }
        };
        String formatTime = UtilsKt.formatTime(intRef.element * 1000);
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime);
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime);
        this.isRunningTaxiTimer = true;
        CountDownTimer countDownTimer3 = this.taximeterTimer;
        if (countDownTimer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
        } else {
            countDownTimer = countDownTimer3;
        }
        return countDownTimer.start();
    }

    public final void stopTaxiTimer(int i) {
        HudTaximeterBinding hudTaximeterBinding = this.binding;
        this.isRunningTaxiTimer = false;
        CountDownTimer countDownTimer = this.taximeterTimer;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
        long j = i * 1000;
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(UtilsKt.formatTime(j));
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(UtilsKt.formatTime(j));
    }

    public final List<Unit> setTaxiPrice(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        HudTaximeterContainerBinding hudTaximeterContainerBinding = this.binding.hudTaximeterLayoutContainer;
        HudCounterItemBinding secondItem = this.binding.counter.secondItem;
        Intrinsics.checkNotNullExpressionValue(secondItem, "secondItem");
        int i = WhenMappings.$EnumSwitchMapping$0[this.typeTaximeterValue.ordinal()];
        if (i == 1) {
            String str = text;
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str);
            List<TextView> counterTextList = getCounterTextList(secondItem);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(counterTextList, 10));
            for (TextView textView : counterTextList) {
                textView.setText(str);
                arrayList.add(Unit.INSTANCE);
            }
            return arrayList;
        } else if (i == 2) {
            String str2 = text + "%";
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str2);
            List<TextView> counterTextList2 = getCounterTextList(secondItem);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(counterTextList2, 10));
            for (TextView textView2 : counterTextList2) {
                textView2.setText(str2);
                arrayList2.add(Unit.INSTANCE);
            }
            return arrayList2;
        } else {
            String str3 = text;
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str3);
            List<TextView> counterTextList3 = getCounterTextList(secondItem);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(counterTextList3, 10));
            for (TextView textView3 : counterTextList3) {
                textView3.setText(str3);
                arrayList3.add(Unit.INSTANCE);
            }
            return arrayList3;
        }
    }

    public final HudTaximeterContainerBinding setTaximeterType(int i) {
        HudTaximeterContainerBinding hudTaximeterContainerBinding;
        HudTaximeterContainerBinding hudTaximeterContainerBinding2;
        HudTaximeterBinding hudTaximeterBinding = this.binding;
        setDefaultCounterType();
        ImageView ivGoalsIcon = hudTaximeterBinding.hudTaximeterArmySecond.ivGoalsIcon;
        Intrinsics.checkNotNullExpressionValue(ivGoalsIcon, "ivGoalsIcon");
        ivGoalsIcon.setVisibility(8);
        this.typeTaximeterValue = TypeTaximeterValue.PRISE;
        HudTaximeterContainerBinding hudTaximeterContainerBinding3 = hudTaximeterBinding.hudTaximeterLayoutContainer;
        ImageView ivDopIcon = hudTaximeterContainerBinding3.ivDopIcon;
        Intrinsics.checkNotNullExpressionValue(ivDopIcon, "ivDopIcon");
        ivDopIcon.setVisibility(8);
        TypeTaximeter valueOf = TypeTaximeter.Companion.valueOf(i);
        hudTaximeterContainerBinding3.btnNext.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HudCounter.setTaximeterType$lambda$0$0$0(HudCounter.this, view);
            }
        });
        LinearLayout root = hudTaximeterContainerBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout root2 = hudTaximeterBinding.hudTaximeterArmySecond.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        LinearLayout root3 = hudTaximeterBinding.hudTaximeterLayoutContainer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        FrameLayout root4 = hudTaximeterBinding.counter.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$1[valueOf.ordinal()]) {
            case 1:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_sum, R.drawable.bg_taximeter_time, null, "#FFDD28", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 2:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_bus_sum, R.drawable.bg_taximeter_bus_time, null, "#28D8FF", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 3:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_truck_sum, R.drawable.bg_taximeter_truck_time, null, "#ADFF2F", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 4:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_delivery_summ, R.drawable.bg_taximeter_delivery_time, null, "#FF2372", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 5:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_drift_summ, R.drawable.bg_taximeter_drift_time, null, "#FF5900", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 6:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_halloween_summ, R.drawable.bg_taximeter_halloween_time, null, "#FF0000", null, "#000000", false, R.font.ds_digital, 84, null);
                break;
            case 7:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                LinearLayout root5 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
                root5.setVisibility(8);
                setDemorganType$default(this, R.drawable.hud_taximeter_stopwatch_demorgan_logo, R.drawable.hud_taximeter_stopwatch_demorgan_second_bg, R.drawable.hud_taximeter_stopwatch_demorgan_bg, "#FF4343", 0, false, 48, null);
                break;
            case 8:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                LinearLayout root6 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root6, "getRoot(...)");
                root6.setVisibility(8);
                setDemorganType$default(this, R.drawable.hud_taximeter_stopwatch_army_logo, R.drawable.hud_taximeter_stopwatch_army_second_bg, R.drawable.hud_taximeter_stopwatch_army_bg, "#75D100", 0, false, 48, null);
                break;
            case 9:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                LinearLayout root7 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root7, "getRoot(...)");
                root7.setVisibility(8);
                setDemorganType(R.drawable.hud_taximeter_stopwatch_easter_relay_logo, R.drawable.hud_taximeter_stopwatch_easter_relay_second_bg, R.drawable.hud_taximeter_stopwatch_easter_relay_bg, "#FFFFFF", R.font.harreegh_popped_cyrillic, true);
                break;
            case 10:
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                ImageView imageView = hudTaximeterContainerBinding.ivDopIcon;
                imageView.setImageResource(R.drawable.hud_taximeter_farmer_health_heart_icon);
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_farmer_health_sum, R.drawable.hud_taximeter_farmer_health_time, Integer.valueOf(R.drawable.hud_taximeter_farmer_health_bg), "#FFFFFF", "Здоровье", null, false, 0, 160, null);
                break;
            case 11:
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.TEXT;
                hudTaximeterContainerBinding = hudTaximeterContainerBinding3;
                ImageView imageView2 = hudTaximeterContainerBinding.ivDopIcon;
                imageView2.setImageResource(R.drawable.hud_taximeter_stopwatch_soccer_goals_icon);
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(0);
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_soccer_goals_sum, R.drawable.hud_taximeter_soccer_goals_time, Integer.valueOf(R.drawable.hud_taximeter_soccer_goals_bg), "#FFFFFF", "Голов", null, false, 0, 160, null);
                break;
            case 12:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_easter_chicken_summ, R.drawable.hud_taximeter_easter_chicken_time, Integer.valueOf(R.drawable.hud_taximeter_easter_chicken_bg), "#D0FFFA", "Состояние прицепа", null, false, 0, 160, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 13:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.TEXT;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_bus_sum, R.drawable.bg_taximeter_bus_time, null, "#28D8FF", null, "#000000", false, R.font.ds_digital, 84, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 14:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                setCounterType$default(this, HudCounterItemType.ICON_WITH_TEXT, HudCounterItemType.TITLE_WITH_TEXT, R.drawable.hud_counter_recording_bg, Integer.valueOf(R.drawable.hud_counter_recording_item_bg), null, Color.parseColor("#072100"), 0, R.font.moscow_2024, 0, this.context.getString(R.string.progress), null, this.context.getString(R.string.recording), Integer.valueOf(R.drawable.hud_counter_sound_ic), null, 9552, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 15:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                hudTaximeterBinding.counter.firstItem.tvSimpleTime.setTextSize(0, this.context.getResources().getDimension(R.dimen._11sdp));
                hudTaximeterBinding.counter.secondItem.tvProgress.setTextSize(0, this.context.getResources().getDimension(R.dimen._11sdp));
                HudCounterItemType hudCounterItemType = HudCounterItemType.SIMPLE_TEXT;
                HudCounterItemType hudCounterItemType2 = HudCounterItemType.TITLE_WITH_TEXT;
                int i2 = R.drawable.hud_counter_interception_data_bg;
                int i3 = R.font.moscow_2024;
                int i4 = R.drawable.hud_counter_interception_data_item_bg;
                setCounterType$default(this, hudCounterItemType, hudCounterItemType2, i2, Integer.valueOf(i4), null, Color.parseColor("#000321"), 0, i3, 0, this.context.getString(R.string.progress), null, null, null, null, 15696, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 16:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                hudTaximeterBinding.counter.secondItem.tvProgress.setPadding(0, dpToPx(2), 0, 0);
                setCounterType$default(this, HudCounterItemType.SIMPLE_TEXT, HudCounterItemType.TITLE_WITH_TEXT, R.drawable.hud_counter_killing_alients_bg, Integer.valueOf(R.drawable.hud_counter_killing_alients_item_bg), null, Color.parseColor("#3CFF00"), 0, R.font.mk_90, 0, this.context.getString(R.string.progress), null, null, null, null, 15696, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 17:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = false;
                hudTaximeterBinding.counter.secondItem.tvProgress.setTextSize(0, this.context.getResources().getDimension(R.dimen._11sdp));
                hudTaximeterBinding.counter.firstItem.tvProgress.setTextSize(0, this.context.getResources().getDimension(R.dimen._11sdp));
                hudTaximeterBinding.counter.secondItem.tvProgress.setPadding(0, dpToPx(-2), 0, 0);
                hudTaximeterBinding.counter.firstItem.tvProgress.setPadding(0, dpToPx(-2), 0, 0);
                setCounterType$default(this, HudCounterItemType.TITLE_WITH_TEXT, HudCounterItemType.TITLE_WITH_TEXT, R.drawable.hud_counter_space_race_1_bg, Integer.valueOf(R.drawable.hud_counter_space_race_1_item_bg), Integer.valueOf(R.drawable.hud_counter_space_race_1_second_item_bg), -1, 0, R.font.race_line, 0, "позиция", "круги", null, null, null, 14656, null);
                Typeface font = ResourcesCompat.getFont(this.context, R.font.heading_now_66_bold);
                this.binding.counter.firstItem.tvTitleProgress.setTypeface(font);
                this.binding.counter.secondItem.tvTitleProgress.setTypeface(font);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 18:
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                this.isTimer = true;
                ImageView ivIc = hudTaximeterBinding.counter.secondItem.ivIc;
                Intrinsics.checkNotNullExpressionValue(ivIc, "ivIc");
                updateViewSize$default(this, ivIc, null, Integer.valueOf(R.dimen._7sdp), 1, null);
                hudTaximeterBinding.counter.secondItem.tvTitleWithIc.setTextSize(10.0f);
                HudCounterItemType hudCounterItemType3 = HudCounterItemType.ICON_WITH_TEXT;
                HudCounterItemType hudCounterItemType4 = HudCounterItemType.ICON_WITH_TEXT;
                int i5 = R.drawable.hud_counter_space_race_2_bg;
                int i6 = R.drawable.hud_counter_space_race_second_item_bg;
                setCounterType$default(this, hudCounterItemType3, hudCounterItemType4, i5, null, Integer.valueOf(i6), -1, 0, R.font.race_line, 0, null, null, "5/8", Integer.valueOf(R.drawable.hud_counter_space_race_logo), Integer.valueOf(R.drawable.hud_counter_man_ic), 1864, null);
                hudTaximeterBinding.counter.firstItem.tvTitleWithIc.setText("");
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            case 19:
                this.isTimer = true;
                ViewGroup.LayoutParams layoutParams = this.binding.counter.secondItem.getRoot().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.height = (int) this.context.getResources().getDimension(R.dimen._14sdp);
                layoutParams2.width = (int) this.context.getResources().getDimension(R.dimen._60sdp);
                layoutParams2.gravity = 17;
                this.binding.counter.secondItem.getRoot().setLayoutParams(layoutParams2);
                ImageView ivIc2 = hudTaximeterBinding.counter.firstItem.ivIc;
                Intrinsics.checkNotNullExpressionValue(ivIc2, "ivIc");
                updateViewSize$default(this, ivIc2, null, Integer.valueOf(R.dimen._12sdp), 1, null);
                hudTaximeterBinding.counter.firstItem.tvTitleWithIc.setTextSize(0, this.context.getResources().getDimension(R.dimen._7sdp));
                hudTaximeterBinding.counter.secondItem.tvSimpleTime.setTextSize(0, this.context.getResources().getDimension(R.dimen._6sdp));
                HudCounterItemType hudCounterItemType5 = HudCounterItemType.ICON_WITH_TEXT;
                HudCounterItemType hudCounterItemType6 = HudCounterItemType.SIMPLE_TEXT;
                int i7 = R.drawable.hud_counter_height_bg;
                int i8 = R.drawable.hud_counter_height_second_item_bg;
                hudTaximeterContainerBinding2 = hudTaximeterContainerBinding3;
                setCounterType$default(this, hudCounterItemType5, hudCounterItemType6, i7, null, Integer.valueOf(i8), Color.parseColor("#2EEF3B"), -1, R.font.spi_key_bit, R.font.heading_now_64_regular, null, null, "Высота полета", Integer.valueOf(R.drawable.hud_counter_arrows_ic), null, 9736, null);
                hudTaximeterContainerBinding = hudTaximeterContainerBinding2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(hudTaximeterContainerBinding, "with(...)");
        return hudTaximeterContainerBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTaximeterType$lambda$0$0$0(HudCounter hudCounter, View view) {
        hudCounter.backendNotifier.clickedWrapper(hudCounter.backendID, 10, 8);
    }

    static /* synthetic */ void setTaximeterLayoutType$default(HudCounter hudCounter, int i, int i2, Integer num, String str, String str2, String str3, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            num = null;
        }
        hudCounter.setTaximeterLayoutType(i, i2, num, str, (i4 & 16) != 0 ? "Сумма" : str2, (i4 & 32) != 0 ? "#FFFFFF" : str3, (i4 & 64) != 0 ? true : z, (i4 & 128) != 0 ? R.font.harreegh_popped_cyrillic : i3);
    }

    private final void setTaximeterLayoutType(int i, int i2, Integer num, String str, String str2, String str3, boolean z, int i3) {
        HudTaximeterContainerBinding hudTaximeterContainerBinding = this.binding.hudTaximeterLayoutContainer;
        LinearLayout root = hudTaximeterContainerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        Context context = hudTaximeterContainerBinding.getRoot().getContext();
        hudTaximeterContainerBinding.priseTimeContainer.setImageResource(num != null ? num.intValue() : R.drawable.bg_taximeter);
        if (z) {
            TextView textView = hudTaximeterContainerBinding.tvTaximeterSumTitle;
            Intrinsics.checkNotNull(context);
            textView.setTextSize(ConverterKt.pxToDp(20.0f, context));
        } else {
            TextView textView2 = hudTaximeterContainerBinding.tvTaximeterSumTitle;
            Intrinsics.checkNotNull(context);
            textView2.setTextSize(ConverterKt.pxToDp(15.0f, context));
        }
        Typeface font = ResourcesCompat.getFont(context, i3);
        hudTaximeterContainerBinding.tvTaximeterTime.setTypeface(font);
        hudTaximeterContainerBinding.tvTaximeterSum.setTypeface(font);
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setTypeface(font);
        hudTaximeterContainerBinding.linearSum.setBackgroundResource(i);
        hudTaximeterContainerBinding.linearTime.setBackgroundResource(i2);
        hudTaximeterContainerBinding.btnNext.setBackgroundResource(i);
        hudTaximeterContainerBinding.tvTaximeterTime.setTextColor(Color.parseColor(str));
        hudTaximeterContainerBinding.tvTaximeterSum.setTextColor(Color.parseColor(str3));
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setTextColor(Color.parseColor(str3));
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setText(str2);
    }

    static /* synthetic */ void setDemorganType$default(HudCounter hudCounter, int i, int i2, int i3, String str, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            i4 = R.font.ds_digital;
        }
        int i6 = i4;
        if ((i5 & 32) != 0) {
            z = false;
        }
        hudCounter.setDemorganType(i, i2, i3, str, i6, z);
    }

    private final void setDemorganType(int i, int i2, int i3, String str, int i4, boolean z) {
        HudTaximeterStopwatchBinding hudTaximeterStopwatchBinding = this.binding.hudTaximeterArmySecond;
        FrameLayout root = hudTaximeterStopwatchBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        if (z) {
            ImageView ivBgSmaller = hudTaximeterStopwatchBinding.ivBgSmaller;
            Intrinsics.checkNotNullExpressionValue(ivBgSmaller, "ivBgSmaller");
            ivBgSmaller.setVisibility(8);
            ImageView ivBgBigger = hudTaximeterStopwatchBinding.ivBgBigger;
            Intrinsics.checkNotNullExpressionValue(ivBgBigger, "ivBgBigger");
            ivBgBigger.setVisibility(0);
            hudTaximeterStopwatchBinding.ivBgBigger.setImageResource(i3);
        } else {
            ImageView ivBgBigger2 = hudTaximeterStopwatchBinding.ivBgBigger;
            Intrinsics.checkNotNullExpressionValue(ivBgBigger2, "ivBgBigger");
            ivBgBigger2.setVisibility(8);
            ImageView ivBgSmaller2 = hudTaximeterStopwatchBinding.ivBgSmaller;
            Intrinsics.checkNotNullExpressionValue(ivBgSmaller2, "ivBgSmaller");
            ivBgSmaller2.setVisibility(0);
            hudTaximeterStopwatchBinding.ivBgSmaller.setImageResource(i3);
        }
        Typeface font = ResourcesCompat.getFont(hudTaximeterStopwatchBinding.getRoot().getContext(), i4);
        hudTaximeterStopwatchBinding.armySecondTitle.setImageResource(i);
        hudTaximeterStopwatchBinding.secondContainer.setBackgroundResource(i2);
        hudTaximeterStopwatchBinding.tvArmySecondTimer.setTextColor(Color.parseColor(str));
        hudTaximeterStopwatchBinding.tvArmySecondTimer.setTypeface(font);
        FrameLayout root2 = hudTaximeterStopwatchBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(0);
    }

    static /* synthetic */ void setCounterType$default(HudCounter hudCounter, HudCounterItemType hudCounterItemType, HudCounterItemType hudCounterItemType2, int i, Integer num, Integer num2, int i2, int i3, int i4, int i5, String str, String str2, String str3, Integer num3, Integer num4, int i6, Object obj) {
        Integer num5 = (i6 & 8) != 0 ? null : num;
        Integer num6 = (i6 & 16) != 0 ? num5 : num2;
        int i7 = (i6 & 64) != 0 ? i2 : i3;
        int i8 = (i6 & 256) != 0 ? i4 : i5;
        String str4 = (i6 & 512) != 0 ? null : str;
        String str5 = (i6 & 1024) != 0 ? str4 : str2;
        String str6 = (i6 & 2048) != 0 ? null : str3;
        Integer num7 = (i6 & 4096) != 0 ? null : num3;
        hudCounter.setCounterType(hudCounterItemType, hudCounterItemType2, i, num5, num6, i2, i7, i4, i8, str4, str5, str6, num7, (i6 & 8192) != 0 ? num7 : num4);
    }

    private final void setCounterType(HudCounterItemType hudCounterItemType, HudCounterItemType hudCounterItemType2, int i, Integer num, Integer num2, int i2, int i3, int i4, int i5, String str, String str2, String str3, Integer num3, Integer num4) {
        HudCounterBinding hudCounterBinding = this.binding.counter;
        FrameLayout root = hudCounterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudCounterBinding.ivBg.setImageResource(i);
        HudCounterItemBinding firstItem = hudCounterBinding.firstItem;
        Intrinsics.checkNotNullExpressionValue(firstItem, "firstItem");
        setCounterItemType(firstItem, hudCounterItemType, num, i2, i4, str, str3, num3);
        HudCounterItemBinding secondItem = hudCounterBinding.secondItem;
        Intrinsics.checkNotNullExpressionValue(secondItem, "secondItem");
        setCounterItemType(secondItem, hudCounterItemType2, num2, i3, i5, str2, str3, num4);
    }

    static /* synthetic */ void setCounterItemType$default(HudCounter hudCounter, HudCounterItemBinding hudCounterItemBinding, HudCounterItemType hudCounterItemType, Integer num, int i, int i2, String str, String str2, Integer num2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            str = null;
        }
        if ((i3 & 64) != 0) {
            str2 = null;
        }
        if ((i3 & 128) != 0) {
            num2 = null;
        }
        hudCounter.setCounterItemType(hudCounterItemBinding, hudCounterItemType, num, i, i2, str, str2, num2);
    }

    private final void setCounterItemType(HudCounterItemBinding hudCounterItemBinding, HudCounterItemType hudCounterItemType, Integer num, int i, int i2, String str, String str2, Integer num2) {
        TextView tvSimpleTime = hudCounterItemBinding.tvSimpleTime;
        Intrinsics.checkNotNullExpressionValue(tvSimpleTime, "tvSimpleTime");
        LinearLayout textWithIcon = hudCounterItemBinding.textWithIcon;
        Intrinsics.checkNotNullExpressionValue(textWithIcon, "textWithIcon");
        LinearLayout textWithTitle = hudCounterItemBinding.textWithTitle;
        Intrinsics.checkNotNullExpressionValue(textWithTitle, "textWithTitle");
        for (View view : CollectionsKt.listOf((Object[]) new View[]{tvSimpleTime, textWithIcon, textWithTitle})) {
            view.setVisibility(8);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$2[hudCounterItemType.ordinal()];
        if (i3 == 1) {
            TextView tvSimpleTime2 = hudCounterItemBinding.tvSimpleTime;
            Intrinsics.checkNotNullExpressionValue(tvSimpleTime2, "tvSimpleTime");
            tvSimpleTime2.setVisibility(0);
        } else if (i3 == 2) {
            LinearLayout textWithIcon2 = hudCounterItemBinding.textWithIcon;
            Intrinsics.checkNotNullExpressionValue(textWithIcon2, "textWithIcon");
            textWithIcon2.setVisibility(0);
        } else if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            LinearLayout textWithTitle2 = hudCounterItemBinding.textWithTitle;
            Intrinsics.checkNotNullExpressionValue(textWithTitle2, "textWithTitle");
            textWithTitle2.setVisibility(0);
        }
        List listOf = CollectionsKt.listOf((Object[]) new TextView[]{hudCounterItemBinding.tvProgress, hudCounterItemBinding.tvSimpleTime, hudCounterItemBinding.tvTitleProgress, hudCounterItemBinding.tvProgress, hudCounterItemBinding.tvTitleWithIc});
        Typeface font = ResourcesCompat.getFont(this.context, i2);
        List<TextView> list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TextView textView : list) {
            textView.setTextColor(i);
            textView.setTypeface(font);
            arrayList.add(Unit.INSTANCE);
        }
        if (num != null) {
            hudCounterItemBinding.ivItemBg.setImageResource(num.intValue());
        } else {
            hudCounterItemBinding.ivItemBg.setImageDrawable(null);
        }
        if (num2 != null) {
            hudCounterItemBinding.ivIc.setImageResource(num2.intValue());
        } else {
            hudCounterItemBinding.ivIc.setImageDrawable(null);
        }
        if (str2 != null) {
            hudCounterItemBinding.tvTitleWithIc.setText(str2);
        }
        hudCounterItemBinding.tvTitleProgress.setText(str != null ? str : "");
    }

    private final void setDefaultCounterType() {
        HudTaximeterBinding hudTaximeterBinding = this.binding;
        ImageView ivIc = hudTaximeterBinding.counter.secondItem.ivIc;
        Intrinsics.checkNotNullExpressionValue(ivIc, "ivIc");
        updateViewSize$default(this, ivIc, null, Integer.valueOf(R.dimen._10sdp), 1, null);
        hudTaximeterBinding.counter.secondItem.tvTitleWithIc.setTextSize(0, this.context.getResources().getDimension(R.dimen._5sdp));
        hudTaximeterBinding.counter.firstItem.tvSimpleTime.setTextSize(0, this.context.getResources().getDimension(R.dimen._9sdp));
        hudTaximeterBinding.counter.secondItem.tvProgress.setTextSize(0, this.context.getResources().getDimension(R.dimen._9sdp));
        hudTaximeterBinding.counter.firstItem.tvProgress.setTextSize(0, this.context.getResources().getDimension(R.dimen._9sdp));
        hudTaximeterBinding.counter.firstItem.tvTitleWithIc.setTextSize(0, this.context.getResources().getDimension(R.dimen._5sdp));
        ImageView ivIc2 = hudTaximeterBinding.counter.firstItem.ivIc;
        Intrinsics.checkNotNullExpressionValue(ivIc2, "ivIc");
        updateViewSize$default(this, ivIc2, null, Integer.valueOf(R.dimen._10sdp), 1, null);
        hudTaximeterBinding.counter.secondItem.tvProgress.setPadding(0, 0, 0, 0);
        hudTaximeterBinding.counter.firstItem.tvProgress.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = this.binding.counter.secondItem.getRoot().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) this.context.getResources().getDimension(R.dimen._20sdp);
        this.binding.counter.secondItem.getRoot().setLayoutParams(layoutParams);
        this.binding.counter.secondItem.tvSimpleTime.setTextSize(0, dpToPx(10));
    }

    private final List<TextView> getCounterTextList(HudCounterItemBinding hudCounterItemBinding) {
        TextView tvSimpleTime = hudCounterItemBinding.tvSimpleTime;
        Intrinsics.checkNotNullExpressionValue(tvSimpleTime, "tvSimpleTime");
        TextView tvTitleWithIc = hudCounterItemBinding.tvTitleWithIc;
        Intrinsics.checkNotNullExpressionValue(tvTitleWithIc, "tvTitleWithIc");
        TextView tvProgress = hudCounterItemBinding.tvProgress;
        Intrinsics.checkNotNullExpressionValue(tvProgress, "tvProgress");
        return CollectionsKt.listOf((Object[]) new TextView[]{tvSimpleTime, tvTitleWithIc, tvProgress});
    }

    public final int dpToPx(int i) {
        return (int) (i * this.context.getResources().getDisplayMetrics().density);
    }

    public static /* synthetic */ void updateViewSize$default(HudCounter hudCounter, View view, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        hudCounter.updateViewSize(view, num, num2);
    }

    public final void updateViewSize(View view, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (num != null) {
            layoutParams.width = view.getContext().getResources().getDimensionPixelSize(num.intValue());
        }
        if (num2 != null) {
            layoutParams.height = view.getContext().getResources().getDimensionPixelSize(num2.intValue());
        }
        view.setLayoutParams(layoutParams);
    }
}
