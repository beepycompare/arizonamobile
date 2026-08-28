package ru.mrlargha.commonui.elements.dialogs;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.InfoDialogBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: InfoDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u000234B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J \u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0005H\u0002J\f\u0010/\u001a\u000200*\u00020\u0007H\u0002J\u000e\u00101\u001a\u0004\u0018\u000102*\u00020\u0007H\u0002R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "info", "leftButtonText", "rightButtonText", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/InfoDialogBinding;", FirebaseAnalytics.Param.CONTENT, "Lru/mrlargha/commonui/elements/dialogs/ResolvedInfoDialogContent;", "parsedBody", "Lru/mrlargha/commonui/elements/dialogs/DialogListItemTabsContent;", "animatedBarContent", "Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBarContent;", "selectedTabIndex", "animatedBarAnimator", "Landroid/animation/ValueAnimator;", "setVisibility", "", "visible", "", "setupAnimatedBar", "startAnimatedBar", "setupListItemTabs", "setupButtons", "selectTab", FirebaseAnalytics.Param.INDEX, "renderListItemTabs", "updateListItemTab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "text", "Landroid/widget/TextView;", "selected", "dismiss", "responseButtonId", "resolveInfoDialogCaption", "Landroid/text/SpannableString;", "parseInfoDialogCaption", "Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "InfoDialogCaption", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialog extends AbstractDialog {
    private static final Companion Companion = new Companion(null);
    private static final int PRIMARY_BUTTON_ID = 1;
    private static final String SELECTED_TAB_BG = "#FFFFFF";
    private static final String SELECTED_TAB_BORDER = "#66FFFFFF";
    private static final String SELECTED_TAB_TEXT = "#1E1F24";
    private static final String UNSELECTED_TAB_BG = "#00FFFFFF";
    private static final String UNSELECTED_TAB_BORDER = "#00FFFFFF";
    private static final String UNSELECTED_TAB_TEXT = "#FFFFFF";
    private ValueAnimator animatedBarAnimator;
    private final InfoDialogAnimatedBarContent animatedBarContent;
    private final InfoDialogBinding binding;
    private final ResolvedInfoDialogContent content;
    private final View dialogLayout;
    private final DialogListItemTabsContent parsedBody;
    private int selectedTabIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoDialog(Activity targetActivity, int i, String caption, String info, String leftButtonText, String rightButtonText, int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.info_dialog, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        InfoDialogBinding bind = InfoDialogBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        ResolvedInfoDialogContent resolveInfoDialogContent = DialogListItemTabsKt.resolveInfoDialogContent(caption, info, leftButtonText, rightButtonText);
        this.content = resolveInfoDialogContent;
        DialogListItemTabsContent parseDialogListItemTabs$default = DialogListItemTabsKt.parseDialogListItemTabs$default(resolveInfoDialogContent.getBody(), 0, 2, null);
        this.parsedBody = parseDialogListItemTabs$default;
        InfoDialogAnimatedBarContent parseInfoDialogAnimatedBar = InfoDialogAnimatedBarKt.parseInfoDialogAnimatedBar(parseDialogListItemTabs$default.getText());
        this.animatedBarContent = parseInfoDialogAnimatedBar;
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog._init_$lambda$0(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -1, -1);
        bind.caption.setText(resolveInfoDialogCaption(resolveInfoDialogContent.getHeader()));
        bind.infoText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, parseInfoDialogAnimatedBar.getText(), 0.0f, null, 3, null));
        TextView infoText = bind.infoText;
        Intrinsics.checkNotNullExpressionValue(infoText, "infoText");
        infoText.setVisibility(StringsKt.isBlank(parseInfoDialogAnimatedBar.getText()) ? 8 : 0);
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
        setupAnimatedBar();
        setupListItemTabs();
        setupButtons();
        setVisibility(true);
        startAnimatedBar();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        ValueAnimator valueAnimator;
        if (!z && (valueAnimator = this.animatedBarAnimator) != null) {
            valueAnimator.cancel();
        }
        super.setVisibility(z);
    }

    private final void setupAnimatedBar() {
        InfoDialogBinding infoDialogBinding = this.binding;
        InfoDialogAnimatedBar animatedBar = this.animatedBarContent.getAnimatedBar();
        LinearLayout infoDialogAnimatedBar = infoDialogBinding.infoDialogAnimatedBar;
        Intrinsics.checkNotNullExpressionValue(infoDialogAnimatedBar, "infoDialogAnimatedBar");
        infoDialogAnimatedBar.setVisibility(animatedBar != null ? 0 : 8);
        if (animatedBar != null) {
            infoDialogBinding.infoDialogAnimatedBarLabel.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, animatedBar.getLabel(), 0.0f, null, 3, null));
            TextView infoDialogAnimatedBarLabel = infoDialogBinding.infoDialogAnimatedBarLabel;
            Intrinsics.checkNotNullExpressionValue(infoDialogAnimatedBarLabel, "infoDialogAnimatedBarLabel");
            infoDialogAnimatedBarLabel.setVisibility(StringsKt.isBlank(animatedBar.getLabel()) ? 8 : 0);
            infoDialogBinding.infoDialogAnimatedBarProgress.setPercentWidth(0.0f);
        }
    }

    private final void startAnimatedBar() {
        InfoDialogAnimatedBar animatedBar = this.animatedBarContent.getAnimatedBar();
        if (animatedBar == null) {
            return;
        }
        ValueAnimator valueAnimator = this.animatedBarAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(animatedBar.getDurationMs());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                InfoDialog.startAnimatedBar$lambda$0$0(InfoDialog.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.animatedBarAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimatedBar$lambda$0$0(InfoDialog infoDialog, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        CustomCardView customCardView = infoDialog.binding.infoDialogAnimatedBarProgress;
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        customCardView.setPercentWidth(((Float) animatedValue).floatValue());
    }

    private final void setupListItemTabs() {
        InfoDialogBinding infoDialogBinding = this.binding;
        CustomCardView infoDialogListItemTabs = infoDialogBinding.infoDialogListItemTabs;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabs, "infoDialogListItemTabs");
        infoDialogListItemTabs.setVisibility(!this.parsedBody.getTitles().isEmpty() ? 0 : 8);
        if (this.parsedBody.getTitles().isEmpty()) {
            return;
        }
        infoDialogBinding.infoDialogListItemTabPrimaryText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, this.parsedBody.getTitles().get(0), 0.0f, null, 3, null));
        CustomCardView infoDialogListItemTabSecondary = infoDialogBinding.infoDialogListItemTabSecondary;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabSecondary, "infoDialogListItemTabSecondary");
        infoDialogListItemTabSecondary.setVisibility(this.parsedBody.getTitles().size() > 1 ? 0 : 8);
        TextView textView = infoDialogBinding.infoDialogListItemTabSecondaryText;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String str = (String) CollectionsKt.getOrNull(this.parsedBody.getTitles(), 1);
        if (str == null) {
            str = "";
        }
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, str, 0.0f, null, 3, null));
        infoDialogBinding.infoDialogListItemTabPrimary.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.this.selectTab(0);
            }
        });
        infoDialogBinding.infoDialogListItemTabSecondary.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.this.selectTab(1);
            }
        });
        renderListItemTabs();
    }

    private final void setupButtons() {
        InfoDialogBinding infoDialogBinding = this.binding;
        if (StringsKt.isBlank(this.content.getPrimaryButton())) {
            infoDialogBinding.buttons.button1.setVisibility(8);
        } else {
            infoDialogBinding.buttons.tvAccept.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, this.content.getPrimaryButton(), 0.0f, null, 3, null));
            infoDialogBinding.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.this.dismiss(1);
                }
            });
        }
        if (StringsKt.isBlank(this.content.getSecondaryButton())) {
            infoDialogBinding.buttons.button2.setVisibility(8);
        } else {
            infoDialogBinding.buttons.tvCancel.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, this.content.getSecondaryButton(), 0.0f, null, 3, null));
            infoDialogBinding.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.this.dismiss(0);
                }
            });
        }
        infoDialogBinding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.this.dismiss(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectTab(int i) {
        if (i < 0 || i >= this.parsedBody.getTitles().size() || this.selectedTabIndex == i) {
            return;
        }
        this.selectedTabIndex = i;
        renderListItemTabs();
    }

    private final void renderListItemTabs() {
        InfoDialogBinding infoDialogBinding = this.binding;
        CustomCardView infoDialogListItemTabPrimary = infoDialogBinding.infoDialogListItemTabPrimary;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabPrimary, "infoDialogListItemTabPrimary");
        TextView infoDialogListItemTabPrimaryText = infoDialogBinding.infoDialogListItemTabPrimaryText;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabPrimaryText, "infoDialogListItemTabPrimaryText");
        updateListItemTab(infoDialogListItemTabPrimary, infoDialogListItemTabPrimaryText, this.selectedTabIndex == 0);
        CustomCardView infoDialogListItemTabSecondary = infoDialogBinding.infoDialogListItemTabSecondary;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabSecondary, "infoDialogListItemTabSecondary");
        TextView infoDialogListItemTabSecondaryText = infoDialogBinding.infoDialogListItemTabSecondaryText;
        Intrinsics.checkNotNullExpressionValue(infoDialogListItemTabSecondaryText, "infoDialogListItemTabSecondaryText");
        updateListItemTab(infoDialogListItemTabSecondary, infoDialogListItemTabSecondaryText, this.selectedTabIndex == 1);
    }

    private final void updateListItemTab(CustomCardView customCardView, TextView textView, boolean z) {
        String str = "#FFFFFF";
        customCardView.setBackground(Color.parseColor(z ? "#FFFFFF" : "#00FFFFFF"));
        customCardView.setBorder(Color.parseColor(z ? SELECTED_TAB_BORDER : "#00FFFFFF"));
        if (z) {
            str = SELECTED_TAB_TEXT;
        }
        textView.setTextColor(Color.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(int i) {
        ValueAnimator valueAnimator = this.animatedBarAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        getNotifier().onDialogResponseWrapper(getSampDialogId(), i, DialogListItemTabsKt.resolveDialogListItemTabResponse(i == 1, this.parsedBody.getTitles().size(), this.selectedTabIndex), new byte[0]);
        getNotifier().destroyDialog();
    }

    private final SpannableString resolveInfoDialogCaption(String str) {
        String text;
        SpannableString spannable$default;
        InfoDialogCaption parseInfoDialogCaption = parseInfoDialogCaption(str);
        return (parseInfoDialogCaption == null || (text = parseInfoDialogCaption.getText()) == null || (spannable$default = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, text, 0.0f, null, 3, null)) == null) ? ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str, 0.0f, null, 3, null) : spannable$default;
    }

    private final InfoDialogCaption parseInfoDialogCaption(String str) {
        Object m9920constructorimpl;
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) && StringsKt.endsWith$default(obj, "}", false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                JsonReader jsonReader = new JsonReader(new StringReader(obj));
                jsonReader.setStrictness(Strictness.LENIENT);
                InfoDialogCaption infoDialogCaption = (InfoDialogCaption) MapperKt.getGson().fromJson(jsonReader, InfoDialogCaption.class);
                jsonReader.close();
                m9920constructorimpl = Result.m9920constructorimpl(infoDialogCaption);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9926isFailureimpl(m9920constructorimpl) ? null : m9920constructorimpl;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InfoDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "", "text", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InfoDialogCaption {
        private final String text;
        private final Integer value;

        public InfoDialogCaption() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ InfoDialogCaption copy$default(InfoDialogCaption infoDialogCaption, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = infoDialogCaption.text;
            }
            if ((i & 2) != 0) {
                num = infoDialogCaption.value;
            }
            return infoDialogCaption.copy(str, num);
        }

        public final String component1() {
            return this.text;
        }

        public final Integer component2() {
            return this.value;
        }

        public final InfoDialogCaption copy(String str, Integer num) {
            return new InfoDialogCaption(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InfoDialogCaption) {
                InfoDialogCaption infoDialogCaption = (InfoDialogCaption) obj;
                return Intrinsics.areEqual(this.text, infoDialogCaption.text) && Intrinsics.areEqual(this.value, infoDialogCaption.value);
            }
            return false;
        }

        public int hashCode() {
            String str = this.text;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.value;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            String str = this.text;
            return "InfoDialogCaption(text=" + str + ", value=" + this.value + ")";
        }

        public InfoDialogCaption(String str, Integer num) {
            this.text = str;
            this.value = num;
        }

        public /* synthetic */ InfoDialogCaption(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getValue() {
            return this.value;
        }
    }

    /* compiled from: InfoDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog$Companion;", "", "<init>", "()V", "PRIMARY_BUTTON_ID", "", "SELECTED_TAB_BG", "", "UNSELECTED_TAB_BG", "SELECTED_TAB_BORDER", "UNSELECTED_TAB_BORDER", "SELECTED_TAB_TEXT", "UNSELECTED_TAB_TEXT", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
