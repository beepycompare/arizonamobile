package ru.mrlargha.arizonaui;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
/* compiled from: MenuBar.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/MenuBar;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "menuLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MenuBar extends SAMPUIElement {
    private final ConstraintLayout menuLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuBar(Activity activity, final int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        View inflate = activity.getLayoutInflater().inflate(R.layout.menu_bar, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.menuLayout = constraintLayout;
        SAMPUIElement.addViewToConstraintLayout$default(this, constraintLayout, 0, 0, 6, null);
        setPosition(SAMPUIElement.PositionType.LEFT_TOP, 300, 100);
        ((MaterialButton) constraintLayout.findViewById(R.id.menu)).setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.MenuBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuBar._init_$lambda$0(MenuBar.this, i, view);
            }
        });
        ((MaterialButton) constraintLayout.findViewById(R.id.escape)).setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.MenuBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuBar._init_$lambda$1(MenuBar.this, i, view);
            }
        });
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MenuBar menuBar, int i, View view) {
        menuBar.getNotifier().clickedWrapper(i, 0, -1);
        menuBar.setVisibility(true);
        Log.d("MrLargha", "Menu bar button clicked");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(MenuBar menuBar, int i, View view) {
        menuBar.getNotifier().clickedWrapper(i, 1, -1);
    }

    /* compiled from: MenuBar.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/MenuBar$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MenuBar(targetActivity, i);
        }
    }
}
