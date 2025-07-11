package ru.mrlargha.commonui.elements.cinemaeffect;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.CinemaEffectPageBinding;
/* compiled from: CinemaEffectPage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/cinemaeffect/CinemaEffectPage;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "cinemaEffectPage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "cinemaEffectPageBinding", "Lru/mrlargha/commonui/databinding/CinemaEffectPageBinding;", "timer", "Landroid/os/CountDownTimer;", "onBackendMessage", "", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CinemaEffectPage extends SAMPUIElement {
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
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            CinemaEffectPageBinding cinemaEffectPageBinding = this.cinemaEffectPageBinding;
            cinemaEffectPageBinding.cinemaEffectTopShield.setTranslationY(-60.0f);
            cinemaEffectPageBinding.cinemaEffectBottomShield.setTranslationY(60.0f);
            cinemaEffectPageBinding.cinemaEffectText.setText("");
        } else if (i != 1) {
        } else {
            String replace$default = StringsKt.replace$default(data, "\"", "", false, 4, (Object) null);
            CinemaEffectPageBinding cinemaEffectPageBinding2 = this.cinemaEffectPageBinding;
            cinemaEffectPageBinding2.cinemaEffectTopShield.animate().translationY(0.0f).setDuration(replace$default.length() * 110);
            cinemaEffectPageBinding2.cinemaEffectBottomShield.animate().translationY(0.0f).setDuration(replace$default.length() * 110);
            this.cinemaEffectPageBinding.cinemaEffectText.setText(replace$default);
        }
    }

    /* compiled from: CinemaEffectPage.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/cinemaeffect/CinemaEffectPage$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CinemaEffectPage(targetActivity, i);
        }
    }
}
