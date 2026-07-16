package ru.mrlargha.commonui.elements.cinemaeffect;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.CinemaEffectPageBinding;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: CinemaEffectPage.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/cinemaeffect/CinemaEffectPage;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "cinemaEffectPage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "cinemaEffectPageBinding", "Lru/mrlargha/commonui/databinding/CinemaEffectPageBinding;", "timer", "Landroid/os/CountDownTimer;", "setVisibility", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CinemaEffectPage extends SAMPUIElement {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int SKIP_CLICK_ID = 0;
    @Deprecated
    public static final int SKIP_SUB_ID = 2;
    @Deprecated
    public static final int SKIP_VISIBLE = 1;
    private final ConstraintLayout cinemaEffectPage;
    private final CinemaEffectPageBinding cinemaEffectPageBinding;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CinemaEffectPage(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.cinema_effect_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.cinemaEffectPage = constraintLayout;
        CinemaEffectPageBinding bind = CinemaEffectPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.cinemaEffectPageBinding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.cinemaEffectSkip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.cinemaeffect.CinemaEffectPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CinemaEffectPage._init_$lambda$0(CinemaEffectPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(CinemaEffectPage cinemaEffectPage, View view) {
        CustomCardView cinemaEffectSkip = cinemaEffectPage.cinemaEffectPageBinding.cinemaEffectSkip;
        Intrinsics.checkNotNullExpressionValue(cinemaEffectSkip, "cinemaEffectSkip");
        cinemaEffectSkip.setVisibility(8);
        SAMPUIElement.notifyClick$default(cinemaEffectPage, 0, 2, null, 4, null);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        CustomCardView cinemaEffectSkip = this.cinemaEffectPageBinding.cinemaEffectSkip;
        Intrinsics.checkNotNullExpressionValue(cinemaEffectSkip, "cinemaEffectSkip");
        cinemaEffectSkip.setVisibility(8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            CinemaEffectPageBinding cinemaEffectPageBinding = this.cinemaEffectPageBinding;
            CustomCardView cinemaEffectSkip = cinemaEffectPageBinding.cinemaEffectSkip;
            Intrinsics.checkNotNullExpressionValue(cinemaEffectSkip, "cinemaEffectSkip");
            cinemaEffectSkip.setVisibility(8);
            cinemaEffectPageBinding.cinemaEffectTopShield.setTranslationY(-60.0f);
            cinemaEffectPageBinding.cinemaEffectBottomShield.setTranslationY(60.0f);
            cinemaEffectPageBinding.cinemaEffectText.setText("");
            return;
        }
        boolean z = true;
        if (i == 1) {
            String replace$default = StringsKt.replace$default(data, "\"", "", false, 4, (Object) null);
            CinemaEffectPageBinding cinemaEffectPageBinding2 = this.cinemaEffectPageBinding;
            cinemaEffectPageBinding2.cinemaEffectTopShield.animate().translationY(0.0f).setDuration(replace$default.length() * 110);
            cinemaEffectPageBinding2.cinemaEffectBottomShield.animate().translationY(0.0f).setDuration(replace$default.length() * 110);
            this.cinemaEffectPageBinding.cinemaEffectText.setText(replace$default);
        } else if (i != 2) {
        } else {
            CustomCardView cinemaEffectSkip2 = this.cinemaEffectPageBinding.cinemaEffectSkip;
            Intrinsics.checkNotNullExpressionValue(cinemaEffectSkip2, "cinemaEffectSkip");
            CustomCardView customCardView = cinemaEffectSkip2;
            Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.trim((CharSequence) data).toString(), '\"'));
            if (intOrNull == null || intOrNull.intValue() != 1) {
                z = false;
            }
            customCardView.setVisibility(z ? 0 : 8);
        }
    }

    /* compiled from: CinemaEffectPage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/cinemaeffect/CinemaEffectPage$Companion;", "", "<init>", "()V", "SKIP_SUB_ID", "", "SKIP_CLICK_ID", "SKIP_VISIBLE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CinemaEffectPage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/cinemaeffect/CinemaEffectPage$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CINEMA_EFFECT);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CinemaEffectPage(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
