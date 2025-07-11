package ru.mrlargha.rodina_ui.screens.excavation;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.ExcavationScreenBinding;
import ru.mrlargha.commonui.elements.excavation.Excavation;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: ExcavationScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/rodina_ui/screens/excavation/ExcavationScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "excavationScreen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "excavationBinding", "Lru/mrlargha/commonui/databinding/ExcavationScreenBinding;", "progressColors", "", "Landroid/graphics/drawable/Drawable;", "Lorg/jspecify/annotations/Nullable;", "Lkotlin/jvm/internal/EnhancedNullability;", "onBackendMessage", "", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExcavationScreen extends SAMPUIElement {
    private final ExcavationScreenBinding excavationBinding;
    private final View excavationScreen;
    private final List<Drawable> progressColors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExcavationScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View excavationScreen = targetActivity.getLayoutInflater().inflate(R.layout.excavation_screen, (ViewGroup) null);
        this.excavationScreen = excavationScreen;
        ExcavationScreenBinding bind = ExcavationScreenBinding.bind(excavationScreen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.excavationBinding = bind;
        Activity activity = targetActivity;
        this.progressColors = CollectionsKt.listOf((Object[]) new Drawable[]{ContextCompat.getDrawable(activity, R.drawable.progress_circle_red), ContextCompat.getDrawable(activity, R.drawable.progress_circle_green)});
        Intrinsics.checkNotNullExpressionValue(excavationScreen, "excavationScreen");
        addViewToConstraintLayout(excavationScreen, -1, -1);
        bind.rodinaExcavationProgressButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.rodina_ui.screens.excavation.ExcavationScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ExcavationScreen.this, 0, -1, null, 4, null);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            Excavation excavation = (Excavation) MapperKt.toModel(data, Excavation.class);
            ExcavationScreenBinding excavationScreenBinding = this.excavationBinding;
            excavationScreenBinding.rodinaExcavationProgress.setMax(excavation.getNeedProgress());
            int needProgress = excavation.getNeedProgress() - excavation.getRangeOffset();
            int needProgress2 = excavation.getNeedProgress() + excavation.getRangeOffset();
            int progress = excavation.getProgress();
            if (needProgress <= progress && progress <= needProgress2) {
                excavationScreenBinding.rodinaExcavationProgress.setProgressDrawable(this.progressColors.get(1));
                excavationScreenBinding.rodinaExcavationProgressDoneButton.setVisibility(0);
                excavationScreenBinding.rodinaExcavationProgressDoneButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.rodina_ui.screens.excavation.ExcavationScreen$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExcavationScreen.onBackendMessage$lambda$3$lambda$2(ExcavationScreen.this, view);
                    }
                });
            } else {
                excavationScreenBinding.rodinaExcavationProgressDoneButton.setVisibility(8);
                excavationScreenBinding.rodinaExcavationProgress.setProgressDrawable(this.progressColors.get(0));
            }
            excavationScreenBinding.rodinaExcavationProgress.setProgress(excavation.getProgress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$3$lambda$2(ExcavationScreen excavationScreen, View view) {
        SAMPUIElement.notifyClick$default(excavationScreen, 1, -1, null, 4, null);
    }

    /* compiled from: ExcavationScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/rodina_ui/screens/excavation/ExcavationScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ExcavationScreen(targetActivity, i);
        }
    }
}
