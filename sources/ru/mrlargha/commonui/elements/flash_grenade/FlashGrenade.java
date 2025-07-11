package ru.mrlargha.commonui.elements.flash_grenade;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.FlashGrenadeBinding;
/* compiled from: FlashGrenade.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/flash_grenade/FlashGrenade;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "flashGrenadeLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "flashGrenadeBinding", "Lru/mrlargha/commonui/databinding/FlashGrenadeBinding;", "animateFlash", "", "seconds", "onBackendMessage", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlashGrenade extends SAMPUIElement {
    private final FlashGrenadeBinding flashGrenadeBinding;
    private final ConstraintLayout flashGrenadeLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashGrenade(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.flash_grenade, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.flashGrenadeLayout = constraintLayout;
        FlashGrenadeBinding bind = FlashGrenadeBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.flashGrenadeBinding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
    }

    public final void animateFlash(int i) {
        FlashGrenadeBinding flashGrenadeBinding = this.flashGrenadeBinding;
        if (i == 0) {
            setVisibility(false);
            return;
        }
        setVisibility(true);
        flashGrenadeBinding.flashGrenade.setAlpha(1.0f);
        flashGrenadeBinding.flashGrenade.animate().alpha(0.0f).setStartDelay(1000L).setDuration(i * 1000).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.flash_grenade.FlashGrenade$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                super/*ru.mrlargha.commonui.core.SAMPUIElement*/.setVisibility(false);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            animateFlash(Integer.parseInt(data));
        }
    }

    /* compiled from: FlashGrenade.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/flash_grenade/FlashGrenade$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new FlashGrenade(targetActivity, i);
        }
    }
}
