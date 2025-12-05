package ru.mrlargha.commonui.elements.account_linking;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.utils.EasyAnimation;
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
import ru.mrlargha.commonui.databinding.LinkingLayoutBinding;
/* compiled from: LinkingScreen.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/account_linking/LinkingScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/LinkingLayoutBinding;", "onBackendMessage", "", "data", "", "subId", "Companion", "Spawner", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LinkingScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final LinkingLayoutBinding binding;
    private final ConstraintLayout layout;

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkingScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.linking_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        LinkingLayoutBinding bind = LinkingLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.account_linking.LinkingScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LinkingScreen.lambda$0$0(LinkingScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ConstraintLayout tgButton = bind.tgButton;
        Intrinsics.checkNotNullExpressionValue(tgButton, "tgButton");
        EasyAnimation.animateClick$default(easyAnimation2, tgButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.account_linking.LinkingScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LinkingScreen.lambda$0$1(LinkingScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ConstraintLayout vkButton = bind.vkButton;
        Intrinsics.checkNotNullExpressionValue(vkButton, "vkButton");
        EasyAnimation.animateClick$default(easyAnimation3, vkButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.account_linking.LinkingScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LinkingScreen.lambda$0$2(LinkingScreen.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(LinkingScreen linkingScreen) {
        SAMPUIElement.notifyClick$default(linkingScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(LinkingScreen linkingScreen) {
        SAMPUIElement.notifyClick$default(linkingScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(LinkingScreen linkingScreen) {
        SAMPUIElement.notifyClick$default(linkingScreen, 0, 2, null, 4, null);
        return Unit.INSTANCE;
    }

    /* compiled from: LinkingScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/mrlargha/commonui/elements/account_linking/LinkingScreen$Companion;", "", "<init>", "()V", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: LinkingScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/account_linking/LinkingScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.LINKING);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new LinkingScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
