package ru.mrlargha.commonui.elements.hints;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.HintsScreenBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HintsScreen.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/HintsScreenBinding;", "setHintInfo", "", "info", "Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion$HintInfo;", "onBackendMessage", "data", "", "subId", "toSpannable", "Landroid/text/SpannableString;", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HintsScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final HintsScreenBinding binding;
    private final ConstraintLayout layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HintsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.hints_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        HintsScreenBinding bind = HintsScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView rightHintCloseButton = bind.rightHintCloseButton;
        Intrinsics.checkNotNullExpressionValue(rightHintCloseButton, "rightHintCloseButton");
        EasyAnimation.animateClick$default(easyAnimation, rightHintCloseButton, 0L, new Function0() { // from class: ru.mrlargha.commonui.elements.hints.HintsScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HintsScreen.lambda$2$lambda$0(HintsScreen.this);
            }
        }, null, 5, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView leftHintCloseButton = bind.leftHintCloseButton;
        Intrinsics.checkNotNullExpressionValue(leftHintCloseButton, "leftHintCloseButton");
        EasyAnimation.animateClick$default(easyAnimation2, leftHintCloseButton, 0L, new Function0() { // from class: ru.mrlargha.commonui.elements.hints.HintsScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HintsScreen.lambda$2$lambda$1(HintsScreen.this);
            }
        }, null, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$0(HintsScreen hintsScreen) {
        SAMPUIElement.notifyClick$default(hintsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1(HintsScreen hintsScreen) {
        SAMPUIElement.notifyClick$default(hintsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setHintInfo(Companion.HintInfo hintInfo) {
        HintsScreenBinding hintsScreenBinding = this.binding;
        SpannableString spannable = toSpannable(hintInfo.getHint());
        int position = hintInfo.getPosition();
        if (position == 0) {
            hintsScreenBinding.rightHint.setVisibility(8);
            hintsScreenBinding.leftHint.setVisibility(0);
            hintsScreenBinding.leftHintContainerText.setText(spannable);
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "projects/arizona-rp/systems/quest_notify/" + hintInfo.getBackgroundImage()).into(hintsScreenBinding.leftHintPerson);
        } else if (position != 1) {
        } else {
            hintsScreenBinding.leftHint.setVisibility(8);
            hintsScreenBinding.rightHint.setVisibility(0);
            hintsScreenBinding.rightHintContainerText.setText(spannable);
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "projects/arizona-rp/systems/quest_notify/" + hintInfo.getBackgroundImage()).into(hintsScreenBinding.rightHintPerson);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setHintInfo((Companion.HintInfo) MapperKt.toModel(data, Companion.HintInfo.class));
        }
    }

    private final SpannableString toSpannable(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            Regex regex = new Regex("\\|[0-9A-z]*\\|");
            MatchResult find = regex.find(str, 0);
            i = 0;
            i2 = -1;
            i3 = -1;
            while (find != null) {
                try {
                    i4 = Color.parseColor('#' + StringsKt.substring(find.getValue(), new IntRange(1, 6)));
                } catch (NumberFormatException unused) {
                    i4 = -1;
                }
                if (i2 != -1) {
                    int i5 = i2 + 1;
                    spannableStringBuilder.append(str.subSequence(i5, find.getRange().getFirst()));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i5 - i, find.getRange().getFirst() - i, 34);
                } else {
                    String substring = str.substring(0, find.getRange().getFirst());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    spannableStringBuilder.append((CharSequence) substring);
                }
                i += 8;
                i2 = find.getRange().getLast();
                find = regex.find(str, find.getRange().getLast());
                i3 = i4;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("HintsScreen", "last index error");
        }
        if (i2 != -1) {
            int i6 = i2 + 1;
            spannableStringBuilder.append(str.subSequence(i6, StringsKt.getLastIndex(str) + 1));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6 - i, (StringsKt.getLastIndex(str) + 1) - i, 34);
            SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        return new SpannableString(str);
    }

    /* compiled from: HintsScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion;", "", "<init>", "()V", "HintInfo", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: HintsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion$HintInfo;", "", "hint", "", "position", "", "backgroundImage", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getHint", "()Ljava/lang/String;", "getPosition", "()I", "getBackgroundImage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class HintInfo {
            private final String backgroundImage;
            private final String hint;
            private final int position;

            public static /* synthetic */ HintInfo copy$default(HintInfo hintInfo, String str, int i, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = hintInfo.hint;
                }
                if ((i2 & 2) != 0) {
                    i = hintInfo.position;
                }
                if ((i2 & 4) != 0) {
                    str2 = hintInfo.backgroundImage;
                }
                return hintInfo.copy(str, i, str2);
            }

            public final String component1() {
                return this.hint;
            }

            public final int component2() {
                return this.position;
            }

            public final String component3() {
                return this.backgroundImage;
            }

            public final HintInfo copy(String hint, int i, String backgroundImage) {
                Intrinsics.checkNotNullParameter(hint, "hint");
                Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
                return new HintInfo(hint, i, backgroundImage);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HintInfo) {
                    HintInfo hintInfo = (HintInfo) obj;
                    return Intrinsics.areEqual(this.hint, hintInfo.hint) && this.position == hintInfo.position && Intrinsics.areEqual(this.backgroundImage, hintInfo.backgroundImage);
                }
                return false;
            }

            public int hashCode() {
                return (((this.hint.hashCode() * 31) + Integer.hashCode(this.position)) * 31) + this.backgroundImage.hashCode();
            }

            public String toString() {
                String str = this.hint;
                int i = this.position;
                return "HintInfo(hint=" + str + ", position=" + i + ", backgroundImage=" + this.backgroundImage + ")";
            }

            public HintInfo(String hint, int i, String backgroundImage) {
                Intrinsics.checkNotNullParameter(hint, "hint");
                Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
                this.hint = hint;
                this.position = i;
                this.backgroundImage = backgroundImage;
            }

            public final String getBackgroundImage() {
                return this.backgroundImage;
            }

            public final String getHint() {
                return this.hint;
            }

            public final int getPosition() {
                return this.position;
            }
        }

        private Companion() {
        }
    }

    /* compiled from: HintsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new HintsScreen(targetActivity, i);
        }
    }
}
