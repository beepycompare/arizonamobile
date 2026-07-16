package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time;

import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementTimeBinding;
import ru.mrlargha.commonui.databinding.HudElementTimeItemBinding;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: TimeElement.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010 \u001a\u00020\u0017J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/TimeElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementTimeBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementTimeBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementTimeBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "itemsList", "", "Lru/mrlargha/commonui/databinding/HudElementTimeItemBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getItemsList", "()Ljava/util/List;", "clockJob", "Lkotlinx/coroutines/Job;", "timesLeft", "", "setVisibility", "", "data", "", "setInfo", "setData", "info", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/TimeData;", "setView", "startClock", "stopClock", "setDateTime", "timeLong", "setItem", "item", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/Component;", "itemBinding", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeElement {
    private final HudElementTimeBinding binding;
    private Job clockJob;
    private final List<HudElementTimeItemBinding> itemsList;
    private final SAMPUIElement notifier;
    private long timesLeft;

    public TimeElement(HudElementTimeBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        this.itemsList = CollectionsKt.listOf((Object[]) new HudElementTimeItemBinding[]{binding.card0, binding.card1, binding.card2, binding.card3, binding.card4, binding.card5, binding.card6});
        binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time.TimeElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(TimeElement.this.notifier, 100, 100, null, 4, null);
            }
        });
    }

    public final HudElementTimeBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final List<HudElementTimeItemBinding> getItemsList() {
        return this.itemsList;
    }

    public final void setVisibility(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean areEqual = Intrinsics.areEqual(data, "1");
        HudElementTimeBinding hudElementTimeBinding = this.binding;
        if (areEqual) {
            hudElementTimeBinding.main.setTranslationX(800.0f);
            this.binding.getRoot().setVisibility(0);
            this.binding.main.animate().translationX(0.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
        } else {
            hudElementTimeBinding.main.animate().translationX(800.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
            FrameLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time.TimeElement$setVisibility$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    TimeElement.this.getBinding().getRoot().setVisibility(8);
                }
            }, 1000L);
        }
        stopClock();
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.timesLeft = 0L;
        setData((TimeData) ((!MapperKt.isJsonValid(data) || Intrinsics.areEqual(data, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(data, "{}") || data.length() == 0) ? null : MapperKt.getGson().fromJson(data, (Class<Object>) TimeData.class)));
    }

    private final void setData(TimeData timeData) {
        if (timeData == null) {
            setVisibility("0");
            return;
        }
        setVisibility("1");
        startClock(timeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setView(TimeData timeData) {
        HudElementTimeBinding hudElementTimeBinding = this.binding;
        for (HudElementTimeItemBinding hudElementTimeItemBinding : this.itemsList) {
            hudElementTimeItemBinding.getRoot().setVisibility(8);
        }
        int size = 1 - (timeData.getComponents().size() % 2);
        int i = 0;
        for (Object obj : timeData.getComponents()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Component component = (Component) obj;
            HudElementTimeItemBinding hudElementTimeItemBinding2 = (HudElementTimeItemBinding) CollectionsKt.getOrNull(this.itemsList, i + size);
            if (hudElementTimeItemBinding2 == null) {
                return;
            }
            setItem(component, hudElementTimeItemBinding2);
            i = i2;
        }
        int playedToday = timeData.getPlayedToday();
        if (playedToday > 3600) {
            TextView textView = hudElementTimeBinding.tvTodayTime;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(playedToday / DateCalculationsKt.SECONDS_PER_HOUR), Integer.valueOf((playedToday % DateCalculationsKt.SECONDS_PER_HOUR) / 60), Integer.valueOf(playedToday % 60)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        } else {
            TextView textView2 = hudElementTimeBinding.tvTodayTime;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(playedToday / 60), Integer.valueOf(timeData.getPlayedToday() % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView2.setText(format2);
        }
        long playedHour = timeData.getPlayedHour() + this.timesLeft;
        TextView textView3 = hudElementTimeBinding.tvHourTime;
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(playedHour / 60), Long.valueOf(playedHour % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        textView3.setText(format3);
        setDateTime(timeData.getTimestamp() + this.timesLeft);
    }

    private final void startClock(TimeData timeData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TimeElement$startClock$1(this, timeData, null), 3, null);
        this.clockJob = launch$default;
    }

    public final void stopClock() {
        this.timesLeft = 0L;
        Job job = this.clockJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.clockJob = null;
    }

    private final void setDateTime(long j) {
        DateParts timestampToParts = TimeElementKt.timestampToParts(j);
        HudElementTimeBinding hudElementTimeBinding = this.binding;
        TextView textView = hudElementTimeBinding.tvDate;
        int day = timestampToParts.getDay();
        String month = timestampToParts.getMonth();
        textView.setText(day + " " + month + " " + timestampToParts.getYear());
        TextView textView2 = hudElementTimeBinding.tvTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(timestampToParts.getHour()), Integer.valueOf(timestampToParts.getMinute()), Integer.valueOf(timestampToParts.getSecond())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
    }

    private final void setItem(Component component, HudElementTimeItemBinding hudElementTimeItemBinding) {
        int i;
        String str;
        hudElementTimeItemBinding.getRoot().setVisibility(0);
        hudElementTimeItemBinding.title.setText(component.getTitle());
        Integer multiplier = component.getMultiplier();
        CustomCardView customCardView = hudElementTimeItemBinding.multiplierCard;
        if (multiplier == null || multiplier.intValue() <= 1) {
            i = 8;
        } else {
            hudElementTimeItemBinding.multiplier.setText("X" + multiplier);
            i = 0;
        }
        customCardView.setVisibility(i);
        if (component.getDescription() != null) {
            if (component.getDescription().length() > 14) {
                hudElementTimeItemBinding.timer.setText(MoneyElementKt.resize(component.getDescription(), 0.8f));
            } else {
                hudElementTimeItemBinding.timer.setText(component.getDescription());
            }
        }
        if (component.getTimer() != null) {
            long intValue = component.getTimer().intValue() - this.timesLeft;
            if (intValue > 86400) {
                long j = intValue / 86400;
                TextView textView = hudElementTimeItemBinding.timer;
                long j2 = j % 10;
                if (j2 == 1) {
                    str = " день";
                } else if (j2 == 2 || j2 == 3 || j2 == 4) {
                    str = " дня";
                } else {
                    str = " дней";
                }
                textView.setText(j + str);
            } else if (intValue > 3600) {
                TextView textView2 = hudElementTimeItemBinding.timer;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(intValue / 3600), Long.valueOf((intValue % 3600) / 60), Long.valueOf(intValue % 60)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
            } else if (intValue <= 0) {
                hudElementTimeItemBinding.timer.setText("00:00");
            } else {
                TextView textView3 = hudElementTimeItemBinding.timer;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(intValue / 60), Long.valueOf(intValue % 60)}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView3.setText(format2);
            }
        }
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + (UtilsKt.isArizonaType() ? "systems/time/icons/" : "systems/time_menu/") + component.getImage()).into(hudElementTimeItemBinding.image);
        String str2 = (String) CollectionsKt.getOrNull(component.getGradientColors(), 0);
        String str3 = DonateUtilsKt.TRANSPARENT_COLOR;
        if (str2 == null) {
            str2 = DonateUtilsKt.TRANSPARENT_COLOR;
        }
        int parseColor = Color.parseColor(str2);
        String str4 = (String) CollectionsKt.getOrNull(component.getGradientColors(), 1);
        if (str4 != null) {
            str3 = str4;
        }
        int parseColor2 = Color.parseColor(str3);
        CustomCardView mainCard = hudElementTimeItemBinding.mainCard;
        Intrinsics.checkNotNullExpressionValue(mainCard, "mainCard");
        CustomCardView.setBackground$default(mainCard, parseColor, parseColor2, null, null, 12, null);
        CustomCardView innerCard = hudElementTimeItemBinding.innerCard;
        Intrinsics.checkNotNullExpressionValue(innerCard, "innerCard");
        CustomCardView.setBackground$default(innerCard, parseColor2, 0, null, null, 12, null);
        hudElementTimeItemBinding.innerCard.setBackgroundAlpha(50);
    }
}
