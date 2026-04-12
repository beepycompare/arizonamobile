package ru.mrlargha.commonui.elements.hints;

import android.app.Activity;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.utils.EasyAnimation;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.HintsScreenBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: HintsScreen.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/HintsScreenBinding;", "setHintInfo", "", "info", "Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion$HintInfo;", "onBackendMessage", "data", "", "subId", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
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
                return HintsScreen.lambda$0$0(HintsScreen.this);
            }
        }, null, 5, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView leftHintCloseButton = bind.leftHintCloseButton;
        Intrinsics.checkNotNullExpressionValue(leftHintCloseButton, "leftHintCloseButton");
        EasyAnimation.animateClick$default(easyAnimation2, leftHintCloseButton, 0L, new Function0() { // from class: ru.mrlargha.commonui.elements.hints.HintsScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HintsScreen.lambda$0$1(HintsScreen.this);
            }
        }, null, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(HintsScreen hintsScreen) {
        SAMPUIElement.notifyClick$default(hintsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(HintsScreen hintsScreen) {
        SAMPUIElement.notifyClick$default(hintsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setHintInfo(Companion.HintInfo hintInfo) {
        HintsScreenBinding hintsScreenBinding = this.binding;
        SpannableString spannable$default = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, hintInfo.getHint(), 0.0f, 1, null);
        int position = hintInfo.getPosition();
        if (position == 0) {
            hintsScreenBinding.rightHint.setVisibility(8);
            hintsScreenBinding.leftHint.setVisibility(0);
            hintsScreenBinding.leftHintContainerText.setText(spannable$default);
            Picasso picasso = Picasso.get();
            String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(resourceUrl$default + "projects/arizona-rp/systems/quest_notify/" + hintInfo.getBackgroundImage()).into(hintsScreenBinding.leftHintPerson);
        } else if (position != 1) {
        } else {
            hintsScreenBinding.leftHint.setVisibility(8);
            hintsScreenBinding.rightHint.setVisibility(0);
            hintsScreenBinding.rightHintContainerText.setText(spannable$default);
            Picasso picasso2 = Picasso.get();
            String resourceUrl$default2 = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(resourceUrl$default2 + "projects/arizona-rp/systems/quest_notify/" + hintInfo.getBackgroundImage()).into(hintsScreenBinding.rightHintPerson);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setHintInfo((Companion.HintInfo) MapperKt.toModel(data, Companion.HintInfo.class));
        }
    }

    /* compiled from: HintsScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion;", "", "<init>", "()V", "HintInfo", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: HintsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Companion$HintInfo;", "", "hint", "", "position", "", "backgroundImage", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getHint", "()Ljava/lang/String;", "getPosition", "()I", "getBackgroundImage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/hints/HintsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.HINTS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new HintsScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
