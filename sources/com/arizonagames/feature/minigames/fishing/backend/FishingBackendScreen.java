package com.arizonagames.feature.minigames.fishing.backend;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.utils.EasyAnimation;
import com.arizona.common.utils.GridItemDecoration;
import com.arizonagames.feature.minigames.fishing.backend.databinding.BackendGameLayoutBinding;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: FishingBackendScreen.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizonagames/feature/minigames/fishing/backend/FishingBackendScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lcom/arizonagames/feature/minigames/fishing/backend/databinding/BackendGameLayoutBinding;", "fishingAdapter", "Lcom/arizonagames/feature/minigames/fishing/backend/FishingAdapter;", "onBackendMessageHandled", "", "data", "", "subId", "setItems", "info", "Lcom/arizonagames/feature/minigames/fishing/backend/GameData;", "Spawner", "fishing-backend"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FishingBackendScreen extends SAMPUIElement {
    private final BackendGameLayoutBinding binding;
    private final FishingAdapter fishingAdapter;
    private final ConstraintLayout layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FishingBackendScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.backend_game_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        BackendGameLayoutBinding bind = BackendGameLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        FishingAdapter fishingAdapter = new FishingAdapter(new Function1() { // from class: com.arizonagames.feature.minigames.fishing.backend.FishingBackendScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FishingBackendScreen.fishingAdapter$lambda$0(FishingBackendScreen.this, ((Integer) obj).intValue());
            }
        });
        this.fishingAdapter = fishingAdapter;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.fishingRc.setAdapter(fishingAdapter);
        bind.fishingRc.addItemDecoration(new GridItemDecoration(0.132f, 0.22566f, 0.0f, 0.0f, 0.026f));
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, new Function0() { // from class: com.arizonagames.feature.minigames.fishing.backend.FishingBackendScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FishingBackendScreen.lambda$0$0(FishingBackendScreen.this);
            }
        }, null, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit fishingAdapter$lambda$0(FishingBackendScreen fishingBackendScreen, int i) {
        SAMPUIElement.notifyClick$default(fishingBackendScreen, i, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(FishingBackendScreen fishingBackendScreen) {
        SAMPUIElement.notifyClick$default(fishingBackendScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setItems(GameData gameData) {
        this.binding.mainTitle.setText(gameData.getTitle());
        this.binding.description.setText(gameData.getCaption());
        ArrayList arrayList = new ArrayList();
        int size = gameData.getCells().size();
        for (int i = 0; i < size; i++) {
            arrayList.add(gameData.getCells().get(i).get(0));
        }
        this.fishingAdapter.addItems(arrayList);
    }

    /* compiled from: FishingBackendScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/minigames/fishing/backend/FishingBackendScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "fishing-backend"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.FISHING_BACKEND);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new FishingBackendScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            if (MapperKt.isJsonValid(data)) {
                setItems((GameData) MapperKt.getGson().fromJson(data, (Class<Object>) GameData.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        }
    }
}
