package com.arizonagames.feature.arizona.bank.pages;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankLotteryTaskInfo;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankImageLoaderKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0018J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "icon", "Landroid/widget/ImageView;", "platformIcon", "title", "Landroid/widget/TextView;", "description", "stateBadge", "stateIcon", RemoteConfigConstants.ResponseFieldKey.STATE, "bind", "", "task", "Lcom/arizonagames/feature/arizona/bank/BankLotteryTaskInfo;", "actionsEnabled", "", "onTaskClick", "Lkotlin/Function1;", "", "bindTaskIcon", "bindPlatformIcon", "bindTaskBackground", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BankLotteryTaskViewHolder extends RecyclerView.ViewHolder {
    private static final Companion Companion = new Companion(null);
    private static final int DEFAULT_TASK_BACKGROUND_COLOR = Color.parseColor("#35B8F5");
    @Deprecated
    public static final int TASK_GRADIENT_END_ALPHA = 128;
    private final CustomCardView card;
    private final TextView description;
    private final ImageView icon;
    private final ImageView platformIcon;
    private final TextView state;
    private final CustomCardView stateBadge;
    private final ImageView stateIcon;
    private final TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankLotteryTaskViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.bank_lottery_task_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.card = (CustomCardView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.bank_lottery_task_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.icon = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.bank_lottery_task_platform_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.platformIcon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.bank_lottery_task_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.title = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.bank_lottery_task_description);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.description = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.bank_lottery_task_state_badge);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.stateBadge = (CustomCardView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.bank_lottery_task_state_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.stateIcon = (ImageView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.bank_lottery_task_state);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.state = (TextView) findViewById8;
    }

    public final void bind(final BankLotteryTaskInfo task, boolean z, final Function1<? super Integer, Unit> onTaskClick) {
        Regex regex;
        int i;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
        bindTaskBackground(task);
        TextView textView = this.title;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        regex = BankLotteryPageControllerKt.LOTTERY_TASK_PLATFORM_TOKEN_REGEX;
        String obj = StringsKt.trim((CharSequence) regex.replace(task.getTitle(), "")).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = obj.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, upperCase, 0.0f, null, 3, null));
        bindPlatformIcon(task);
        bindTaskIcon(task);
        this.description.setText(task.getDesc());
        TextView textView2 = this.state;
        if (task.getCompleted()) {
            i = R.string.bank_lottery_task_done;
        } else {
            i = R.string.bank_lottery_task_action;
        }
        textView2.setText(i);
        BankClickAnimationKt.setAnimatedClickListener(this.stateBadge, (!z || task.getCompleted()) ? null : new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryTaskViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BankLotteryTaskViewHolder.bind$lambda$0(Function1.this, task);
            }
        });
        boolean completed = task.getCompleted();
        CustomCardView customCardView = this.stateBadge;
        if (completed) {
            customCardView.setBackground(0);
            this.stateIcon.setVisibility(0);
            this.stateIcon.setColorFilter(Color.parseColor("#B6FF00"));
            this.state.setTextColor(Color.parseColor("#B6FF00"));
        } else {
            customCardView.setBackground(Color.parseColor("#FFE600"));
            this.stateIcon.setVisibility(8);
            this.stateIcon.clearColorFilter();
            this.state.setTextColor(Color.parseColor("#050505"));
        }
        this.stateBadge.setBackgroundAlpha(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bind$lambda$0(Function1 function1, BankLotteryTaskInfo bankLotteryTaskInfo) {
        function1.invoke(Integer.valueOf(bankLotteryTaskInfo.getId()));
        return Unit.INSTANCE;
    }

    private final void bindTaskIcon(BankLotteryTaskInfo bankLotteryTaskInfo) {
        boolean z = true;
        if (!StringsKt.contains((CharSequence) bankLotteryTaskInfo.getTitle(), (CharSequence) ":telegram:", true) && !StringsKt.contains((CharSequence) bankLotteryTaskInfo.getTitle(), (CharSequence) ":tg:", true)) {
            z = false;
        }
        BankImageLoaderKt.loadBankImage$default(this.icon, z ? "" : bankLotteryTaskInfo.getImgPath(), Integer.valueOf(R.drawable.bank_ic_ticket), false, 4, null);
    }

    private final void bindPlatformIcon(BankLotteryTaskInfo bankLotteryTaskInfo) {
        Integer valueOf;
        if (StringsKt.contains((CharSequence) bankLotteryTaskInfo.getTitle(), (CharSequence) ":telegram:", true) || StringsKt.contains((CharSequence) bankLotteryTaskInfo.getTitle(), (CharSequence) ":tg:", true)) {
            valueOf = Integer.valueOf(ru.mrlargha.commonui.R.drawable.ic_telegram);
        } else {
            valueOf = StringsKt.contains((CharSequence) bankLotteryTaskInfo.getTitle(), (CharSequence) ":vk:", true) ? Integer.valueOf(ru.mrlargha.commonui.R.drawable.vk_ic) : null;
        }
        this.platformIcon.setVisibility(valueOf == null ? 8 : 0);
        if (valueOf != null) {
            this.platformIcon.setImageResource(valueOf.intValue());
        }
    }

    private final void bindTaskBackground(BankLotteryTaskInfo bankLotteryTaskInfo) {
        Integer parseColorOrNull;
        ArrayList arrayList = new ArrayList();
        for (String str : bankLotteryTaskInfo.getBgColors()) {
            parseColorOrNull = BankLotteryPageControllerKt.parseColorOrNull(str);
            if (parseColorOrNull != null) {
                arrayList.add(parseColorOrNull);
            }
        }
        Integer num = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        int intValue = num != null ? num.intValue() : DEFAULT_TASK_BACKGROUND_COLOR;
        CustomCardView.setBackground$default(this.card, intValue, ColorUtils.setAlphaComponent(intValue, 128), 0, null, 8, null);
        this.card.setBackgroundAlpha(100);
        boolean completed = bankLotteryTaskInfo.getCompleted();
        CustomCardView customCardView = this.card;
        if (completed) {
            customCardView.setBorder(Color.parseColor("#B6FF00"));
            this.card.setBorderAlpha(100);
            return;
        }
        customCardView.setBorder(Color.parseColor("#5DE7FF"));
        this.card.setBorderAlpha(42);
    }

    /* compiled from: BankLotteryPageController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryTaskViewHolder$Companion;", "", "<init>", "()V", "DEFAULT_TASK_BACKGROUND_COLOR", "", "getDEFAULT_TASK_BACKGROUND_COLOR", "()I", "TASK_GRADIENT_END_ALPHA", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getDEFAULT_TASK_BACKGROUND_COLOR() {
            return BankLotteryTaskViewHolder.DEFAULT_TASK_BACKGROUND_COLOR;
        }
    }
}
